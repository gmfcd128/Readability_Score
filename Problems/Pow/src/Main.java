import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        System.out.println(Math.pow(Double.parseDouble(input[0]), Double.parseDouble(input[1])));
    }
}