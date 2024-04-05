package org.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CharCounter {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Inserisci una parola:");
        String word = scan.nextLine();

        //definisco la mia map
        Map<Character, Integer> characterCounter = new HashMap<>();

        for (Character character : word.toCharArray()){
            //Il metodo get or Default controlla se nella nostra mappa c'e' gia' l'occorrenza di
            //quel carattere altrimenti la inizializza con il valore di default ovvero il secondo parametro passato
            //nel nostro caso a 0 e gli aggiungiamo 1, fa questo ciclando su ogni carattere e quindi aggiungendo +1
            //ad ogni occorrenza di quel carattere
            characterCounter.put(character, characterCounter.getOrDefault(character, 0) + 1);
        }

        for (char carattere : characterCounter.keySet()) {
            int numeroOccorrenze = characterCounter.get(carattere);
            System.out.println(carattere + ":" + numeroOccorrenze);
        }
    }
}
