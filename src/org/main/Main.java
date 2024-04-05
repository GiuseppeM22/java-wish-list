package org.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> regali = new ArrayList<>();

        boolean flag = false;

        while(!flag){
            System.out.println("Vuoi aggiungere un regalo alla lista? y/n");
            if (!regali.isEmpty()){
                System.out.println("Quantità regali: " + regali.size());
            }
            String regalo = scan.nextLine();
            switch (regalo.toUpperCase()){
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
        for (String listaRegali : regali){
            System.out.println(listaRegali);
        }
    }
}
