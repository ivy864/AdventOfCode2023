import java.util.Scanner;
import java.io.FileReader;
import java.util.Hashtable;
import java.util.ArrayList;

class Day4 {
    public static void main(String[] args) {
        Scanner s;
        if (args.length == 0) {
            try {
                s = new Scanner(new FileReader("../input/day4input.txt"));
            }
            catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        else {
            try {
                s = new Scanner(new FileReader(args[0]));
            }
            catch(Exception e) {
                e.printStackTrace();
                return;
            }
        }

        String line;
        int totalWon = 0;
        int totalCards = 0;
        
        Hashtable<Integer, Integer> copies = new Hashtable<Integer, Integer>();

        while (s.hasNextLine()) {
            line = s.nextLine();

            Hashtable<String, Boolean> winning = new Hashtable<String, Boolean>();     

            int points = 0;
            int matches = 0;
            int multiplier = 1;
            

            String[] half = line.split("\\|");
            String[] winners = half[0].split(" +");
            System.out.println(line);
            String[] parts = half[1].split(" +");

            int gameNum = Integer.parseInt(winners[1].substring(0, 
                winners[1].length() - 1));

            if (copies.get(gameNum) != null) {
                multiplier += copies.get(gameNum);
            }
            totalCards += multiplier;

            for (int i = 2; i < winners.length; i++) {
                winning.put(winners[i], true);
            }

            for (int i = 0; i < parts.length; i++) {
                if (winning.get(parts[i]) != null) {
                    System.out.println(parts[i]);
                    matches += 1;
                    if (points == 0) {
                        points = 1;
                    }
                    else {
                        points *= 2;
                    }
                }
            }

            for (int i = 0; i < matches; i++) {
                int copyGameNum = gameNum + i + 1;
                if (copies.get(copyGameNum) == null) {
                    copies.put(copyGameNum, multiplier);
                }
                else {
                    copies.put(copyGameNum, copies.get(copyGameNum) 
                    + multiplier);
                }
            }

            System.out.println("points: " + points * multiplier);
            System.out.println("multiplier: " + multiplier);
            totalWon += points * multiplier;
        }

        System.out.println(totalWon);
        System.out.println("you had " + totalCards + " cards.");
    }
}
