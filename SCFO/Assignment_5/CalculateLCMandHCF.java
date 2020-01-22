public class CalculateLCMandHCF 
{
	static int calculateLCM(int X,int Y)
	{
		int LCM=1;
		LCM=X*Y;
		int HCF=calculateHCF(X,Y);
		LCM=LCM/HCF;
		return LCM;
	}
	
/*	public static void main(String[] args) 
	{
		int t=calculateHCF(4,21);
		System.out.println("erfghjhgfdfg "+ t);
		
	}*/
	
	static int calculateHCF(int X, int Y)
	{
		if(X==0)
			return Y;
		return calculateHCF(Y%X,X);
	}
}
