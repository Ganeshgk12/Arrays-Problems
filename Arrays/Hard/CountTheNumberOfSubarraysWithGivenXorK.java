package Programs.striverz.Arrays.Hard;

import java.util.HashMap;

public class CountTheNumberOfSubarraysWithGivenXorK {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        System.out.println("The number of subarrays with XOR k is: " +
                 subarraysWithXorK(a, k));
    }

    public static int subarraysWithXorK(int [] arr,int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int cnt = 0;
        int xor = 0;
        map.put(0,1);

        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];

            int x = xor ^ k;
            if (map.containsKey(x)){
                cnt += map.get(x);
            }

            if (map.containsKey(xor)){
                map.put(xor, map.get(xor) + 1);
            }else {
                map.put(xor,1);
            }
        }
        return cnt;
    }
}
