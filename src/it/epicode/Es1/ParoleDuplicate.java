package it.epicode.Es1;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParoleDuplicate {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di elementi: ");
        int n = scanner.nextInt();
        System.out.println("Inserisci " + n + " parole:");

        Set<String> set = new HashSet<>();
        Set<String> duplicates = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            String word = scanner.next();
            if (!set.add(word)) {
                duplicates.add(word);
            }
        }

        System.out.println("Numero di parole distinte: " + set.size());
        System.out.println("Parole distinte: " + set);

        if (!duplicates.isEmpty()) {
            System.out.println("Parole duplicate: " + duplicates);
        } else {
            System.out.println("Nessun duplicato trovato.");
        }
    }
}