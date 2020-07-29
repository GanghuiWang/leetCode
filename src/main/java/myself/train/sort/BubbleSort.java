package myself.train.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[] result = bubblSort(arr);
        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i] + "  ");
        }
    }
    public static int[] bubblSort(int[] arr){
        //i表示的是趟数
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = arr.length - 1; j>i; j--) {
                if(arr[j]<arr[j-1]){
                    int temp=arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }
            }
        }
        return arr;
    }
}
