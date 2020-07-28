package zuoshen.stack.monotonousstack;

import java.util.Stack;

public class MonotonousStack {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] resultByArray = rightWay(arr);
        int[][] resultByStack = getNearLessNoRepeat(arr);
        //遍历二维数组
        for (int i = 0; i <arr.length ; i++) {
                for (int j = 0; j <resultByArray[i].length; j++) {
                System.out.print(resultByArray[i][j]+"  ");
            }
            System.out.println("  ");
        }
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <resultByStack[i].length; j++) {
                System.out.print(resultByStack[i][j]+"  ");
            }
            System.out.println("  ");
        }

    }
    public static int[][] rightWay(int[] arr){
        //定义结果集
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            //定义无法找到符合条件时间left和right下标
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            //开始求复合条件的left
            int cur = i - 1;
            while (cur >= 0) {
                if (arr[cur] < arr[i]) {
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            //开始求复合条件的right
            cur = i + 1;
            while (cur < arr.length) {
                if (arr[cur] < arr[i]) {
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }
    public static int[][]  getNearLessNoRepeat(int[] arr){
        //定义一个栈
        Stack<Integer> stack=new Stack<>();
        //定义结果集
        int[][] res = new int[arr.length][2];
        //开始遍历
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty()&&arr[stack.peek()]>arr[i]){
                int popIndex = stack.pop();
                //判断stack
                int leftLessIndex = stack.isEmpty() ? -1 : stack.peek();
                res[popIndex][0]=leftLessIndex;
                res[popIndex][1]=i;
            }
            stack.push(i);
        }
        //当执行完循环，此时i为数组最后一位
        while (!stack.isEmpty()){
            int popIndex = stack.pop();
            int leftIndex = stack.isEmpty() ? -1 : stack.peek();
            res[popIndex][0] = leftIndex;
            res[popIndex][1] = -1;
        }
        return res;
    }
}
