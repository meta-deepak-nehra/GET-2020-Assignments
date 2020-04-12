package ques3;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cricket 
{
	public static int[] findOrderOfBowlers(int numberOfBalls, int numberOfBowlers,
            int ballsForEachBowler[]) throws Exception {

        int arrangedOrderOfBowlers[] = new int[numberOfBalls];

        if (numberOfBowlers != ballsForEachBowler.length) {
            throw new Exception("Bowls allocation per bowler is incorrect");
        }

        int sum = 0;
        for (int bowls : ballsForEachBowler) {
            sum += bowls;
        }

        if (sum < numberOfBalls) {
            throw new Exception(
                    "Number of Balls and sum of all allocated balls to bowler are not equal");
        }

        // Key is BowlerNumber Value balls associated with that bowler
        HashMap<Integer, Integer> bowlerData = new HashMap<Integer, Integer>();
        int key = 0;
        for (int i = 0; i < numberOfBowlers; i++) {
            bowlerData.put(++key, ballsForEachBowler[i]);
        }

        int i = 0;

        while (numberOfBalls != 0) {
            int maxBalls = Collections.max(bowlerData.values());
            for (Map.Entry<Integer, Integer> entry : bowlerData.entrySet()) {
                if (entry.getValue() == maxBalls) {
                    int bowlerNumber = entry.getKey();
                    arrangedOrderOfBowlers[i++] = bowlerNumber;
                    bowlerData.put(bowlerNumber, --maxBalls);
                    numberOfBalls--;
                    break;
                }
            }

        }
        return arrangedOrderOfBowlers;
    }

    public static void main(String args[]) {
        try {
            int[] order = Cricket.findOrderOfBowlers(14, 3, new int[] {6, 4, 4});
            for (int a : order) {
                System.out.println(a);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
