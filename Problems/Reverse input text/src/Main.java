import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            char[] input = new char[50];
            int strLen = reader.read(input);
            for (int i = strLen - 1; i >= 0; i--) {
                System.out.print(input[i]);
            }
        }
    }
}