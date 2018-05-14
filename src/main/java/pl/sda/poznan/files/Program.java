package pl.sda.poznan.files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

    public static void fileIntro() {
        File plik = new File("plik.txt");

        if (plik.exists()) {
            System.out.println("Plik istnieje - usuwam");
            plik.delete();
        }
        try {
            boolean isCreated = plik.createNewFile();
            System.out.println(isCreated ? "Utworzono plik" : "Nie utworzono pliku");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Wypisuje pliki z /home/kuba/IdeaProjects
    public static void listFiles(File file) {
        File[] subFiles = file.listFiles();
        for (File subFile : subFiles) {
            System.out.println("Filename | r | w | x | isFile | isDirectory");
            System.out.println(
                    String.format("%s | %s | %s | %s | %s | %s",
                            file.getName(),
                            file.canRead(),
                            file.canWrite(),
                            file.canExecute(),
                            file.isFile(),
                            file.isDirectory()
                    ));
            System.out.println("---------------------------------------------");
        }
    }

    public static void main(String[] args) {
        String property = System.getProperty("user.home");
        File currentFile = new File(property);

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);
        while (!exit) {
            System.out.println("---------------------------------------------");
            System.out.println("ls - wyswietla katalogi");
            System.out.println("mkdir nazwa -> tworzy katalogi o danej nazwie");
            System.out.print(currentFile.getAbsolutePath() + ">");
            String operation = scanner.nextLine();
            String[] split = operation.split(" ");

            switch (split[0]) {
                case "ls":
                    listFiles(currentFile);
                    break;
                case "mkdir":
                    System.out.println("Tworze katalog...");
                    String catalogName = split[1];
                    File newCatalog = new File(currentFile.getAbsolutePath() + "/" + catalogName);
                    boolean result = newCatalog.mkdir();
                    System.out.println(result ? "Utworzono katalog" : "Nie utworzono katalogu");
                    break;
                case "exit":
                    exit = true;
                default:
                    System.out.println("nieznane polecenie");
            }
        }

    }
}
