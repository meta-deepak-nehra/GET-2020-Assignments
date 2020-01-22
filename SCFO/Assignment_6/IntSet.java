import java.util.ArrayList;

public final class IntSet 
{
	private int[] setOfValues;

	
	void setDataToTheArray(int[] arrayToSetValues)
	{
		if(arrayToSetValues.length==0)
		{
			System.out.println("Set is null. Can't perform any operation.");
		}
		setOfValues = arrayToSetValues;
	}
	
	boolean isMember(int value)
	{
		int length = setOfValues.length;
		for (int i=0;i<=length;i++)
		{
			if(value == setOfValues[i])
			{
				return true;
			}
		}
		return false;
	}
	
	int size()
	{
		return setOfValues.length;
	}
	
	boolean isSubSet(int[] s)
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
	
	int[] getComplement()
	{
		int targetSetLength = setOfValues.length;
		int[] complementArray = new int [1000 - targetSetLength];
		int complementArrayIndex = 0;
		for (int i=0;i<=1000;i++)
		{
			boolean flag = false;
		    for(int j = 0; j < this.size(); j++)
		    {
	         	if(setOfValues[j] == i)
		        {
		          flag = true;
		          break;
		        }
		     }
		    if(flag != true)
		    {
		        complementArray[complementArrayIndex] = i;
		        complementArrayIndex++;
		    }
		}
		return complementArray;
	}
	
	public static void main(String[] args) 
	{
		int a[]={1,2,13,4};
		int b[]={5,6,7,8,9,0};
		union(a,b);
	}
	
	static int[] union(int[] set1,int[] set2)
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
        
        for(int element:resultArray)
        	System.out.println(element);
    	
    	return  resultArray;
    }
}
