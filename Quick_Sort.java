import java.util.*;
class Main{
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j <= high - 1; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }
    static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    static void QuickSort(int[] arr, int low, int high){
        if (low < high){
            int pi = partition(arr, low, high);
            QuickSort(arr, low, pi - 1);
            QuickSort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args){
        System.out.println("original array: ");
            int arr[] = {10, 7, 8, 9, 1, 5};
            System.out.println(Arrays.toString(arr));
            int n = arr.length;
            System.out.println("Sorted array: ");
            QuickSort(arr,0,n - 1);
            for (int val : arr){
                System.out.print(val +" ");
            }
    }
}