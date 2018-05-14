package pl.sda.poznan.files.fileoperation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileHelper {

    public static List<String> readAllLines(String path) {
        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = null;

            //ponizej w warunku while trzeba przypisac wartosc zmiennej line i sprawdzic
            //czy jest to rozne od nulla, zeby nie przeskakiwac linii w warunku i w petli
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    public static List<String> splitLinesIntoWords(List<String> lines) {
        List<String> wordsResult = new ArrayList<>();
        //trzeba w petli przejsc przez liste lines i dla kazdego elementu podzielic
        //zawartoc po spacji, przecinku, sredniku i wpisac wynik do listy words
        for (String line : lines) {
            //regex dzieli po spacji i pomija przecinki i kropki
            String[] words = line.split("\\s|\\, |\\. |\\.");
            wordsResult.addAll(Arrays.asList(words));
        }
        return wordsResult;
    }
}
