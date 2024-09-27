package Algoritmos;

import java.util.Date;

public class InsertionSort{
    
	public static void insertionSort(String[][] records, String caso) {
        // A implementação do Insertion Sort deve considerar o caso especificado.
        int n = records.length;

        // Adapte o caso de ordenação para os diferentes cenários
        for (int i = 1; i < n; i++) {
            String[] key = records[i];
            int j = i - 1;

            // Ordena em ordem decrescente pela data (campo 2)
            while (j >= 0 && (caso.equals("piorCaso") ? key[2].compareTo(records[j][2]) > 0 :
                    caso.equals("melhorCaso") ? key[2].compareTo(records[j][2]) < 0 :
                    key[2].compareTo(records[j][2]) > 0)) {
                records[j + 1] = records[j];
                j = j - 1;
            }
            records[j + 1] = key;
        }
    }
	
	public static void insertionSortT(String[][] records, String caso, int coluna) {
        int n = records.length;

        for (int i = 1; i < n; i++) {
            String[] key = records[i];
            int j = i - 1;

            // Converte o campo "time" (coluna 3) para inteiro para realizar a comparação
            int keyTime = Integer.parseInt(key[coluna]);

            // Define a comparação com base no caso
            while (j >= 0 && (caso.equals("piorCaso") ? Integer.parseInt(records[j][coluna]) < keyTime :
                    caso.equals("melhorCaso") ? Integer.parseInt(records[j][coluna]) > keyTime :
                    Integer.parseInt(records[j][coluna]) > keyTime)) {
                records[j + 1] = records[j];
                j = j - 1;
            }
            records[j + 1] = key;
        }
	}

}