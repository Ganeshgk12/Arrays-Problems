package Programs.striverz.Arrays;

import java.util.ArrayList;

public class UnionOfArray {
    public static void main(String[] args) {

        int [] a = {1, 2, 3, 4, 6};
        int [] b = {2,3,5};

        System.out.println(sortedArray(a,b));

    }

    public static ArrayList<Integer> sortedArray(int a[], int b[])  {
        int i = 0;
        int j = 0;

        ArrayList<Integer> Union = new ArrayList<>();
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]){
                if (Union.isEmpty() || Union.get(Union.size() - 1) != a[i]) {
                    Union.add(a[i]);
                }
                i++;
            } else {
                if (Union.isEmpty() || Union.get(Union.size() - 1) != b[j]) {
                    Union.add(b[j]);
                }
                j++;
            }
        }

        while (i < a.length) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != a[i]) {
                Union.add(a[i]);

            }
            i++;
        }
        while (j < b.length) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != b[j]) {
                Union.add(b[j]);

            }
            j++;
        }

        return Union;
    }
}

