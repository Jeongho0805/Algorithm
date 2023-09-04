package 정렬알고리즘구현;

import java.util.Arrays;

/**
 * Pivot과 Partitioning
 */
public class QuickSort {
    public static void main(String[] args) {

        int[] arr = {3, 5, 2, 7, 1, 9, 0, 15};
        quickSort(arr, 0, arr.length-1);
        Arrays.stream(arr).forEach(n -> System.out.print(n + " "));
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        // Choose the middle element as the pivot
        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        // Move the pivot to the end (swap arr[mid] and arr[high])
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;

        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }
}
