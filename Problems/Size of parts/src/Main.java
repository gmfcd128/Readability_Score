import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        int toFix = 0;
        int toShip = 0;
        int rejected = 0;
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int detectorPrint = Integer.parseInt(scanner.nextLine());
            switch (detectorPrint) {
                case 1:
                    toFix += 1;
                    break;
                case 0:
                    toShip += 1;
                    break;
                case -1:
                    rejected += 1;
                    break;
                default:
                    break;
            }
        }
        System.out.printf("%d %d %d", toShip, toFix, rejected);
    }
}
