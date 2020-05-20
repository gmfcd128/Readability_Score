import java.util.*;

public class Main {
    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        int count = 0;
        int result = 0;
        boolean countingVowel = false;
        for (char c : input) {
            boolean isVowel = c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'y';
            if (isVowel != countingVowel) {
                result += (count - 1) / 2;
                count = 0;
                countingVowel = isVowel;
            }
            count += 1;
        }
        if (count > 0) {
            result += (count - 1) / 2;
        }
        System.out.println(result);
    }
}

