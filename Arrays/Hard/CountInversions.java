package Programs.striverz.Arrays.Hard;

import java.util.ArrayList;

public class CountInversions {
    public static void main(String[] args) {
        int [] a = {4,3,2,1,7,5};
        System.out.println(numberOfInversion(a));
    }
    public static int numberOfInversion(int [] a){
        return mergeSort(a,0,a.length - 1);
    }

    private static int mergeSort (int [] arr, int low ,int high) {
        int cnt = 0;

        if (low >= high) {
            return cnt;
        }

        int mid = (low + high) / 2;

        cnt += mergeSort(arr,low,mid);
        cnt += mergeSort(arr,mid + 1,high);
        cnt += merge(arr,low,mid,high);
        return cnt;
    }

    private static int merge (int [] arr,int low,int mid,int high) {
        ArrayList<Integer> temp = new ArrayList<>();
        int cnt = 0;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]){
                temp.add(arr[left]);
                left++;
            }else {
                temp.add(arr[right]);
                cnt += (mid - left + 1);
                right++;
            }
        }

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
        return cnt;
    }
}
