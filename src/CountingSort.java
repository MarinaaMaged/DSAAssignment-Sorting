import java.util.Arrays;

public class CountingSort {
    private static int comparisons;
    private static int interchanges;

    public static void sort(int[] array) {
        comparisons = 0;
        interchanges = 0;

        int max = Arrays.stream(array).max().orElse(0);
        int[] count = new int[max + 1];

        for (int num : array) {
            count[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            while (count[i] > 0) {
                array[index++] = i;
                count[i]--;

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

        int max = Arrays.stream(array).max().orElse(0);
        int[] count = new int[max + 1];

        for (int num : array) {
            count[num]++;
        }

        System.out.println("Step 1 (Count): " + Arrays.toString(count));

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("Step 2 (Cumulative Sum): " + Arrays.toString(count));

        int[] sortedArray = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int num = array[i];
            sortedArray[count[num] -1] = num;
            count[num]--;
            System.out.println("Step 3 (Build Sorted Array): " + Arrays.toString(sortedArray));
        }
    }

}
