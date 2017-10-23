
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

        int carry = 0;

        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while(i >= 0 || j >= 0) {
            int sum = carry;

            if(i >= 0) {
                sum += num1.charAt(i--) - '0';
            }
            if(j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            result.append(sum % 2);
            carry = sum / 2;
        }

        if(carry > 0) {
            result.append(carry);
        }
        
        return result.reverse().toString();

    }


}
