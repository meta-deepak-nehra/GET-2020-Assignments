package zooManagement;

import java.util.List;
import java.util.LinkedList;

/**
 *  Store the animals list of particular cage. object.
 * @author Deepak
 *
 */
public class Cage 
{
   List<Animal> animalList  = new LinkedList<Animal>();
   final private int maxCapacityOfCage;
   private String typeOfAnimalInCage;
   final private int uniqueIdOfCage;
 
   public Cage(String animalTypeInCage, int maxCapacityOfCage, int uniqueIdOfCage)
   {
	   this.typeOfAnimalInCage = animalTypeInCage;
	   this.maxCapacityOfCage = maxCapacityOfCage;
	   this.uniqueIdOfCage = uniqueIdOfCage;
   }
   
  
   public int getAnimalCountInCage()
   {
	   return animalList.size();
   }

   public int getMaxCapacityOfCage() 
   {
	return maxCapacityOfCage;
   }

   public int getUniqueIdOfCage() 
   {
	return uniqueIdOfCage;
   }

   public String getTypeOfAnimalInCage() 
   {
	  return typeOfAnimalInCage;
   }

  public boolean isSpaceAvailable()
  {
	 return (maxCapacityOfCage > animalList.size()) ? true : false;
  }
   
   
   
}