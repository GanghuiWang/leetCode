package myself.train.sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[] result = bubblSort(arr);
        for (int i = 0; i <result.length ; i++) {
            System.out.print(result[i] + "  ");
        }
    }
    //冒泡排序时间数组递增（从左至右由小到大）
    /*public static int[] bubblSort(int[] arr){
        for (int i = 0; i <arr.length ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }*/
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
