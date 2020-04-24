package zooManagement;

/**
 * store the peacock attribute.
 * @author Deepak
 *
 */
public class Peacock extends Bird
{

	public Peacock(String name, String animalType, String sound, int age, double weight, String uniqueIdOfAnimal )
	{
		this.name = name;
		this.age = age;
		this.animalType =animalType;
		this.sound = sound;
		this.weight = weight;
		this.uniqueIdOfAnimal = uniqueIdOfAnimal;
		this.typeOfBird = "Omnivorous";
	}
	@Override
	public String getAnimalSound() 
	{
	    return sound;
	}

}