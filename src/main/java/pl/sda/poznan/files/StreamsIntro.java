package pl.sda.poznan.files;

import java.io.*;

public class StreamsIntro {

    public static void main(String[] args) throws IOException {
        File file = new File("plik.txt");

        InputStream inputStream = new FileInputStream(file);

        byte[] buffer = new byte[255];
        int read = inputStream.read(buffer);
        inputStream.close();

        char[] charBuffer = new char[255];
        FileReader reader = new FileReader(file);
        reader.read(charBuffer);

    }
}
