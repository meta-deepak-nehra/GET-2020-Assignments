/**
 * 
 * @author DeepakNehra
 * This class is designed for the Sparse Matrix operations. 
 *
 */
public final class SparseMatrix 
{
	private int[][] sparseMatrix;
	private int[][] cloneArray;
	int k=0;
	
	/**
	 * This is the parameterized constructor.
	 * @param mainArray It is a 2D array passed as the parameter to this constructor.
	 */
	public SparseMatrix(int[][] mainArray) 
	{		
		if(mainArray.length==0)
		{	
			System.out.println("Length of Array is 0");
			System.exit(0);
		}		
		int elementCount=0;
		for(int i=0;i<mainArray.length;i++)
		{
			for(int j=0;j<mainArray[0].length;j++)
			{
				if(mainArray[i][j]!=0)
				{
					elementCount++;
				}
			}
		}
		sparseMatrix = new int[elementCount][3];
		for(int i=0;i<mainArray.length;i++) 
		{
			for (int j=0;j<mainArray[0].length;j++) 
			{
				if (mainArray[i][j]!=0)
				{
					sparseMatrix[k][0]=i;
					sparseMatrix[k][1]=j;
					sparseMatrix[k][2]=mainArray[i][j];
					k++;
				}
			}
		}
		cloneArray = mainArray.clone();
	}
	
	/**
	 * Performing the transpose of the sparse matrix.
	 * @return Return the transpose of the sparse matrix as sparse matrix.
	 */
	int[][] performTransposeOfMatrix()
	{
		boolean flag=true;
		int[][] transposeOfMatrix=new int[cloneArray.length][cloneArray[0].length] ;
		int k=0;
		for(int i=0;i<cloneArray.length;i++)
		{
			for(int j=0;j<cloneArray[0].length; j++)
			{
				if(k==this.k)
				{
					flag=false;
					break;
				}
				if(sparseMatrix[k][0]==i && sparseMatrix[k][1]==j)
				{
					transposeOfMatrix[j][i]=sparseMatrix[k][2];
					k++;
				}
			}
			if(!flag)
				break;
		}
		return transposeOfMatrix;	
	}
	
	/**
	 * Checking that the matrix is symmetric or not.
	 * @param transposedMatrix Passed as input parameter for checking symmetry of matrix.
	 * @return Returning the boolean value after checking symmetry, true for symmetric and false for asymmetric.
	 */
	boolean checkSymmetryOfMatrix(int[][] transposedMatrix)
	{
		for(int i=0;i<cloneArray.length;i++)
		{
			for(int j=0;j<cloneArray[0].length;j++)
			{
				if(transposedMatrix[i][j]!=cloneArray[i][j])
					return false;
			}
		}
		return true;
	}
	
	/**
	 * Function for adding two matrices.
	 * @param baseMatrix First matrix for addition.
	 * @param matrixToBeAdded Second matrix for addition.
	 * @return Result matrix after addition.
	 */
	int[][] addTwoMatrices(int[][] baseMatrix,int[][] matrixToBeAdded)
	{
		int[][] resultantMatrix=new int[baseMatrix.length][baseMatrix[0].length];
		if(baseMatrix.length!=matrixToBeAdded.length||baseMatrix[0].length!=matrixToBeAdded[0].length)
		{	
			System.out.println("Addition not possible");
			System.exit(0);
		}	
		else
		{
			for(int i=0;i<baseMatrix.length;i++)
			{
				for(int j=0;j<matrixToBeAdded.length;j++)
				{
					resultantMatrix[i][j]=baseMatrix[i][j]+matrixToBeAdded[i][j];
				}
			}
		}
		return resultantMatrix;	
	}
	
	/**
	 * Function for multiplying two matrices.
	 * @param baseMatrix First matrix for multiplication.
	 * @param matrixToBeMultiplied Second matrix for multiplication.
	 * @return Result matrix after multiplication.
	 */
	int[][] multiplyTwoMatrices(int[][] baseMatrix,int[][] matrixToBeMultiplied)
	{
		if(baseMatrix[0].length!=matrixToBeMultiplied.length)
		{
			System.out.println("Multiplication not possible");
			System.exit(0);
		}
		int[][] resultMatrix= new int[baseMatrix.length][matrixToBeMultiplied[0].length];
		for(int i=0;i<baseMatrix.length;i++)
		{
			for(int j=0;j<matrixToBeMultiplied[0].length;j++)
			{
				for(int k=0;k<matrixToBeMultiplied.length;k++)
				{
					resultMatrix[i][j]+=baseMatrix[i][k]*matrixToBeMultiplied[k][j];
				}
			}
		}
		return resultMatrix;		
	}
}
