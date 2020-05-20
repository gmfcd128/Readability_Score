import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());
        double c = Double.parseDouble(scanner.nextLine());
        double root1 = (-b + Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (a * 2);
        double root2 = (-b - Math.sqrt(Math.pow(b, 2) - 4 * a * c)) / (a * 2);
        System.out.println(Math.min(root1, root2));
        System.out.println(Math.max(root1, root2));
    }
}