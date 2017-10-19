// Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

// Note: The solution set must not contain duplicate triplets.

// For example, given array S = [-1, 0, 1, 2, -1, -4],

// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Created by harry on 19/10/2017.
 */

public class Solution {
    public static void main(String[] args) {
        int[] S = {-1, 0, 1, 2, -1, -4};
        triplets(S);
    }



    public static void triplets(int[] S) {
        int[] arr = new int[S.length];

        System.arraycopy(S, 0, arr, 0, S.length);
        Arrays.sort(arr);

        List<Integer[]> list = new ArrayList<>();

        for(int i = 0; i < arr.length - 2; i++) {
            for(int j = i + 1; j < arr.length - 1; j++) {
                int index = binarySearch(arr, j, -(arr[i] + arr[j]));

                if(index > -1) {
                    Integer[] triplet = {arr[i], arr[j], arr[index]};
                    if(!contains(list, triplet)) {
                        list.add(triplet);
                    }
                }
            }
        }

        for(Integer[] triplet : list) {
            System.out.println(Arrays.toString(triplet));
        }
    }

    public static <T> boolean contains(List<T[]> list, T[] arr) {

        for(T[] triplet : list) {
            if(Arrays.equals(triplet, arr)) {
                return true;
            }
        }

        return false;
    }

    public static int binarySearch(int[] arr, int low, int key) {
        int high = arr.length - 1;

        while(low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid] == key) {
                return mid;
            }
            else if(arr[mid] < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
