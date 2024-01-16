package it.epicode.Es2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lista {

    public static List<Integer> generateRandomList(int N) {
        List<Integer> randomList = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < N; i++) {
            int num = random.nextInt(101);
            randomList.add(num);
        }

        randomList.sort(null);
        return randomList;
    }

    public static List<Integer> duplicateReverseList(List<Integer> list) {
        List<Integer> duplicateReverseList = new ArrayList<>(list);

        for (int i = list.size() - 2; i >= 0; i--) {
            duplicateReverseList.add(list.get(i));
        }

        return duplicateReverseList;
    }

    public static void printList(List<Integer> list, boolean printPari) {
        for (int i = 0; i < list.size(); i++) {
            if (printPari && i % 2 == 0) {
                System.out.println(list.get(i));
            } else if (!printPari && i % 2 != 0) {
                System.out.println(list.get(i));
            }
        }
    }

    public static void main(String[] args) {
        int N = 10;
        List<Integer> randomList = generateRandomList(N);
        System.out.println("Lista Random: " + randomList);

        List<Integer> duplicateReverseList = duplicateReverseList(randomList);
        System.out.println("Lista Duplicata Inversa: " + duplicateReverseList);

        System.out.println("Posizioni pari:");
        printList(randomList, true);

        System.out.println("Posizioni dispari:");
        printList(randomList, false);
    }
}
