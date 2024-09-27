package Algoritmos;

public class QuickSort_Mediana3T {

    public static void quickSortMedianaDeTres(String[][] records, String caso, int coluna) {
        quickSort(records, 0, records.length - 1, caso, coluna);
    }

    private static void quickSort(String[][] records, int low, int high, String caso, int coluna) {
        if (low < high) {
            int pi = partitionMedianaDeTres(records, low, high, caso, coluna);
            quickSort(records, low, pi - 1, caso, coluna);
            quickSort(records, pi + 1, high, caso, coluna);
        }
    }

    private static int partitionMedianaDeTres(String[][] records, int low, int high, String caso, int coluna) {
        int mid = low + (high - low) / 2;
        int pivot = medianaDeTres(records, low, mid, high, coluna);
        String[] temp = records[pivot];
        records[pivot] = records[high];
        records[high] = temp;

        return QuickSortT.partition(records, low, high, caso, coluna);
    }

    private static int medianaDeTres(String[][] records, int low, int mid, int high, int coluna) {
        int lowValue = Integer.parseInt(records[low][coluna]);
        int midValue = Integer.parseInt(records[mid][coluna]);
        int highValue = Integer.parseInt(records[high][coluna]);

        if (lowValue > midValue) {
            if (lowValue < highValue) return low;
            else if (midValue > highValue) return mid;
            else return high;
        } else {
            if (lowValue > highValue) return low;
            else if (midValue < highValue) return mid;
            else return high;
        }
    }
}
