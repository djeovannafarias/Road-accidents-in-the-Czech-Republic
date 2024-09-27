package Road_Accidents;

import java.io.*;

import Algoritmos.CountingSortT;
import Algoritmos.HeapSortT;
import Algoritmos.InsertionSort;
import Algoritmos.MergeSortT;
import Algoritmos.QuickSortT;
import Algoritmos.QuickSort_Mediana3T;
import Algoritmos.SelectionSort;

import java.io.*;

public class AccidentProcessorTime {

    public static String[][] readCsv(String filePath) {
        String[][] records = new String[1000][]; // Inicia com um array grande
        int index = 0; // Contador de registros lidos

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            // Ler os cabeçalhos
            line = br.readLine();
            records[index++] = line.split(",");

            // Ler cada linha do arquivo
            while ((line = br.readLine()) != null) {
                if (index >= records.length) {
                    // Aumenta o tamanho do array se necessário
                    String[][] newRecords = new String[records.length * 2][];
                    System.arraycopy(records, 0, newRecords, 0, records.length);
                    records = newRecords;
                }
                records[index++] = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Copia os registros para um novo array do tamanho exato
        String[][] finalRecords = new String[index][];
        System.arraycopy(records, 0, finalRecords, 0, index);
        return finalRecords;
    }

    public static void sortAndSave(String[][] records, String algorithm, String caso) {
        // Copia os registros para um novo array para ordenar
        String[][] recordsToSort = new String[records.length][];
        for (int i = 0; i < records.length; i++) {
            recordsToSort[i] = records[i]; // Copia cada linha
        }

        long startTime = System.currentTimeMillis();

        switch (algorithm) {
            case "insertionSort":
                InsertionSort.insertionSortT(recordsToSort, caso, 3); // Índice 3 para o campo "time"
                break;
            case "selectionSort":
                SelectionSort.selectionSortT(recordsToSort, caso, 3);
                break;
            case "mergeSort":
                MergeSortT.mergeSort(recordsToSort, caso, 3);
                break;
            case "quickSort":
                QuickSortT.quickSort(recordsToSort, caso, 3);
                break;
            case "quickSortMedianaDeTres":
                QuickSort_Mediana3T.quickSortMedianaDeTres(recordsToSort, caso, 3);
                break;
            case "countingSort":
                CountingSortT.countingSort(recordsToSort, caso, 3); // Para counting sort o campo deve ser numérico
                break;
            case "heapSort":
                HeapSortT.heapSort(recordsToSort, caso, 3);
                break;
            default:
                throw new IllegalArgumentException("Algoritmo desconhecido: " + algorithm);
        }

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        // Grava o resultado em um arquivo CSV
        String outputFilePath = "./util/accidents_NCBMV_time_" + algorithm + "_" + caso + ".csv";
        writeCsv(recordsToSort, outputFilePath);

        // Adiciona o tempo de execução a um arquivo separado
        appendExecutionTime(algorithm, caso, executionTime);
    }

    public static void writeCsv(String[][] records, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] record : records) {
                if (record != null) { // Verifica se o registro não é nulo
                    bw.write(String.join(",", record));
                    bw.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendExecutionTime(String algorithm, String caso, long time) {
        String outputFilePath = "./util/execution_times.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFilePath, true))) {
            bw.write(algorithm + "," + caso + "," + time + "ms");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}