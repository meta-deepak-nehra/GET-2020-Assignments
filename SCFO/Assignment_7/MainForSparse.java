import java.util.Scanner;
public class MainForSparse 
{
	/**
	 * Main function to run the program.
	 * @param args String argument passed to main function.
	 */
	public static void main(String[] args) 
	{
		Scanner inr = new Scanner(System.in);
		System.out.println("Please choose from following options");
		System.out.println("1.Transpose of Matrix");
		System.out.println("2.Check the symmetry of a matrix");
		System.out.println("3.Add two matrix");
		System.out.println("4.Multiply two matrix");
		int b = inr.nextInt();
		if(b>4||b<1)
		{
			System.out.println("Your Choice is Invalid");
			System.exit(0);
		}
		switch(b)
		{
		case 1:
			int[][] temp=setDataToTheMatrix();
			SparseMatrix obj= new SparseMatrix(temp);
			int[][] matrixTranspose=obj.performTransposeOfMatrix();
			for(int i=0;i<matrixTranspose.length;i++)
			{
				for(int j=0;j<matrixTranspose[0].length;j++)
				{
					System.out.print(matrixTranspose[i][j]+"\t");
				}
				System.out.println();
			}
			break;
		case 2:
			int[][] temp1=setDataToTheMatrix();
			SparseMatrix obj1= new SparseMatrix(temp1);
			int[][] matrixTranspose1=obj1.performTransposeOfMatrix();
			boolean symmetryResult=obj1.checkSymmetryOfMatrix(matrixTranspose1);
			if(symmetryResult==true)
				System.out.println("Matrix is symmerty");
			else
				System.out.println("Matrix is not symmerty");
			break;
		case 3:
			System.out.println("Taking first matrix");
			int[][] tempA1=setDataToTheMatrix();
			System.out.println("Taking second matrix");
			int[][] tempA2=setDataToTheMatrix();
			SparseMatrix obj2= new SparseMatrix(tempA1);
			int[][] resultAdd=obj2.addTwoMatrices(tempA1, tempA2);
			System.out.println("Addition of the matrices is :");
			System.out.println();
			for(int i=0;i<resultAdd.length;i++)
			{
				for(int j=0;j<resultAdd[0].length;j++)
				{
					System.out.print(resultAdd[i][j]+"\t");
				}
				System.out.println();
			}
			break;
		case 4:
			System.out.println("Taking first matrix");
			int[][] tempM1=setDataToTheMatrix();
			System.out.println("Taking second matrix");
			int[][] tempM2=setDataToTheMatrix();
			SparseMatrix obj3= new SparseMatrix(tempM1);
			int[][] resultMultiply=obj3.multiplyTwoMatrices(tempM1,tempM2);
			for(int i=0;i<resultMultiply.length;i++)
			{
				for(int j=0;j<resultMultiply[0].length;j++)
				{
					System.out.print(resultMultiply[i][j]+"\t");
				}
				System.out.println();
			}
			break;
		}
		inr.close();
	}
	
	/**
	 * Function to set data in a matrix.
	 * @return Returning the matrix.
	 */
	static int[][] setDataToTheMatrix()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter total number of rows present in matrix :");
		int rowsOfMatrix=sc.nextInt();
		System.out.println("Enter total number of columns present in matrix :");
		int columnsOfMatrix=sc.nextInt();
		int[][] generalMatrix= new int[rowsOfMatrix][columnsOfMatrix];
		for(int i=0;i<rowsOfMatrix;i++)
		{
			for(int j=0;j<columnsOfMatrix;j++)
			{
				System.out.println("Enter value of ["+i+"]["+j+"] element:");
				generalMatrix[i][j]=sc.nextInt();
			}
		}
		return generalMatrix;
	}
}












