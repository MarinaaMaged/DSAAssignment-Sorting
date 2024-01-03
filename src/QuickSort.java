import java.util.Arrays;

public class QuickSort {
    private static int comparisons;
    private static int interchanges;

    public static void sort(int[] array) {
        comparisons = 0;
        interchanges = 0;
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            comparisons++;
            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                interchanges++;

            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        interchanges++;

        return i + 1;
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static int getInterchanges() {
        return interchanges;
    }

    public static void simulateSort(int[] array) {
        System.out.println("Original: " + Arrays.toString(array));
        quickSortt(array, 0, array.length - 1);
    }
    private static void quickSortt(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partitionn(array, low, high);
            quickSortt(array, low, partitionIndex - 1);
            quickSortt(array, partitionIndex + 1, high);
        }
    }

    private static int partitionn(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (array[j] < pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;

            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        System.out.println(Arrays.toString(array));
        return i + 1;
    }
}
