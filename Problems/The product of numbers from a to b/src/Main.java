import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        long output = 1L;
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        for (int start = a; start < b; start++) {
            output *= start;
        }
        System.out.println(output);
    }
}