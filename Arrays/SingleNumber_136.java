package Programs.striverz.Arrays;

public class SingleNumber_136 {
    public static void main(String[] args) {
        int [] nums = {2,2,1,4,1,3,3};
        System.out.println(singleNum(nums));
    }

    public static int singleNum(int [] nums){
        int xor = 0;

        for (int i = 0; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        return xor;
    }
}
