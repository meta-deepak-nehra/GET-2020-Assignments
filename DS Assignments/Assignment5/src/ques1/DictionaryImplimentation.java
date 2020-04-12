package ques1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;


public class DictionaryImplimentation implements IDictionary
{
	DictionaryNode root;
	Map<Integer, String> sortedList = new LinkedHashMap<Integer, String>();
	Map<Integer, String> sortedInRange = new LinkedHashMap<Integer, String>();
 
	@Override
	public void add(DictionaryNode node) 
	{
		root =	bstNodeAdd(root, node);
	}

	@Override
	public void delete(int key) 
	{
		root = bstNodeDelete(root, key);
		
	}

	@Override
	public String getValue(int key) 
	{
		return findValue(root, key).value;
	}
	

	@Override
	public Map<Integer, String> sorted()
	{
		addSortedListInMap(root);
		return sortedList;
	}
	
	@Override
	public Map<Integer, String> sortedInRange(int key1, int key2)
	{
		addListOfKey1ToKey2( root, key1, key2);	
		return sortedInRange;
	}
	
	public void inorder()  
   	{
		 printInorder(root); 
    }
	
	private DictionaryNode bstNodeAdd(DictionaryNode root, DictionaryNode node)
	{
		try
		{
			if(root == null)
			{
				root = node;
				return root;
		    }
		     if(root.key < node.key)
		     {
			    root.right = bstNodeAdd(root.right, node);
		     }
		     else if(root.key > node.key)
		     {
		    	 root.left = bstNodeAdd(root.left, node);
		     }
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	     
	     return root;	
	}
	
	private DictionaryNode bstNodeDelete(DictionaryNode root, int key)
	{
		try
		{
	        if(root == null)
	        {
	        	return root;
	        }
	  
	        if(key < root.key) 
	        {
	            root.left = bstNodeDelete(root.left, key);
	        }
	        else if(key > root.key)
	        {
	            root.right = bstNodeDelete(root.right, key);
	        }
	        else
	        { 
	            if (root.left == null) 
	            {
	                return root.right;
	            }
	            else if (root.right == null)
	            {
	                return root.left;
	            }
	            
	            root.key = getInorderSuccessor(root.right); 
	  
	            // Delete the inorder successor 
	            root.right = bstNodeDelete(root.right, root.key); 
	        } 
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
        return root; 
	}
	
	private int getInorderSuccessor(DictionaryNode root) 
    { 
        int inorderSuccessor = root.key; 
        try
        {
	        while (root.left != null) 
	        { 
	        	inorderSuccessor = root.left.key; 
	            root = root.left; 
	        }
        }
        catch(Exception e)
		{
			System.out.println(e);
		}
        
        return inorderSuccessor; 
    } 
	
	private DictionaryNode findValue(DictionaryNode root, int key)
	{
		try
		{
			if(root.key == key)
			{
				return root;
			}
			else if(root.key < key)
			{
				return findValue(root.right, key);
			}
			else if(root.key >= key)
			{
				return findValue(root.left, key);
			}
			else
			{
				throw new Exception("Key is not found.");
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return null;
	}
	
	private void addSortedListInMap(DictionaryNode root)
	{
		try
		{
			if(root != null)
			{
				addSortedListInMap(root.left);
				sortedList.put(root.key, root.value);
				addSortedListInMap(root.right);
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}
	
	private void addListOfKey1ToKey2(DictionaryNode root, int key1, int key2)
	{
		try
		{
			for(Entry<Integer, String> list : sortedList.entrySet())
			{
				if(list.getKey() >= key1 && list.getKey() <= key2)
				{
					sortedInRange.put(list.getKey(), list.getValue());
				}
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

    private void printInorder(DictionaryNode rootNode) 
	{ 
	   if (rootNode != null) 
	   { 
	       printInorder(rootNode.left); 
	       System.out.print(rootNode.key+"  "); 
	       System.out.println(rootNode.value); 
	       printInorder(rootNode.right); 
	   } 
	} 
}