package Programs.striverz.Arrays;

import java.util.Arrays;

public class RotateImage_48 {
    public static void main(String[] args) {
        int [][] mat = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(mat);
        System.out.println(Arrays.deepToString(mat));
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < m; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n / 2; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}