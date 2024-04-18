package QuickSort;

import java.util.Arrays;
import java.util.Random;

public class Quicksort {
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
        quicksort(numbers, 0, numbers.length - 1);

        // Print array after sorting
        System.out.println("After");
        System.out.println(Arrays.toString(numbers));
    }

    // Quicksort method
    private static void quicksort(int[] array, int lowIndex, int highIndex){
        // Stop sorting when array only have 1 element
        if (lowIndex >= highIndex){
            return;
        }
        // Choose random pivot between lowIndex and highIndex
        int pivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[pivotIndex];
        // Swap position of pivot and highIndex element
        swap(array, pivotIndex, highIndex);
        // Call the partition method and return the leftPointer index
        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        // Call recursive quicksort method left half and right half of the array
        quicksort(array, lowIndex, leftPointer -1);
        quicksort(array, leftPointer + 1, highIndex);
    }

    // Partitioning method
    private static int partition(int[] array, int lowIndex, int highIndex, int pivot){
        // Initial index of left pointer and right pointer
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        // Loop through the array to partitioning left half and right half of the array
        while (leftPointer < rightPointer){
            // Find the left element that greater than pivot
            while (array[leftPointer] <= pivot && leftPointer < rightPointer){
                leftPointer++;
            }
            // Find the right element that less than pivot
            while (array[rightPointer] >= pivot && leftPointer < rightPointer){
                rightPointer--;
            }
            // Swap position of two elements
            swap(array, leftPointer, rightPointer);
        }
        // Swap the element at the left pointer with the pivot element
        swap(array, leftPointer, highIndex);
        return leftPointer;
    }

    // Swap two element method
    private static void swap(int[] array, int index1, int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}
