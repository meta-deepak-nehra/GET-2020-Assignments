package ques1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class JsonFileReader
{
	private static final String FILE_PATH = "C:\\Users\\Deepak\\Desktop\\DS\\Assignment5\\src\\ques1\\test.json";
   
	String sortedKeyVal="";
	JSONArray jsonArr = null;
	
    DictionaryImplimentation dictionary = new DictionaryImplimentation();
	
	public  void readJsonFile() 
	{
		JSONParser jsonParser = new JSONParser();
		
        try (FileReader reader = new FileReader(FILE_PATH))
        {
            Object jsonFileData = jsonParser.parse(reader);
 
            jsonArr = (JSONArray) jsonFileData;
        }
        catch (FileNotFoundException e) 
        {
            e.printStackTrace();
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
        catch (org.json.simple.parser.ParseException e) 
        {
			e.printStackTrace();
		}
        catch(Exception e)
        {
        	e.printStackTrace();
        }
        
      
	}
	
	public  void splitKeyAndValueOfJsonArray()
	{
		for(Object obj : jsonArr.toArray())
		{
			String keyValue = obj.toString();
			
			String[] keyValPair = keyValue.split(":"), keyVal = new String[2];
			
			keyVal[0] = "";
			keyVal[1] = "";
			
			for(int count = 0; count < 2; count++)
			{
				int index = 1, limit = keyValPair[count].length() - 2;
				if(count == 0)
				{
					index = 2;
					limit += 1;
				}
				while(index < limit)
				{
					keyVal[count] += keyValPair[count].charAt(index++);	
				}
			}
			
			int key = Integer.parseInt(keyVal[0]);
			DictionaryNode node = new DictionaryNode(key, keyVal[1]);
			dictionary.add(node);		
        }
		
		
	}
	
	public void callMethod()
	{
				System.out.println("-----------------------------");
				dictionary.inorder();
				System.out.println("-----------------------------");
				dictionary.delete(8);
				dictionary.inorder();
				
				Map<Integer,String>list =dictionary.sorted();
				System.out.println("-----------------------------");
				for(Entry<Integer, String> list1 : list.entrySet())
				{
					System.out.println("KEY "+list1.getKey() + "value "+list1.getValue());
				}
				
				Map<Integer,String>list11 =dictionary.sortedInRange(10,17);
				System.out.println("-----------------------------");
				for(Entry<Integer, String> list1 : list11.entrySet())
				{
					System.out.println("KEY "+list1.getKey() + "value "+list1.getValue());
				}		
	}
	
	public DictionaryImplimentation getObj()
	{
		return dictionary;
	}
	
	public static void main(String arg[])
	{
		JsonFileReader js = new JsonFileReader();
		js.readJsonFile();	
		js.splitKeyAndValueOfJsonArray();
		js.callMethod();
	}
}
