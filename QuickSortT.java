package Algoritmos;

public class QuickSortT {

    public static void quickSort(String[][] records, String caso, int coluna) {
        quickSort(records, 0, records.length - 1, caso, coluna);
    }

    private static void quickSort(String[][] records, int low, int high, String caso, int coluna) {
        if (low < high) {
            int pi = partition(records, low, high, caso, coluna);
            quickSort(records, low, pi - 1, caso, coluna);
            quickSort(records, pi + 1, high, caso, coluna);
        }
    }

    static int partition(String[][] records, int low, int high, String caso, int coluna) {
        int pivot = Integer.parseInt(records[high][coluna]);
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            int currentValue = Integer.parseInt(records[j][coluna]);

            boolean condition = (caso.equals("piorCaso") ? currentValue > pivot : currentValue < pivot);

            if (condition) {
                i++;
                String[] temp = records[i];
                records[i] = records[j];
                records[j] = temp;
            }
        }

        String[] temp = records[i + 1];
        records[i + 1] = records[high];
        records[high] = temp;

        return i + 1;
    }
}
