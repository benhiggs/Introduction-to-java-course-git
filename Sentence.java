/**
 * Created by Ben on 30/01/2015.
 */
import java.util.Arrays;

public class Sentence {
    private static String[] words;

    public Sentence(String[] words) {
        setWords(words);
    }

    public static String[] getWords() {
        return words;
    }

    public void setWords(String[] Words) {
        words = Words.clone();
    }

    public String toString() {
        String sentence = "";
        String[] words = getWords();
        for (int i = 0; i < words.length; i++) {
            if (sentence == "") {
                sentence = words[i] + " ";
            } else {
                sentence = sentence + " " + words[i];
            }
        }
        return sentence;
    }

    public static String shortest() {
        String[] words = getWords();
        String shorter = words[0];
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() < shorter.length()) {
                shorter = words[i];
            }
        }
        return shorter;
    }

    public static String longest() {
        String[] words = getWords();
        String longer = "";
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > longer.length()) {
                longer = words[i];
            }
        }
        return longer;
    }

    public static double meanLength() {
        double count = 0;
        double tot = 0;
        String[] words = getWords();
        for (int i = 0; i < words.length; i++) {
            tot += words[i].length();
            count++;
        }
        return (tot / count);
    }

    public static String[] sorted() {
        String[] words = getWords();
        Arrays.sort(words);
        return (words);
    }

    public static void main(String[] args) {

        String[] wordList = {"A", "quick", "brown", "fox", "jumped",
                "over", "the", "lazy", "dog"};
        Sentence text = new Sentence(wordList);

        System.out.println(text);
        System.out.println("Shortest word: " + text.shortest());
        System.out.println("Longest word: " + text.longest());
        System.out.printf("Mean word length:%5.2f\n", text.meanLength());
        System.out.println();

        String[] sortedtext = text.sorted();
        System.out.println(text);
        System.out.print("Sorted: ");
        for (String s : sortedtext) System.out.print(s + ", ");
        System.out.println();


    }
}
