import java.util.Scanner;
import java.io.FileReader;

class Part2 {
    public static void main(String[] args) {
        Scanner s;

        try {
            s = new Scanner(new FileReader("../input/testinp.txt"));
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        int total = 0;

        while (s.hasNextLine()) {
            total += getNumber(s.nextLine());
        }

        System.out.println(total);
    }

    static int getNumber(String input) {
        String[] digitStrings = {"one", "two", "three", "four", "five", 
            "six", "seven", "eight", "nine"};
        int firstDigit = -1;
        int firstDigitIndex = -1;
        int lastDigit = -1;
        int lastDigitIndex = -1;
        int index;

        String newString = input;
        
        for (int i = 0; i < digitStrings.length; i++) {
            index = input.indexOf(digitStrings[i]); 
            if (index != -1 && (index < firstDigitIndex || 
                firstDigitIndex == -1)) {

                firstDigitIndex = index;
                firstDigit = i;
            }

            index = input.lastIndexOf("" + (i + 1));

            if (index != -1 && (index > lastDigitIndex || 
                lastDigitIndex == -1)) {

                lastDigitIndex = index;
                lastDigit = i;
            }
        }

        return Integer.parseInt(("" + (firstDigitIndex + 1)) + 
            ("" + (lastDigitIndex + 1)));
    }
}
