package leetcode.questionBank.intToRoman;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        rotate1(matrix);
    }
    //不分奇偶数的写法
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        if(n == 0||n == 1){
            return;
        }
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n-1-i; j++){
                //每次交换，按着如下顺序调换位置，可以通过画图观察出（其实是根据调换规律得出来的）
                int temp = matrix[i][j];
                //此时n-1是因为计算字符位置是是从0开始的
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

    }
    public static void rotate1(int[][] matrix) {
        //判断二维数组的长度
        int n=matrix.length;
        if(n==1||n==0){
            return;
        }
        //判断n是奇偶数
        //当n为偶数时
        if(n%2==0){
            for (int i = 0; i <n/2 ; i++) {
                for (int j = 0; j <n/2 ; j++) {
                    //定义临时变量
                    int temp=matrix[i][j];
                    //根据matrix[第i行][第j列] => matrix[第j行][第n+1-i列]
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;
                }
            }
        }else {
            for(int i = 0; i < (n-1)/2; i++){
                for(int j = 0; j < (n+1)/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;
                }
            }
        }
    }

}
