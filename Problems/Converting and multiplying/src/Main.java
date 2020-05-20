import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            try {
                int input = Integer.parseInt(line);
                if (input == 0) {
                    return;
                } else {
                    System.out.println(input * 10);
                }
            } catch (Exception e) {
                System.out.println("Invalid user input: " + line);
            }
        }
    }
}