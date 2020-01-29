import static org.junit.Assert.*;
import org.junit.Test;

public class TestSparseMatrix 
{
	int[][] temp=new int[][]{{0,1,0},{0,1,0},{1,0,1}};
	SparseMatrix obj = new SparseMatrix(temp);
	
	@Test
	public void testToCheckPerformingTransposeOfMatrix()
	{
		SparseMatrix obj = new SparseMatrix(new int[][] {{1,0,0},{0,2,0},{0,0,1}});
		int expected[][] = new int[][]{{1,0,0},{0,2,0},{0,0,1}};
		int result[][] = obj.performTransposeOfMatrix();
		assertArrayEquals(expected, result);
	}
	
	@Test
	public void testToCheckSymmetryOfMatrix()
	{
		int[][] temp=new int[][]{{1,0,0},{0,2,0},{0,0,1}};
		SparseMatrix obj = new SparseMatrix(temp);
		int[][] transposedMatrix=obj.performTransposeOfMatrix();
		boolean result = obj.checkSymmetryOfMatrix(transposedMatrix);
		assertEquals(true, result);
	}
	
	@Test
	public void testToCheckAdditionOfMatrix()
	{
		int[][] temp=new int[][]{{1,0,0},{0,2,0},{0,0,1}};
		int[][] temp1=new int[][]{{3,0,5},{0,2,0},{0,0,1}};
		SparseMatrix obj = new SparseMatrix(temp);
		int[][] addExpected = new int[][]{{4,0,5},{0,4,0},{0,0,2}};
		int[][] additionResult=obj.addTwoMatrices(temp, temp1);
		assertArrayEquals(addExpected, additionResult);
	}
	
	@Test
	public void testToCheckMultiplyOfMatrix()
	{
		int[][] temp=new int[][]{{1,0,0},{0,2,0},{0,0,1}};
		int[][] temp1=new int[][]{{3,0,5},{0,2,0},{0,0,1}};
		SparseMatrix obj=new SparseMatrix(temp);
		int[][] multiExpected=new int[][]{{3,0,5},{0,4,0},{0,0,1}};
		int[][] multiplicationResult=obj.multiplyTwoMatrices(temp, temp1);
		assertArrayEquals(multiExpected, multiplicationResult);
	}
}
