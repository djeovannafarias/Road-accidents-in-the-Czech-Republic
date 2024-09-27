package Algoritmos;

import java.util.*;

public class MergeSortT {

    public static void mergeSort(String[][] records, String caso, int coluna) {
        if (records.length < 2) return;

        int mid = records.length / 2;
        String[][] left = Arrays.copyOfRange(records, 0, mid);
        String[][] right = Arrays.copyOfRange(records, mid, records.length);

        mergeSort(left, caso, coluna);
        mergeSort(right, caso, coluna);

        merge(records, left, right, caso, coluna);
    }

    public static void merge(String[][] records, String[][] left, String[][] right, String caso, int coluna) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            int leftValue = Integer.parseInt(left[i][coluna]);
            int rightValue = Integer.parseInt(right[j][coluna]);

            boolean condition = (caso.equals("piorCaso") ? leftValue < rightValue : leftValue > rightValue);

            if (condition) {
                records[k++] = left[i++];
            } else {
                records[k++] = right[j++];
            }
        }

        while (i < left.length) {
            records[k++] = left[i++];
        }

        while (j < right.length) {
            records[k++] = right[j++];
        }
    }
}
