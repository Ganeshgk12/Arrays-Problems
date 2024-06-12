package Programs.striverz.Arrays.Hard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Arrays;

public class MergeIntervals_56 {
    public static void main(String[] args)  {
        int [][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        // output : [[1,6],[8,10],[15,18]]
    }

    public static int[][] merge(int[][] intervals){
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++){

            if(ans.isEmpty() || intervals[i][0] > ans.get(ans.size() - 1).get(1)){

                ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));

            }else{

                ans.get(ans.size() - 1).set(1,Math.max(ans.get(ans.size() - 1).get(1), intervals[i][1]));
            }
        }
        int[][] result = new int[ans.size()][2];
        int index = 0;
        for (List<Integer> interval : ans) {
            result[index][0] = interval.get(0);
            result[index][1] = interval.get(1);
            index++;
        }

        return result;
    }
}
