
// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100"

public class Solution {
    public static void main(String[] args) {
        System.out.println(addBinaryStrings("1111","1101"));
    }



    public static String addBinaryStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder(8);

        String min = new StringBuilder((num1.length() > num2.length() ? num2 : num1)).reverse().toString();
        String max = new StringBuilder((num1.length() > num2.length() ? num1 : num2)).reverse().toString();

        int i;
        boolean hasCarry = false;

        for(i = 0; i < min.length(); i++) {
            int d1 = min.charAt(i) - '0';
            int d2 = max.charAt(i) - '0';

            int res = d1 + d2;

            if(hasCarry) {
                res++;
                hasCarry = false;
            }

            if(res > 1) {
                hasCarry = true;
                res -= 2;
            }

            result.append(res);
        }

        for(; i < max.length(); i++) {
            int digit = max.charAt(i) - '0';
            int res = digit;

            if(hasCarry) {
                res++;
                hasCarry = false;
            }

            if(res == 2) {
                hasCarry = true;
                res = 0;
            }

            result.append(res);
        }

        if(hasCarry) {
            result.append(1);
        }

        return result.reverse().toString();
    }

}
