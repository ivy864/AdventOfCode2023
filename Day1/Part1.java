import java.util.Scanner;
import java.io.FileReader;

class Part1 {
    public static void main(String[] args) {
        Scanner s;

        try {
            s = new Scanner(new FileReader("../input/day1input.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int total = 0;
        String line;

        while (s.hasNextLine()) {
            line = s.nextLine();
            
            line = line.replaceAll("[a-zA-Z]+", "");
            String[] parts = line.split("");
            
            line = parts[0] + parts[parts.length - 1];
            total += Integer.parseInt(line);
        }

        System.out.println(total);
    }
}
