import java.util.ArrayList;

public final class IntSet 
{
	private int[] setOfValues;
	private int lengthOfSet;
	
	public void setDataToTheArray(int[] arrayToSetValues)
	{
		if(arrayToSetValues.length==0)
		{
			System.out.println("Set is null. Can't perform any operation.");
			System.exit(0);
		}
		lengthOfSet=arrayToSetValues.length;
		setOfValues=new int[lengthOfSet];
		for(int i=0;i<arrayToSetValues.length;i++)
			setOfValues[i] = arrayToSetValues[i];
		setOfValues=arrayToSetValues.clone();
	}
	
	public boolean isMemberOfSet(int value)
	{
	//	int length = setOfValues.length;
		for (int i=0;i<lengthOfSet;i++)
		{
			if(setOfValues[i]==value)
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
	
	public int[] getComplement()
	{
		int targetSetLength=setOfValues.length;
		int[] complementArray=new int[100-targetSetLength];
		//int complementArrayIndex=0;
//		for (int i=1;i<=100;i++)
//		{
//			boolean flag = false;
//		    for(int j=0;j<targetSetLength;j++)
//		    {
//	         	if(setOfValues[j]==i)
//		        {
//		          flag= true;
//		          break;
//		        }
//		     }
//		    if(flag!=true)
//		    {
//		        complementArray[complementArrayIndex]=i;
//		        complementArrayIndex++;
//		    }
//		}
		int j=0;
		for(int i=1;i<=100;i++){
			if(!isMemberOfSet(i)){
				complementArray[j]=i;
				j++;
			}
		}
		return complementArray;
	}
	
	/*public static void main(String[] args) 
	{
		int a[]={1,2,13,4};
		int b[]={5,6,7,8,9,0};
		union(a,b);
	}*/
	
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
        
//        for(int element:resultArray)
//        	System.out.println(element);
    	
    	return  resultArray;
    }
}
