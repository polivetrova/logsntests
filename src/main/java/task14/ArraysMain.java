package task14;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysMain {

    static ArrayList<Integer> cutArrayAfterLastFour(int[] arr) {

        if(Arrays.stream(arr).noneMatch(k -> k == 4)){
            throw new RuntimeException();
        }

        ArrayList<Integer> arr1 = new ArrayList<>();
        for (int i = arr.length - 1; i > 0; i--) {
            if (arr[i] != 4) {
                arr1.add(0, arr[i]);
            } else {
                break;
            }
        }
        return arr1;
    }

    static boolean checkArray(int[] arr) {
        boolean containsOne = false;
        boolean containsFour = false;

        for (Integer elem : arr) {
            if (elem == 1) {
                containsOne = true;
            } else if (elem == 4) {
                containsFour = true;
            } else {
                return false;
            }
        }
        return containsOne && containsFour;
    }
}
