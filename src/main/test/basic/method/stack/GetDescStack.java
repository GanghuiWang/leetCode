package basic.method.stack;

import java.util.Stack;

public class GetDescStack {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[] res = descArray(arr);
        for (int i = 0; i <res.length ; i++) {
            System.out.println(res[i]+"  ");
        }
    }
    public static int[] descArray(int[] arr){
        int[] result = new int[arr.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i <arr.length ; i++) {
            int[] tempArray = new int[i];
            int index=0;
            while (!stack.isEmpty()&&arr[i]<=stack.peek()){
                tempArray[index]=stack.pop();
                index++;
            }
            stack.push(arr[i]);

            for (int j = tempArray.length-1; j >=0 ; j--) {
                if(tempArray[j]!=0)
                    stack.push(tempArray[j]);
            }
        }

        //栈是递减的，那么数组就是递增的
        for (int i = 0; i < arr.length; i++) {
            result[i]=stack.pop();
        }
        return result;
    }
}
