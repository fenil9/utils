import java.io.*;

    public class ReverseDigit {

        public static void main(String args[]) throws Exception {
            int num = 0, reverse, lastDigit;
            System.out.println("Enter an Integer");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            num = Integer.parseInt(br.readLine());
            reverse = 0;
            while (num != 0) {
                lastDigit = num % 10;
                reverse = reverse * 10 + lastDigit;
                num = num / 10;
            }
            System.out.println("Reversed Number : " + reverse);
        }
    }

