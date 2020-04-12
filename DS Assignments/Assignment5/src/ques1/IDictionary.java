package ques1;

import java.util.Map;

/**
 *Interface of dictionary. 
 */
public interface IDictionary 
{
	public void add(DictionaryNode node);
	
	public void delete(int key);
	
	public String getValue(int key);
	
	public Map<Integer, String> sorted();
	
	public Map<Integer, String> sortedInRange(int key1, int key2);
}