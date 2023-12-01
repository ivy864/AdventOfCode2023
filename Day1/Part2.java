import java.util.Scanner;
import java.io.FileReader;

class Part2 {
    public static void main(String[] args) {
        Scanner s;

        try {
            s = new Scanner(new FileReader("../input/day1testinput.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int total = 0;
        String line;
        
        String[] digitStrings = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        while (s.hasNextLine()) {
            line = s.nextLine();
            
            System.out.print(line);
            for (int i = 0; i < digitStrings.length; i++) {
                line = line.replaceAll(digitStrings[i], "" + (i + 1));
            }
            System.out.print(" " + line);

            line = line.replaceAll("[A-Za-z]+", "");
            System.out.println(" " + line);


            String[] parts = line.split("");
            
            line = parts[0] + parts[parts.length - 1];
            total += Integer.parseInt(line);
        }

        System.out.println(total);
    }
}
