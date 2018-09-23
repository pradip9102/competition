package buyhatke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompoundWord {

    List<String> wordDictionary;

    Boolean isCompound(List<String> dictionary, String word) {
        int start = 0;
        int end = word.length();
        boolean available = true;
        int temp = start;
        for (int j = 0; j < dictionary.size(); j++) {
            if (!word.equals(dictionary.get(j))
                    && word.substring(start, end).startsWith(dictionary.get(j))) {
                start = dictionary.get(j).length();
                j = 0;
            }
        }

        return start < end;
    }

    private CompoundWord() {
        wordDictionary = new ArrayList<>();
    }

    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        CompoundWord problem = new CompoundWord();

        for (int i = 0; i < 20; i++) {
            problem.wordDictionary.add(s.next());
        }

        problem.wordDictionary.sort(String::compareTo);

        for (int i = 0; i < 20; i++) {
            if (problem.isCompound(problem.wordDictionary, problem.wordDictionary.get(i))) {
                System.out.println(problem.wordDictionary.get(i));
            }
        }
    }
}
