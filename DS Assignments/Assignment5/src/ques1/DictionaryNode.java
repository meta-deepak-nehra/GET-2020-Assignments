package ques1;

public class DictionaryNode 
{
	int key;
	String value;
	DictionaryNode left = null;
	DictionaryNode right = null;
	DictionaryNode parent = null;
	
	DictionaryNode (int key, String value)
	{
		this.key = key;
		this.value = value;
	}
	
}
