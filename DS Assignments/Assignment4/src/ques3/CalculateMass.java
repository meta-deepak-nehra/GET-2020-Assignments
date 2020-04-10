package ques3;

import java.util.HashMap;
import java.util.Stack;

public class CalculateMass {

    public HashMap<Character, Integer> elements = new HashMap<Character, Integer>();

    public int getMass(String string) {
        string = string.toUpperCase();

        elements.put('C', 12);
        elements.put('O', 16);
        elements.put('H', 1);

        int mass = 0;
        int index = 0;
        char currentChar = 0;

        Stack<Integer> stack1 = new Stack<Integer>();
        while (index < string.length()) {

            currentChar = string.charAt(index);

            if ((currentChar == 67 || currentChar == 72 || currentChar == 79)) {
                stack1.push(elements.get(currentChar));
                index++;
            } else if (currentChar >= 48 && currentChar <= 57) {
                int dist = index;
                if (stack1.isEmpty()) {
                    System.out.println("Incorrect Input");
                    throw new AssertionError();

                }
                while (dist < string.length() && isInteger(string.charAt(dist))) {
                    dist++;
                }
                int temp = stack1.pop();
                int numeric = Integer.valueOf(string.substring(index, dist));

                // updating index to char next to the numeric
                index = dist;
                stack1.push(temp * numeric);

            } else if (currentChar == '(') {
                index++;
                int dist = index;

                Stack<Character> stack2 = new Stack<Character>();

                stack2.push('(');
                String temp = "";
                while (!stack2.isEmpty()) {
                    if (string.charAt(dist) == '(') {
                        temp += '(';
                        stack2.push('(');
                    } else if (string.charAt(dist) == ')') {
                        stack2.pop();
                        temp += ')';
                    } else {
                        temp += string.charAt(dist);
                    }
                    dist++;
                }

                temp = temp.substring(0, temp.length() - 1);
                int dist2 = dist;
                while (dist2 < string.length() && isInteger(string.charAt(dist2))) {
                    dist2++;
                }

                mass +=
                        (getMass(temp) * Integer.valueOf(string.substring(dist, dist2)) + getMass(string
                                .substring(dist2)));
                index = string.length();

            } else {
                System.out.println("Incorrect Data");
                return 0;

            }
        }

        while (!stack1.isEmpty()) {
            int s = stack1.pop();
            mass += s;
        }
        return mass;
    }

    public boolean isInteger(char currentChar) {
        if (currentChar >= 48 && currentChar <= 57) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) 
    {
        CalculateMass calculateMass = new CalculateMass();
        System.out.println(calculateMass.getMass(""));
        System.out.println(calculateMass.getMass("CHO(CH3O)2C"));
        System.out.println(calculateMass.getMass("CH(CH3)3Oc"));
         
    }
}
