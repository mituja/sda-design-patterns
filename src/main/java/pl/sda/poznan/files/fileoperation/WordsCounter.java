package pl.sda.poznan.files.fileoperation;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class WordsCounter {

    public static void main(String[] args) {
        System.out.println("----Word Counter----");
        Scanner sc = new Scanner(System.in);
        System.out.println("Podaj sciezke pliku: ");
        String path = sc.next();

        List<String> lines = FileHelper.readAllLines(path);
        //lines.forEach(System.out::println);

        List<String> words = FileHelper.splitLinesIntoWords(lines);
        //words.forEach(System.out::println);

        Map<String, Integer> wordsMap = StringHelper.getWordsMap(words);

        for (Entry<String, Integer> entry : wordsMap.entrySet()) {
            System.out.println(entry.getKey() + "--->" + entry.getValue());
        }
    }
}
