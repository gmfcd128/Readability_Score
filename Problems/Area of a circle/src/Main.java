import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int radius = Integer.parseInt(scanner.nextLine());
        System.out.println(Math.PI * (double) radius * radius);
    }
}