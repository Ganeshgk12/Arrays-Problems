package Programs.striverz.Arrays.Hard;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class PascalsTriangle_118 {
    public static void main(String[] args) {
        int N = 6;
        //System.out.println(pascal(N));

        System.out.println(Arrays.deepToString(pascalTriangleReturnMatrix(N)));
    }
    // Generate All Rows of pascal Triangle in List of List
    public static List<List<Integer>> pascal(int N){
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            ans.add(generateRows(i));
        }
        return ans;
    }

    public static List<Integer> generateRows(int n){
        List<Integer> row = new ArrayList<>();
        long ans = 1;
        row.add((int)ans);

        for (int i = 1; i < n; i++) {
            ans = ans * (n - i);
            ans = ans / i;
            row.add((int)ans);
        }
        return row;
    }

    // Generate Particular Row In pascal Triangle

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        long ans = 1;
        list.add((int)ans);
        for(int i = 1; i <= rowIndex; i++){
            ans = ans * (rowIndex + 1 - i);
            ans = ans / i;
            list.add((int)ans);
        }
        return list;

    }

    // Find Ncr --------> To Find Particular Index value in Pascal Triangle

    public static long findNcr(int n,int row){
        long res = 1;

        for (int i = 0; i < row; i++) {
            res = res * n - i;
            res = res / (i + 1);
        }
        return res;
    }

    // Coding Ninjas Problem

    public static int[][] pascalTriangleReturnMatrix(int N) {
        int [][] ans = new int [N][];

        for (int i = 1; i <= N; i++) {
            ans[i] = getRowsValues(i);
        }
        return ans;
    }

    public static int[] getRowsValues(int row){
        long ans = 1;
        int [] val = new int[row];
        val[0] = (int)ans;

        for (int i = 1; i < row; i++) {
            ans = ans * (row - i);
            ans = ans / (i);
            val[i] = (int)ans;
        }
        return val;
    }

}
