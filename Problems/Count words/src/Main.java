import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;

class Main {
    public static void main(String[] args) throws Exception {
        try (Reader reader = new BufferedReader(new InputStreamReader(System.in))) {
            // start coding here
            boolean isSpace = true;
            int wordCount = 0;
            int currentChar = reader.read();
            while (currentChar != -1) {
                if (currentChar == (int) ' ') {
                    if (!isSpace) {
                        isSpace = true;
                    }
                } else {
                    if (isSpace) {
                        isSpace = false;
                        wordCount += 1;
                    }
                }
                currentChar = reader.read();
            }
            System.out.println(wordCount);
        }
    }

}