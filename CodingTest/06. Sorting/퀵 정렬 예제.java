import java.io.IOException;

public class Main {
    public static void quickSort(int[] arr, int start, int end) {
        if (start >= end) return;
        int pivot = start;
        int left = start + 1;
        int right = end;

        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) left++;
            while (right > start && arr[right] >= arr[pivot]) right--;

            if (left > right) {
                int tmp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = tmp;
            } else {
                int tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
            }
        }
        quickSort(arr, start, right - 1);
        quickSort(arr, right + 1, end);
    }

    public static void main(String[] args) throws IOException {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        quickSort(arr, 0, n - 1);
        
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
