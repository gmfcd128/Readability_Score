import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int distance = Integer.parseInt(scanner.nextLine());
        int time = Integer.parseInt(scanner.nextLine());
        System.out.println((double) distance / time);
    }
}