import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);
        int count = 0;
        for (int s = a; s <= b; s++) {
            if (s % n == 0) {
                count++;
            }
        }
        System.out.println(count);
    }
}
