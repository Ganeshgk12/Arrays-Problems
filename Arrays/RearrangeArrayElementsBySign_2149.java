package Programs.striverz.Arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class RearrangeArrayElementsBySign_2149 {
    public static void main(String[] args) {
        int [] arr = {-1,3,8,-4,-6,-1,7,2};
        //System.out.println(Arrays.toString(rearrangeArray(arr)));
        System.out.println(Arrays.toString(reArrangeArray2(arr)));
    }

    // LeetCode - The Positive and Negative no s Length is equal
    public static int[] rearrangeArray(int[] nums) {
        int positiveIndex = 0;
        int negativeIndex = 1;
        int [] ans = new int [nums.length];
        for(int i = 0; i < nums.length; i++){
            if(nums[i] < 0){
                ans[negativeIndex] = nums[i];
                negativeIndex += 2;
            }else{
                ans[positiveIndex] = nums[i];
                positiveIndex += 2;
            }
        }
        return ans;
    }

    // If The Positive and Negative no s Length is not equal

    public static int [] reArrangeArray2(int [] arr){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0){
                neg.add(arr[i]);
            }else {
                pos.add(arr[i]);
            }
        }

        if (pos.size() > neg.size()){
            for (int i = 0; i < neg.size(); i++) {
                arr[i*2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }
            int idx = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr[idx] = pos.get(i);
                idx++;
            }
        }else {
            for (int i = 0; i < pos.size(); i++) {
                arr[i*2] = pos.get(i);
                arr[i * 2 + 1] = neg.get(i);
            }
            int idx = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr[idx] = neg.get(i);
                idx++;
            }
        }
        return arr;
    }


    // its My Intuttion only Work in small Cases (Dont Refer this)
    public static void reArrange(int [] nums){
        int n = nums.length;
        boolean isPos = true;

        for (int i = 0; i < n; i++){
            if (isPos){
                if(nums[i] >= 0){
                    isPos = false;
                }else{
                    int idx = i + 1;
                    while(idx < nums.length){
                        if(nums[idx] >= 0){
                            int temp = nums[i];
                            nums[i] = nums[idx];
                            nums[idx] = temp;
                            isPos = false;
                            break;
                        }else{
                            idx++;
                        }
                    }
                }
            }else{
                if(nums[i] < 0){
                    isPos = true;
                }else{
                    int negIdx = i + 1;
                    while(negIdx < nums.length){
                        if (nums[negIdx] < 0){
                            int temp = nums[i];
                            nums[i] = nums[negIdx];
                            nums[negIdx] = temp;
                            isPos = true;
                            break;
                        }else{
                            negIdx++;
                        }
                    }
                }
            }
        }
    }
}
