package Programs.striverz.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII_229 {
    public static void main(String[] args) {
        int [] nums = {1,2};
        System.out.println(majorityElement(nums));
    }
    public static List<Integer> majorityElement(int[] nums) {
        int cnt1 = 0;
        int cnt2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (cnt1 == 0 && ele2 != nums[i]){
                cnt1 = 1;
                ele1 = nums[i];
            } else if (cnt2 == 0 && ele1 != nums[i]) {
                cnt2 = 1;
                ele2 = nums[i];
            } else if (nums[i] == ele1) {
                cnt1++;
            } else if (nums[i] == ele2) {
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }
        List<Integer> list = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (ele1 == nums[i]) cnt1++;
            if (ele2 == nums[i]) cnt2++;
        }

        int mini = (int) nums.length / 3;
        if (cnt1 > mini) list.add(ele1);
        if (cnt2 > mini) list.add(ele2);

        return list;
    }
}
