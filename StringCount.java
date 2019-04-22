import java.util.Scanner;

public class StringCount {

    public static void main(String args[]) {
        String text;
        int countWords = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter string: a");
        text = scanner.nextLine();

        for (int i = 0; i < text.length() - 1; i++) {
            if (text.charAt(i) == ' ' && text.charAt(i + 1) != ' ')
                countWords++;
        }

        System.out.println("Total number of words in string are: " + (countWords + 1));


    }
}
