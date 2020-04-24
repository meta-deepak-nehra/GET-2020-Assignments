package zooManagement;

/**
 *  Store the Crocodile attribute. 
 * @author Deepak
 *
 */
public class Crocodile extends Reptile
{
   public Crocodile(String name, String animalType, String sound, int age, double weight, String uniqueIdOfAnimal)
   {
	   this.name = name;
	   this.animalType = animalType;
	   this.sound = sound;
	   this.age = age;
	   this.weight = weight;
	   this.uniqueIdOfAnimal = uniqueIdOfAnimal;
	   this.typeOfReptile = "carnivorous";
   }

   @Override
   public String getAnimalSound() 
   {
	return sound;
   }
}

