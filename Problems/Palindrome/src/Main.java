import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        int wordLen = word.length();
        char[] a = word.toCharArray();
        char[] reversed = new char[wordLen];
        for (int i = wordLen; i > 0; i--) {
            reversed[wordLen - i] = a[i - 1];
        }
        if (Arrays.equals(a, reversed)) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}