package zooManagement;

/**
 * Store the lion attribute.
 * @author Deepak
 *
 */
public class Lion extends Mammal
{
	public Lion(String name, String animalType, String sound, int age, double weight, String uniqueIdOfAnimal )
	{
		this.name = name;
		this.animalType = animalType;
		this.sound = sound;
		this.age = age;
		this.weight = weight;
		this.uniqueIdOfAnimal = uniqueIdOfAnimal;
		this.typeOfMammal = "carnivorous";
	}
	
	@Override
	public String getAnimalSound()
	{
		return sound;
	}
    
}