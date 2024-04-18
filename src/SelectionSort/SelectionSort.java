package SelectionSort;

import java.util.Arrays;
import java.util.Random;

public class SelectionSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[10];
        // Generate random numbers array
        for(int i = 0; i < numbers.length; i++){
            numbers[i] = rand.nextInt(100);
        }

        // Print array before sorting
        System.out.println("Before: ");
        System.out.println(Arrays.toString(numbers));

        // Call selection sort method
        selectionSort(numbers);

        // Print array after sorting
        System.out.println("After");
        System.out.println(Arrays.toString(numbers));
    }

    // Selection sort method
    private static void selectionSort(int[] numbers) {
        int length = numbers.length;
        // Loop through the array
        for (int i = 0; i < length - 1; i++){
            // Initial numbers[i] is the min value
            int min = numbers[i];
            int indexOfMin = i;
            for (int j = i + 1; j < length; j++){
                // Update the min value
                if (numbers[j] < min){
                    min = numbers[j];
                    indexOfMin = j;
                }
            }
            // Swap the min value with current index element
            swap(numbers, i, indexOfMin);
        }
    }
    // Swap two element method
    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
