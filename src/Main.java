// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.Arrays;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        int[] randomArray = generateRandomArray(size);
        int[] sortedArray = generateSortedArray(size);
        int[] reverseSortedArray = generateReverseSortedArray(size);

        System.out.println("\nSimulation of Sorting Algorithms:\n");

        simulateSort("Random", randomArray);
        simulateSort("Sorted", sortedArray);
        simulateSort("Reverse Sorted", reverseSortedArray);

        System.out.println("\nComparison Results:\n");

        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n", "Array Type", "Array Size", "Sort Type",
                "Execution Time", "Comparisons", "Interchanges");

        compareSorts("Random", size, randomArray);
        compareSorts("Sorted", size, sortedArray);
        compareSorts("Reverse Sorted", size, reverseSortedArray);

    }
    private static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * size);
        }
        return array;
    }

    private static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

private static void compareSorts(String arrayType, int size, int[] array) {
    System.out.printf("%-15s%-15d\n", arrayType, size);

    System.out.printf("%-15s%-15s%-15s%-15s\n", "Sort Type", "Execution Time", "Comparisons", "Interchanges");

    long startTime, endTime;
    int[] tempArray;

    // Counting Sort
    tempArray = Arrays.copyOf(array, array.length);
    startTime = System.nanoTime();
    CountingSort.sort(tempArray);
    endTime = System.nanoTime();
    printResults("Counting Sort", endTime - startTime, CountingSort.getComparisons(), CountingSort.getInterchanges());

    // Bubble Sort
    tempArray = Arrays.copyOf(array, array.length);
    startTime = System.nanoTime();
    BubbleSort.sort(tempArray);
    endTime = System.nanoTime();
    printResults("Bubble Sort", endTime - startTime, BubbleSort.getComparisons(), BubbleSort.getInterchanges());

    // Quick Sort
    tempArray = Arrays.copyOf(array, array.length);
    startTime = System.nanoTime();
    QuickSort.sort(tempArray);
    endTime = System.nanoTime();
    printResults("Quick Sort", endTime - startTime, QuickSort.getComparisons(), QuickSort.getInterchanges());

    System.out.println();
}

    private static void printResults(String sortType, long executionTime, int comparisons, int interchanges) {
        System.out.printf("%-15s%-15d%-15d%-15d\n", sortType, executionTime, comparisons, interchanges);
    }

    private static void simulateSort(String arrayType, int[] array) {
        System.out.println("Simulation for " + arrayType + " Array:");

        System.out.println("Original Array: " + Arrays.toString(array));

        int[] tempArray;

        // Counting Sort
        tempArray = Arrays.copyOf(array, array.length);
        System.out.println("\nCounting Sort:");
        CountingSort.simulateSort(tempArray);

        // Bubble Sort
        tempArray = Arrays.copyOf(array, array.length);
        System.out.println("\nBubble Sort:");
        BubbleSort.simulateSort(tempArray);

        // Quick Sort
        tempArray = Arrays.copyOf(array, array.length);
        System.out.println("\nQuick Sort:");
        QuickSort.simulateSort(tempArray);

        System.out.println();
    }



}