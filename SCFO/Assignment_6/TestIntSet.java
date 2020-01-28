import static org.junit.Assert.*;
import org.junit.Test;

public class TestIntSet 
{
	int[] temp=new int[]{3,4,6,7,9};
	@Test
	public void testForMemberOfSet()
	{
		int[] temp=new int[]{3,4,6,7,9};
		IntSet obj= new IntSet(temp);
		boolean resultMemberOfSet=obj.isMemberOfSet(7);
		assertEquals(true,resultMemberOfSet);
		
		temp=new int[]{3,5,6,8,9};
		IntSet obj1=new IntSet(temp);
		resultMemberOfSet=obj1.isMemberOfSet(33);
		assertEquals(false,resultMemberOfSet);
		
		temp=new int[]{3,4,6,7,0};
		IntSet obj2=new IntSet(temp);
		resultMemberOfSet=obj2.isMemberOfSet(3);
		assertEquals(true,resultMemberOfSet);
	}
	
	@Test
	public void testForSize()
	{
		int[] temp=new int[]{3,4,6,7,9};
		IntSet obj= new IntSet(temp);
		int resultSizeOfSet=obj.size();
		assertEquals(5,resultSizeOfSet);
		
		temp=new int[]{3,5,6,8,9};
		IntSet obj1=new IntSet(temp);
		resultSizeOfSet=obj1.size();
		assertEquals(5,resultSizeOfSet);
		
		temp=new int[]{3,4,6,7,0};
		IntSet obj2=new IntSet(temp);
		resultSizeOfSet=obj2.size();
		assertEquals(5,resultSizeOfSet);
	}
	
	@Test
	public void testForSubset()
	{
		int[] temp=new int[]{3,4,6,7,9};
		IntSet obj= new IntSet(temp);
		boolean resultIsSubset=obj.isSubSet(new int[]{4,6,8});
		assertEquals(false,resultIsSubset);
		
		temp=new int[]{3,4,6,7,9};
		IntSet obj1= new IntSet(temp);
		resultIsSubset=obj1.isSubSet(new int[]{4,6});
		assertEquals(true,resultIsSubset);
		
		temp=new int[]{3,4,5,7,8,9};
		IntSet obj2=new IntSet(temp);
		resultIsSubset=obj2.isSubSet(new int[]{4,6,5,7,8});
		assertEquals(false,resultIsSubset);
	}
	
	@Test
	public void testOfComplement()
	{
		int[] temp=new int[]{3,4,5,7,8,9};
		IntSet obj=new IntSet(temp);
		int[] resultComplementSet=obj.getComplement();
		int[] resultArray = new int[]{ 1,2,6,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
		assertArrayEquals(resultArray, resultComplementSet);
		
		temp=new int[]{3,4,5,7,8,19,41,22};
		IntSet obj1=new IntSet(temp);
		resultComplementSet=obj1.getComplement();
		resultArray = new int[]{ 1,2,6,9,10,11,12,13,14,15,16,17,18,20,21,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
		assertArrayEquals(resultArray,resultComplementSet);
		
		temp=new int[]{13,24,35,47,58,69};
		IntSet obj2=new IntSet(temp);
		resultComplementSet=obj2.getComplement();
		resultArray = new int[]{ 1,2,3,4,5,6,7,8,9,10,11,12,14,15,16,17,18,19,20,21,22,23,25,26,27,28,29,30,31,32,33,34,36,37,38,39,40,41,42,43,44,45,46,48,49,50,51,52,53,54,55,56,57,59,60,61,62,63,64,65,66,67,68,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100};
		assertArrayEquals(resultArray,resultComplementSet);
	}
	
	@Test
	public void testOfUnion()
	{
		IntSet obj= new IntSet(temp);
		int[] resultUnionSet=obj.union(new int[]{3,4,5,7}, new int[]{19,41,22});
		int[] resultUnion=new int[]{3,4,5,7,19,41,22};
		assertArrayEquals(resultUnion,resultUnionSet);
		
		resultUnionSet=obj.union(new int[]{3,1,7}, new int[]{19,51,41});
		resultUnion=new int[]{3,1,7,19,51,41};
		assertArrayEquals(resultUnion,resultUnionSet);
		
		resultUnionSet=obj.union(new int[]{31,1,17}, new int[]{65,51,41});
		resultUnion=new int[]{31,1,17,65,51,41};
		assertArrayEquals(resultUnion,resultUnionSet);
	}
}
