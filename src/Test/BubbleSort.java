package Test;

public class BubbleSort {
    public void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arrayToSort = {55, 26, 44, 31, 68, 52, 5};
        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arrayToSort);
        System.out.println("Отсортированный массив:");
        for (int i = 0; i < arrayToSort.length; ++i)
            System.out.print(arrayToSort[i] + " ");
    }
}