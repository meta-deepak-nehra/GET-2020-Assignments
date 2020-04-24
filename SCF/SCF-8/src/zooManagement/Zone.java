package zooManagement;

import java.util.LinkedList;
import java.util.List;

/**
 * Store the cage list of particular zone object.
 * @author Deepak
 *
 */
public class Zone
{
    final private CategoryOfAnimals zoneType;
    final private int uniqueZoneId;
    private boolean hasPark, hasCanteen;
    private List<Cage> cageList = new LinkedList<Cage>();
    int maxCapacityOfCageInZone;
    
    public Zone(CategoryOfAnimals zoneType, int maxCapacityOfCageInZone, boolean park, boolean canteen, int uniqueZoneId )
    {
    	this.zoneType = zoneType;
    	this.maxCapacityOfCageInZone = maxCapacityOfCageInZone;
    	this.setHasPark(park);
    	this.setHasCanteen(canteen);
    	this.uniqueZoneId = uniqueZoneId;
    }

	public CategoryOfAnimals getZoneType() 
	{
		return zoneType;
	}
	
	public int getCountOfCagePresent()
	{
		return this.cageList.size();
	}
	
	public List<Cage> getCageList()
	{
		return cageList;
	}
	
	public boolean isSpaceAvailable()
	{
		return cageList.size() == maxCapacityOfCageInZone ? false : true;
	}

	public boolean isHasPark() {
		return hasPark;
	}

	public void setHasPark(boolean hasPark) {
		this.hasPark = hasPark;
	}

	public boolean isHasCanteen() {
		return hasCanteen;
	}

	public void setHasCanteen(boolean hasCanteen) {
		this.hasCanteen = hasCanteen;
	}

	public int getUniqueZoneId() {
		return uniqueZoneId;
	}
    
}