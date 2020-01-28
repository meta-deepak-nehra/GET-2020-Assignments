import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestForPoly
{
	int[][] temp=new int[][]{{2,1},{2,2},{2,0}};
	Poly obj=new Poly(temp);
	@Test
	public void testToEvaluateTheValueOfPolynomial()
	{
		Poly obj=new Poly(temp);
		temp=obj.sorting(temp);
		double result=obj.evaluateTheValueOfPolynomial((float) 2.0);
		assertEquals(14.0, result, 0.1);
		
	}
	
	@Test
	public void testForDegree()
	{
		Poly obj=new Poly(temp);
		temp=obj.sorting(temp);
		int result=obj.degree(temp);
		assertEquals(2,result);
	}
	
	@Test
	public void testForAddPoly()
	{
		int[][] temp=new int[][]{{2,1},{3,2},{4,1}};
		int[][] temp1=new int[][]{{5,4},{6,5}};
		int[][] result=obj.addPoly(temp, temp1);
		int[][] tempResult=new int[][] {{6,5},{5,4},{3,2},{2,1},{4,1}};
		boolean b=false;
		for(int i=0;i<tempResult.length;i++)
		{
			if(tempResult[i][0]==result[i][0]||tempResult[i][1]==result[i][1])
			{
				b=true;
			}
			else
			{
				b=false;
				break;
			}
		}	
		assertEquals(true,b);
	}
	
	@Test
	public void testForMultiplyPolynomial()
	{
		int[][] temp=new int[][]{{2,1},{3,2},{4,1}};
		int[][] temp1=new int[][]{{5,4},{6,5}};
		int[][] result=obj.multiplyPolynomial(temp, temp1);
		int[][] tempResult=new int[][]{{18,7},{15,6},{12,6},{10,5},{24,6},{20,5}};
		boolean b=false;
		for(int i=0;i<tempResult.length;i++)
		{
			if(tempResult[i][0]==result[i][0]||tempResult[i][1]==result[i][1])
			{
				b=true;
			}
			else
			{
				b=false;
				break;
			}
		}	
		assertEquals(true,b);
	}
}
