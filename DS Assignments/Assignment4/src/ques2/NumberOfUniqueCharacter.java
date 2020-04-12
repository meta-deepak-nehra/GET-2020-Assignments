package ques2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class NumberOfUniqueCharacter {

    HashMap<String, Integer> cache = new HashMap<>();

    public int countsNmberOfUniqueCharacters(String input) {
        int result = 0;

        if (cache.containsKey(input)) {
            result = cache.get(input);
            return result;
        }

        HashMap<Character, Integer> uniqueCharacter = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char tempChar = input.charAt(i);

            if (uniqueCharacter.containsKey(tempChar)) {
                int count = uniqueCharacter.get(tempChar);
                uniqueCharacter.put(tempChar, count + 1);
            }

            else
                uniqueCharacter.put(tempChar, 1);

        }

        Set<Character> keyset = uniqueCharacter.keySet();

        Iterator<Character> iterator = keyset.iterator();

        while (iterator.hasNext()) {
            if (uniqueCharacter.get(iterator.next()) == 1)
                result++;
        }

        cache.put(input, result);
        return result;
    }
 
    public static void main(String args[]) {
        NumberOfUniqueCharacter obj = new NumberOfUniqueCharacter();
        int value = obj.countsNmberOfUniqueCharacters("DeepakNehra");
        System.out.println(value);
        System.out.println(obj.countsNmberOfUniqueCharacters("Aqwe@#$qwea@#"));

    }


}