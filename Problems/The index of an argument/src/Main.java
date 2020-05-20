import java.util.Arrays;

class Problem {
    public static void main(String[] args) {
        for (String arg : args) {
            if ("test".equals(arg)) {
                System.out.println(Arrays.asList(args).indexOf(arg));
                return;
            }
        }
        System.out.println(-1);
    }
}