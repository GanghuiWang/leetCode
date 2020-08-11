package leetcode.questionBank.intToRoman;

public class Rotate {

    public static void main(String[] args) {
        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};
        rotate1(matrix);
    }
    public static void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i][j]; j++) {

            }
        }
    }
    //不分奇偶数的写法
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        if(n == 0||n == 1){
            return;
        }
        for(int i = 0; i < n/2; i++){
            for(int j = 0; j < (n*n/4)/(n/2); j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = temp;
            }
        }

    }

    //分奇偶数情况的写法
    public static void rotate2(int[][] matrix) {
        int n = matrix.length;
        if(n == 0||n == 1){
            return;
        }
        //若n是偶数，%为取模
        if(n%2 == 0){
            for(int i = 0; i < n/2; i++){
                for(int j = 0; j < n/2; j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][i];
                    matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                    matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                    matrix[j][n-1-i] = temp;
                }
            }
        }else{//n为奇数的情况
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
