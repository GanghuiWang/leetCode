package zuoshen.stack.monotonousstack;

public class MonotonousStack {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 6, 2, 7};
        int[][] result = rightWay(arr);
        //遍历二维数组
        for (int i = 0; i <arr.length ; i++) {
            for (int j = 0; j <result[i].length; j++) {
                System.out.print(result[i][j]+"  ");
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
}
