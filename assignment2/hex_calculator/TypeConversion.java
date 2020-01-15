public class TypeConversion 
{
	int hexToInt(String strHex)
	{
		int intNum=Integer.valueOf(strHex, 16);
		return intNum;
	}
	
	String intToHex(int intNum)
	{
		String strHex=Integer.toHexString(intNum);
		return strHex;
	}
}
