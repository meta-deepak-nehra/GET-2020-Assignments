import java.util.ArrayList;

public final class IntSet 
{
	private int[] setOfValues;
	private int lengthOfSet;
	
	/**
	 * Parameterized constructor
	 * @param arrayToSetValues Passed as argument of constructor
	 */
	public IntSet(int[] arrayToSetValues)
	{
		if(arrayToSetValues.length==0)
		{
			System.out.println("Set is null. Can't perform any operation.");
			System.exit(0);
		}
		lengthOfSet=arrayToSetValues.length;
		setOfValues=new int[lengthOfSet];
		setOfValues=arrayToSetValues.clone();
	}
	
	/**
	 * Function will check that given element is in set or not
	 * @param value Element which we have to check.
	 * @return Return True if it present else return False
	 */
	public boolean isMemberOfSet(int value)
	{
		for (int i=0;i<lengthOfSet;i++)
		{
			if(setOfValues[i]==value)
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check the size of the set.
	 * @return Returns the size of the set.
	 */
	int size()
	{
		return setOfValues.length;
	}
	
	/**
	 * Checks whether the given set is subset or not
	 * @param s subset passed as argument for checking 
	 * @return Return True if it is subset else false
	 */
	public boolean isSubSet(int[] s)
	{
		int lengthOfSubset= s.length,lengthOfSet= setOfValues.length;
		for(int i=0;i<lengthOfSubset;i++)
		{
			for(int j= 0; j<lengthOfSet;j++ )
			{
				if(setOfValues[j] == s[i])
				{
					break;
				}
				if(j==lengthOfSet-1)
				{
					return false;
				}
			}	
		}
		return true;
	}
	
	/**
	 * Gives us the complement of the set
	 * @return Return a set which is complement of given set
	 */
	public int[] getComplement()
	{
		int targetSetLength=setOfValues.length;
		int[] complementArray=new int[100-targetSetLength];
		int complementArrayIndex=0;
		for (int i=1;i<=100;i++)
		{
			boolean flag = false;
		    for(int j=0;j<targetSetLength;j++)
		    {
	         	if(setOfValues[j]==i)
		        {
		          flag= true;
		          break;
		        }
		     }
		    if(flag!=true)
		    {
		        complementArray[complementArrayIndex]=i;
		        complementArrayIndex++;
		    }
		}
		return complementArray;
	}

	/**
	 * Gives us union of two sets
	 * @param set1 Set one for the union given as argument
	 * @param set2 Set two for the union given as argument
	 * @return Return the union of these two sets
	 */
	public int[] union(int[] set1,int[] set2)
    {
		int[] resultArray={};
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        for(int element : set1)
            arrayList.add(Integer.valueOf(element));
        
        for(int element:set2)
        {
            if(! arrayList.contains(element))
            {
                arrayList.add(Integer.valueOf(element));
            }
        }
        resultArray = arrayList.stream().mapToInt(i->i).toArray();

    	return  resultArray;
    }
}
