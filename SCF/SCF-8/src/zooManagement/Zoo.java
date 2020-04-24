package zooManagement;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Class have method for zoo operation.
 * @author Deepak
 *
 */
public class Zoo 
{
	private int uIdZone = 1, uIdCage = 1;
	private boolean zoneFlag = false, cageFlag = false;

	Map<Integer, Zone> zoneMap = new LinkedHashMap<Integer, Zone>();
	Map<Integer, Cage> cageMap = new LinkedHashMap<Integer, Cage>();
	Map<String, Animal> animalMap = new LinkedHashMap<String, Animal>();

	Scanner scanner = new Scanner(System.in);

	public Zoo() 
	{	
		addZone();
		addCage();
		getAnimalDetails();
		removeAnimal();
	}

	/**
	 * method used for take input about animal.
	 */
	private void getAnimalDetails() 
	{
		if (zoneFlag == true && cageFlag == true) 
		{
		  try
		  {
			int indexNumber = 1;
			System.out.println("Enter animal Name from below list:");
			System.out.println("index\t\tNames\n");

			for (AnimalsName value : AnimalsName.values()) 
			{
				System.out.println(indexNumber + "\t\t" + value.name());
				indexNumber++;
			}
			System.out.println();

			String name = scanner.next();
			boolean flag = false;
			for (AnimalsName value : AnimalsName.values())
			{

				if (name.equalsIgnoreCase(value.name()))
				{
					name = value.name();
					flag = true;
					break;
				}
			}
			
			if(flag == false)
			{
				System.out.println("Enter input is worng. plaese again enter the information");
				getAnimalDetails();
			}
			
			indexNumber = 1;
			System.out.println("Enter animal category from list:\n");
			System.out.println("index\t\tCategory\n");
			for (CategoryOfAnimals value : CategoryOfAnimals.values()) 
			{
				System.out.println(indexNumber + "\t\t" + value.name());
				indexNumber++;
			}
			System.out.println();
			String animalCategory = scanner.next();
			
                        flag = false;
			for (CategoryOfAnimals value : CategoryOfAnimals.values()) 
			{
				if (animalCategory.equalsIgnoreCase(value.name())) 
				{
					animalCategory = value.name();
					flag = false;
					break;
				}
			}
			if(flag == false)
			{
				System.out.println("Enter input is worng. plaese again enter the information");
				getAnimalDetails();
			}
			
			System.out.println("Enter age of the animal:");
			int ageOfAnimal = scanner.nextInt();
			System.out.println("Enter the weight of the animal:");
			double weight = scanner.nextDouble();
			System.out.println("Enter the type of sound animal make (eg. Lion Roars):");
			String soundOfAnimal = scanner.next();
			String animalUniqueId = uniqueIdGenerator();

			Animal newAnimal = AnimalObjectFactory.getAnimalObject(name, animalCategory, soundOfAnimal, ageOfAnimal, weight, animalUniqueId);
			int status = addAnimal(newAnimal);
			if (status == 1) 
			{
				System.out.println("Animal get added !");
			}
		  }
		  catch(Exception e)
		  {
			  System.out.println(e);
		  }
	      }	 
		  else 
		  {
			System.out.println("There is no zone or cage present in the zoo. Please add a zone and cage first!");
		  }
	}

	/*
	 * method adds the animal in the cage of the zone
	 * @param animal object
	 * @return 1 if animal is added successfully else return 0
	 */
	private int addAnimal(Animal animal) 
	{
		System.out.println("Enter the zone Id in which you want to add this animal:");
		int zoneId = scanner.nextInt();
		int indexTraversed = 0;
		Zone zone = zoneMap.get(zoneId);
		if (zone != null)
		{
			List<Cage> cagesList = zone.getCageList();
			try {
				for (Cage cage : cagesList) 
				{
					indexTraversed++;
					if (cage.getTypeOfAnimalInCage().equalsIgnoreCase(animal.name) && cage.isSpaceAvailable()) 
					{
						cage.animalList.add(animal);
						animalMap.put(animal.uniqueIdOfAnimal, animal);
						System.out.println("Animal added successfully in cage with cage Id" + cage.getUniqueIdOfCage());
						break;
					}
					else
					{
						if (indexTraversed == cagesList.size())
						{
							if (zone.isSpaceAvailable()) 
							{
								System.out.println("System is adding a new cage for this animal as there is no capacity in existing cages !");
								Cage cage1 = new Cage(animal.animalType, 5, uIdCage);
								uIdCage++;
								zone.getCageList().add(cage1); // a new cage is created and added in the cage list of the zone
								cageMap.put(uIdCage, cage1); // cageMap is updated with newly created cage
								cage1.animalList.add(animal);
								animalMap.put(animal.uniqueIdOfAnimal, animal);
								System.out.println("Animal added successFully. Please note animal Id: " + animal.uniqueIdOfAnimal	+ " and cage Id: " + cage1.getUniqueIdOfCage());
							}
							else 
							{
								System.out.println("No more animals can be added !");
								return 0;
							}
						}
					}
				}
			}
			catch (Exception e) 
			{
                             System.out.println(e);
			}
		}
		else 
		{
			System.out.println("error in adding this animal");
			return 0;
		}

		return 1;
	}

	/*
	 * method to remove animal from zoo
	 */
	private int removeAnimal() 
	{
		System.out.println("Enter animal id: ");
		String animalId = scanner.next();
		Animal animalObj = animalMap.get(animalId);
		if (animalObj != null)
		{
			System.out.println("Enter cage id in which animal is there: ");
			int cageId = scanner.nextInt();
			Cage cage = cageMap.get(cageId);
			if (cage != null)
			{
				List<Animal> listOfanimals = cage.animalList;
				for (Animal animal : listOfanimals)
				{
					if (animal.uniqueIdOfAnimal.equals(animalId))
					{
						cage.animalList.remove(animal);
						animalMap.remove(animal.uniqueIdOfAnimal);
					}
				}
			} 
			else 
			{
				System.out.println("Incorrect cageId");
				return 0;
			}
		}
		else 
		{
			System.out.println("Incorrect animal Id");
			return 0;
		}
		
		return 1;
	}
	
	/**
	 * Add new Zone in zoo.
	 * @return
	 */
	public int addZone() 
	{
		zoneFlag = true;
		CategoryOfAnimals zoneType;
		boolean hasPark = false, hasCanteen = false;
		System.out.println("Select Zone Type");
		System.out.println("1. Mammal \n 2. Reptile \n 3. Bird");

		try {
			switch (scanner.nextInt()) 
			{
			case 1:
				zoneType = CategoryOfAnimals.MAMMAL;
				break;
			case 2:
				zoneType = CategoryOfAnimals.REPTILE;
				break;
			case 3:
				zoneType = CategoryOfAnimals.BIRD;
				break;
			default:
				System.out.println("Invalid zone type");
				return 0;
			}

			for (Zone value : zoneMap.values()) 
			{
				if (zoneType == value.getZoneType()) 
				{
					System.out.println("This zone already available on Zoo, can't add zone.");

				}
			}

			System.out.println("Enter no of cage to be stored in this zone");
			int maxCageStorageCapacityOfZone = scanner.nextInt();

			System.out.println("Does zone have a park ? \n Enetr 'y' for Yes and 'n' for No");
			char choice = scanner.next().charAt(0);
			if (choice == 'y' || choice == 'Y')
			{
				hasPark = true;
			}

			System.out.println("Does zone have a Canteen ? \n Enetr 'y' for Yes and 'n' for No");
			choice = scanner.next().charAt(0);
			if (choice == 'y' || choice == 'Y') 
			{
				hasCanteen = false;
			}

			Zone zone = new Zone(zoneType, maxCageStorageCapacityOfZone, hasPark, hasCanteen, uIdZone);
			zoneMap.put(uIdZone, zone);
			uIdZone++;
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return 1;
	}

	/**
	 * Add new cage in zone
	 */
	public int addCage()
	{
		if (zoneFlag == true) 
		{
			cageFlag = true;
			System.out.println("Please enter zone name and ZoneID where you want to add cage.");
			System.out.print("zone list \n we have ");
			for (Zone value : zoneMap.values()) 
			{
				System.out.print(value.getZoneType() + "(ZoneID:" + value.getUniqueZoneId() + "), \t");
			}

			String zoneName = scanner.next();
			int zoneId = scanner.nextInt();

			Zone zone = zoneMap.get(zoneId);

			if (zone == null) 
			{
				System.out.println("Given zone id is worng or not avilable on zone. Please reEnter the information of zone.");
				addCage();
			}

			if (zone.getCountOfCagePresent() == zone.maxCapacityOfCageInZone)
			{
				System.out.println("No space For adding more Cages.");
			}
			else 
			{
				try
				{
					System.out.println("Please Enter Animal Type For Cage");
					String animalTypeForCage = scanner.next();

					System.out.println("Please Enter capacity of this cage:");
					int cageCapacity = scanner.nextInt();

					Cage cage = new Cage(animalTypeForCage, cageCapacity, uIdCage);
					zone.getCageList().add(cage); // a new cage is created and added in the cage list of the zone
					cageMap.put(uIdCage, cage); // cageMap is updated with newly created cage

					System.out.println("Cage Successfully Added Unique id Of Cage is " + uIdCage);
					uIdCage++;
				} 
				catch (Exception e) 
				{
					System.out.println(e);
				}
			}
		}

		return 1;
	}
  
	/**
	 * Generate random id.
	 * @return  Unique id.
	 */
	private String uniqueIdGenerator()
	{
		String uniqueId="animal";
		for(int i=1;i<=3;i++) 
		{
			uniqueId += String.valueOf((int)(Math.random()*10));
	    }
		
		return uniqueId;
	}
}