import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toLowerCase().toCharArray();
        int count = 0;
        for (char c : input) {
            if (c == 'c' || c == 'g') {
                count++;
            }
        }
        System.out.println((double) count / input.length * 100);
    }
}