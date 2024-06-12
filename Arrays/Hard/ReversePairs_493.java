package Programs.striverz.Arrays.Hard;

import java.util.ArrayList;

public class ReversePairs_493 {

    public static void main(String[] args) {
        int [] arr = {40,25,19,12,9,6,2};
        System.out.println(reversePairs(arr));

    }

    private static int reversePairs(int[] nums) {
        return merging(nums,0,nums.length - 1);
    }

    private static int merging (int [] arr,int low,int high){
        int cnt = 0;

        if (low >= high) return cnt;
        int mid = (low + high) / 2;
        cnt += merging(arr,low,mid);
        cnt += merging(arr,mid + 1,high);
        cnt += countPairs(arr,low,mid,high);
        mergeArray(arr,low,mid,high);

        return cnt;
    }

    static int countPairs (int [] a, int low, int mid,int high) {
        int cnt = 0;
        int right = mid + 1;

        for (int i = low; i <= mid ; i++) {
            while (right <= high && (long) a[i] > (long) 2 * a[right]) {
                right++;
            }
            cnt += right - (mid + 1);
        }
        return cnt;
    }

    private static void mergeArray(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}

