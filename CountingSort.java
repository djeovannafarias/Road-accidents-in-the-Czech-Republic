package Algoritmos;

import java.util.*;

public class CountingSort {

    public static void countingSort(String[][] records, String caso) {
        // Suponha que a coluna 2 é um campo que pode ser convertido em um número de forma simplificada
        int n = records.length;
        int[] keys = new int[n];

        for (int i = 0; i < n; i++) {
            keys[i] = Integer.parseInt(records[i][2].replaceAll("\\D", "")); // Remove caracteres não numéricos
        }

        int max = Arrays.stream(keys).max().getAsInt();
        int min = Arrays.stream(keys).min().getAsInt();

        int range = max - min + 1;
        int[] count = new int[range];
        String[][] output = new String[n][];

        for (int i = 0; i < n; i++) {
            count[keys[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[keys[i] - min] - 1] = records[i];
            count[keys[i] - min]--;
        }

        for (int i = 0; i < n; i++) {
            records[i] = output[i];
        }
    }
}
