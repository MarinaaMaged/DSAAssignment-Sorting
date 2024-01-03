import java.util.Arrays;

public class BubbleSort {
    private static int comparisons=0;
    private static int interchanges=0;

    public static void sort(int[] array) {
        comparisons = 0;
        interchanges = 0;

        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    interchanges++;

                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    public static int getComparisons() {
        return comparisons;
    }

    public static int getInterchanges() {
        return interchanges;
    }

    public static void simulateSort(int[] array) {
        System.out.println("Original: " + Arrays.toString(array));

        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                comparisons++;
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    interchanges++;
                    System.out.println(Arrays.toString(array));
                }

            }

            if (!swapped) {
                break;
            }
        }
    }
}
