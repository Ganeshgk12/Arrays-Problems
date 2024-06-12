package Programs.striverz.Arrays.Hard;

import java.util.Arrays;

public class FindTheMissingNumAndRepeatedNum {
    public static void main(String[] args) {
        int [] a = {4,2,1,3,3,6};
        System.out.println(Arrays.toString(findMissingAndRepeatNums(a,a.length)));
    }
    public static int [] findMissingAndRepeatNums(int [] a, int N){
        long n = N;
        long actualSum = (n * (n + 1))/ 2;
        long actualSqureofAll = (n * (n + 1) * (2 * n + 1)) / 6;

        long sum = 0;
        long squres = 0;

        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            squres += (long)(a[i]) * (long)(a[i]);
        }

        long val1 = sum - actualSum;
        long val2 = squres - actualSqureofAll;
        val2 = val2 / val1;
        long x = (val1 + val2) / 2;
        long y = x - val1;
        int [] ans = {(int) x,(int) y};
        return ans;
    }
}
