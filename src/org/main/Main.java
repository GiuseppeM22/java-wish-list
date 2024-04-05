package org.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        File root = new File("./resources/data.txt");
        //dichiaro la lista dei regali
        List<String> regali = new ArrayList<>();

        // leggo il contenuto del file metodo in basso
        listReader(root);

        boolean flag = false;
        while (!flag) {
            System.out.println("Vuoi aggiungere un regalo alla lista? y/n");
            if (!regali.isEmpty()) {
                System.out.println("Quantità regali: " + regali.size());
            }
            String regalo = scan.nextLine();
            switch (regalo.toUpperCase()) {
                case "Y":
                    System.out.print("Regalo: ");
                    String regaloScelto = scan.nextLine();
                    regali.add(regaloScelto);
                    break;
                case "N":
                    System.out.println("---------------");
                    flag = true;
                    break;
                default:
                    System.out.println("Input non valido");
                    break;

            }
        }

        System.out.println("Hai fatto " + regali.size() + " regali:");
        //ordino la lista
        Collections.sort(regali);
        System.out.println("Lista regali ordinata: ");
        for (String listaRegali : regali) {
            System.out.println(listaRegali);
        }
        System.out.println("------------------");

        //scrivo i regali nel file
        listWriter(root, regali);
        //rileggo i file
        listReader(root);
    }

    //ALTRI METODI

    //metodo per scrivere i dati
    private static void listWriter(File root, List<String> regali) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(root, true);
            for (String s : regali) {
                fileWriter.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Unable to open file");
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    System.out.println("Unable to close file");
                }
            }
        }
    }

    //metodo per leggere i dati dati dal file
    private static void listReader(File root) {
        System.out.print("Contenuto Lista:");
        try (Scanner fileReader = new Scanner(root)) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        System.out.println();
    }
}
