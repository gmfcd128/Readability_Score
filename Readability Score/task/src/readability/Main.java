package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("./" + args[0]);
        String fileContent = "";
        Scanner userInput = new Scanner(System.in);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                fileContent += scanner.nextLine() + "\n";
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
        int syllableCount = 0;
        int polySyllableCount = 0;

        String regex = "[!.?]";
        int sentences = fileContent.split(regex).length;
        if (fileContent.endsWith("!\n") || fileContent.endsWith(".\n") || fileContent.endsWith("?\n")) {
            sentences--;
        }
        int wordCount = fileContent.split(" ").length;
        String[] words = fileContent.replaceAll(regex, "").split(" ");
        for (String word : words) {
            syllableCount += countSyllables(word);
            if (isPlolySyllable(word)) {
                polySyllableCount++;
            }
        }
        int charCount = fileContent.replace(" ", "").replace("\n", "").replace("\t", "").length();
        int[] targetAge = {0, 6, 7, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 24, 24, 24};
        System.out.println("java Main " + args[0]);
        System.out.println("The text is:");
        System.out.println(fileContent + "\n");
        System.out.println("Words: " + wordCount);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + charCount);
        System.out.println("Syllables: " + syllableCount);
        System.out.println("Polysyllables: " + polySyllableCount);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String option = userInput.nextLine();
        System.out.println();
        if ("ARI".equals(option)) {
            double ariResult = ari(charCount, wordCount, sentences);
            System.out.printf("Automated Readability Index: %f (about %d year olds).\n", ariResult, targetAge[(int) Math.ceil(ariResult)]);
        } else if ("FK".equals(option)) {
            double fkResult = fk(wordCount, syllableCount, sentences);
            System.out.printf("Flesch–Kincaid readability tests: %f (about %d year olds).\n", fkResult, targetAge[(int) Math.ceil(fkResult)]);
        } else if ("SMOG".equals(option)) {
            double smogResult = smog(polySyllableCount, sentences);
            System.out.printf("Simple Measure of Gobbledygook: %f (about %d year olds).\n", smogResult, targetAge[(int) Math.ceil(smogResult)]);
        } else if ("CL".equals(option)) {
            double clResult = cl(charCount, sentences, wordCount);
            System.out.printf("Coleman–Liau index: %f (about %d year olds).\n", clResult, targetAge[(int)Math.ceil(clResult)]);
        } else if ("all".equals(option)) {
            double ariResult = ari(charCount, wordCount, sentences);
            System.out.printf("Automated Readability Index: %f (about %d year olds).\n", ariResult, targetAge[(int) Math.ceil(ariResult)]);
            double fkResult = fk(wordCount, syllableCount, sentences);
            System.out.printf("Flesch–Kincaid readability tests: %f (about %d year olds).\n", fkResult, targetAge[(int) Math.ceil(fkResult)]);
            double smogResult = smog(polySyllableCount, sentences);
            System.out.printf("Simple Measure of Gobbledygook: %f (about %d year olds).\n", smogResult, targetAge[(int) Math.ceil(smogResult)]);
            double clResult = cl(charCount, sentences, wordCount);
            System.out.printf("Coleman–Liau index: %f (about %d year olds).\n", clResult, targetAge[(int)Math.ceil(clResult)]);
            System.out.println();
            double avgAge = (double)(targetAge[(int) Math.ceil(ariResult)] + targetAge[(int) Math.ceil(fkResult)]
                    + targetAge[(int) Math.ceil(smogResult)] + targetAge[(int)Math.ceil(clResult)]) / 4;
            System.out.printf("This text should be understood in average by %f year olds.", avgAge);
        }

        System.out.println("This text should be understood by " + targetAge + " year olds.");
    }

    static int countSyllables(String word) {
        int count = 0;
        for (int i = 0; i < word.length() - 1; i++) {
            if (isVowel(word.charAt(i))) {
                if (i == 0) {
                    count++;
                } else if (!isVowel(word.charAt(i - 1))) {
                    count++;
                }
            }
        }
        if (isVowel(word.charAt(word.length() - 1)) && word.charAt(word.length() - 1) != 'e') {
            count++;
        }
        if (count == 0) {
            return 1;
        } else {
            return count;
        }
    }

    static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    static boolean isPlolySyllable(String word) {
        return countSyllables(word) > 2;
    }

    static double ari(int charCount, int wordCount, int sentences) {
        double score = (4.71 * ((double) charCount / wordCount)) + (0.5 * ((double) wordCount / sentences)) - 21.43;
        return Math.round(score * 100) / (double) 100;
    }

    static double fk(int wordCount, int syllableCount, int sentenceCount) {
        double score = (0.39 * ((double) wordCount / sentenceCount)) + (11.8 * (double) syllableCount / wordCount) - 15.59;
        return Math.round(score * 100) / (double) 100;
    }

    static double smog(int polySyllableCount, int sentenceCount) {
        double score = 1.043 * Math.sqrt((double) (polySyllableCount * 30) / sentenceCount) + 3.1291;
        return Math.round(score * 100) / (double) 100;
    }

    static double cl(int charCount, int sentenceCount,int wordCount) {
        double l = (double) charCount / wordCount * 100;
        double s = (double) sentenceCount / wordCount * 100;
        double score = (0.0588 * l) - (0.296 * s) - 15.8;
        return Math.round(score * 100) / (double) 100;
    }
}
