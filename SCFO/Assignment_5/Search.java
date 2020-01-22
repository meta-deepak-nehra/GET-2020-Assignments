import java.util.Arrays;


public class Search 
{
	int linearSearch(int[] arr,int value)
	{
		int lengthOfArray=arr.length;
		if(lengthOfArray<=0)
			System.out.println("Value is not present in array");
		else if(arr[lengthOfArray-1]==value)
			return lengthOfArray-1;
		int copyOfArray[]=Arrays.copyOfRange(arr, 0,lengthOfArray-1 );
		return linearSearch(copyOfArray,value);
	}
	
//	public static void main(String[] args) 
//	{
//		int b[]={1,2,3,4,5,6,7,8};
//		int t=binarySearch(b,9,0,7);
//		System.out.println("rfgr "+ t);
//		
//	}
	static int binarySearch(int[] arr,int valueToSearch, int firstPosition, int lastPosition)
	{
		int middlePosition=(lastPosition+firstPosition)/2;
		
		if(firstPosition>=lastPosition)
		{
			System.out.println("Value is not present in array");
			return -1;
		}
		
		if(arr[middlePosition]==valueToSearch)
			return middlePosition+1;
		else if(arr[middlePosition]<valueToSearch)
		{
			return binarySearch(arr ,valueToSearch,middlePosition+1,lastPosition);
		}
		else// if(arr[middlePosition]>valueToSearch)
		{
			return binarySearch(arr ,valueToSearch,firstPosition,middlePosition-1);
		}
//		else 
//			return -1;
//		return 0;
	}
}
