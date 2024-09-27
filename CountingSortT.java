package Algoritmos;

import java.util.*;

public class CountingSortT {

    public static void countingSort(String[][] records, String caso, int coluna) {
        int n = records.length;

        // Encontrar o maior valor de "time" para definir o tamanho do array de contagem
        int max = 2359;
        String[][] output = new String[n][];

        int[] count = new int[max + 1];

        // Inicializar o array de contagem com 0
        Arrays.fill(count, 0);

        // Contar a frequência dos valores de "time"
        for (int i = 0; i < n; i++) {
            int timeValue = Integer.parseInt(records[i][coluna]);
            count[timeValue]++;
        }

        // Modificar o array de contagem para obter as posições finais
        if (caso.equals("piorCaso")) {
            for (int i = 1; i <= max; i++) {
                count[i] += count[i - 1];
            }
        } else { // Melhor caso ou caso comum
            for (int i = max - 1; i >= 0; i--) {
                count[i] += count[i + 1];
            }
        }

        // Construir o array de saída
        for (int i = n - 1; i >= 0; i--) {
            int timeValue = Integer.parseInt(records[i][coluna]);
            output[count[timeValue] - 1] = records[i];
            count[timeValue]--;
        }

        // Copiar o array ordenado de volta para `records`
        System.arraycopy(output, 0, records, 0, n);
    }
}
