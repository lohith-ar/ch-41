import java.util.LinkedList;

public class QuickSort{

    static void quickSort(int[] price, int start, int end) {
        int partition = partition(price, start, end);
        if (partition - 1 > start)
            quickSort(price, start, partition - 1);
        if (partition + 1 < end)
            quickSort(price, partition + 1, end);
    }
    static int partition(int[] price, int start, int end) {
        // choose pivot
        int pivot = price[end];
        // loop through the array
        for (int i = start; i < end; i++) {
            // check for elements that are less than pivot
            // swap accordingly
            if (price[i] < pivot) {
                swap(price, start, i);
                start++;
            }
        }
        swap(price, start, end);
        return start;
    }
    static void swap(int[] price, int index1, int index2) {
        // String tmp = Task41.data1[index1];
        // Task41.data1.set(index1, Task41.data1[index2]);
        // Task41.data1.set(index2, tmp);
        String tmp = Task41.data1[index1];
        Task41.data1[index1] = Task41.data1[index2];
        Task41.data1[index2] = tmp;
    
        int temp = price[index1];
        price[index1] = price[index2];
        price[index2] = temp;
    }



    static void quickSort1(float[] rating2, int start, int end) {
        int partition = partition1(rating2, start, end);
        if (partition - 1 > start)
            quickSort1(rating2, start, partition - 1);
        if (partition + 1 < end)
            quickSort1(rating2, partition + 1, end);
    }
    static int partition1(float[] rating2, int start, int end) {
        // choose pivot
        float pivot = rating2[end];
        // loop through the array
        for (int i = start; i < end; i++) {
            // check for elements that are less than pivot
            // swap accordingly
            if (rating2[i] > pivot) {
                swap1(rating2, start, i);
                start++;
            }
        }
        swap1(rating2, start, end);
        return start;
    }
    static void swap1(float[] rating2, int index1, int index2) {
        String tmp = Task41.data1[index1];
        Task41.data1[index1] = Task41.data1[index2];
        Task41.data1[index2] = tmp;
        float temp = rating2[index1];
        rating2[index1] = rating2[index2];
        rating2[index2] = temp;
    }
}