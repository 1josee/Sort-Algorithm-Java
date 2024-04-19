package MergeSort;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
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

        // Call quicksort method
        mergeSort(numbers);

        // Print array after sorting
        System.out.println("After");
        System.out.println(Arrays.toString(numbers));
    }

    public static void mergeSort(int[] inputArray){
        int inputLength = inputArray.length;
        // Return when array only have 1 element
        if(inputLength < 2){
            return;
        }
        // Initialize mid index of the array
        int midIndex = inputLength / 2;
        int[] leftHalf = new int [midIndex];
        int[] rightHalf = new int [inputLength - midIndex];

        // Fill up left half array
        for (int i = 0; i < midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        // Fill up right half array
        for (int i = midIndex; i < inputLength; i++){
            rightHalf[i - midIndex] = inputArray[i];
        }

        // Call recursive method merge sort for left half and right half
        mergeSort(leftHalf);
        mergeSort(rightHalf);

        // Merge two half to the array
        merge(inputArray, leftHalf, rightHalf);
    }

    public static void merge (int[] inputArray, int[] leftHalf, int[] rightHalf){
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int  i = 0, j = 0, k = 0;

        // Merging element from left half and right half to the array
        while (i < leftSize && j < rightSize){
            if (leftHalf[i] <= rightHalf[j]){
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // Add remaining element of left half to array
        while (i < leftSize){
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }
        // Add remaining element of right half to array
        while (j < rightSize){
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }
}
