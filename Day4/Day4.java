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
        
        ArrayList<Integer> copies = new ArrayList<Integer>;
        Hashtable<Integer, Integer> copies = new Hashtable<Integer, Integer>;

        while (s.hasNextLine()) {
            Hashtable<String, Boolean> wining = new Hashtable<String, Boolean>();     

            int points = 0;
            int matches = 0;
            line = s.nextLine();

            String[] half = line.split("\\|");
            String[] winers = half[0].split(" +");
            System.out.println(line);

            String[] parts = half[1].split(" +");

            for (int i = 2; i < winers.length; i++) {
                wining.put(winers[i], true);
            }

            for (int i = 0; i < parts.length; i++) {
                if (wining.get(parts[i]) != null) {
                    System.out.println(parts[i]);
                    if (points ==0) {
                        points = 1;
                    }
                    else {
                        points *= 2;
                    }
                }
            }

            for (int i = 0; i < matches; i++) {
                copies.set(i)
            }
            System.out.println(points);

            totalWon += points * multiplier;

        }

        System.out.println(totalWon);
    }
}
