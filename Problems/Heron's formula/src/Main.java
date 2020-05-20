import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        double p = (double) (a + b + c) / 2;
        System.out.println(Math.sqrt(p * (p - a) * (p - b) * (p - c)));
    }
}