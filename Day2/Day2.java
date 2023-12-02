import java.util.Scanner;
import java.io.FileReader;

class Day2 {
    public static void main (String args[]) {
        Scanner s;
        if (args.length == 0) {
            try {
                s = new Scanner(new FileReader("../input/day2input.txt"));
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
        
        int power = 0;
        String line;
        while (s.hasNextLine()) {
            line = s.nextLine();
            
            PowerFinder finder; 

            try {
                finder = new PowerFinder(line);
            }
            catch(Exception e) {
                e.printStackTrace(); 
                return;
            }

            power += finder.getPower();    
        }

        System.out.println(power);
    }
}
