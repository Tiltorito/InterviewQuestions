
// Given two binary strings, return their sum (also a binary string).

// For example,
// a = "11"
// b = "1"
// Return "100"

public class Solution {
    public static void main(String[] args) {
        System.out.println(addBinaryStrings("110","1"));
    }



    public static String addBinaryStrings(String num1, String num2) {
        return dec2Base(base2Dec(num1, 2) + base2Dec(num2, 2), 2);
    }

    /**
     * Converts a decimal number to any base
     * @param number the decimal number to be converted in the base
     * @param base the base which the decimal number will be converted to
     * @return the number in base as string
     */
    public static String dec2Base(int number, int base) {
        StringBuilder baseString = new StringBuilder(8);

        while(number > 0) {
            int rem = number % base;

            if(rem > 9) {
                baseString.append(valueOf(rem));
            }
            else {
                baseString.append(rem);
            }

            number /= base;
        }

        return baseString.reverse().toString();
    }

    /**
     * Converts a number from anyBase into decimal
     * @param str the number to be converted in decimal
     * @param base the base which the number is
     * @return the decimal represantation of the number
     */
    public static int base2Dec(String str, int base) {
        int result = valueOf(str.charAt(0));

        for(int i = 1; i < str.length(); i++) {
            result = result * base + valueOf(str.charAt(i));
        }

        return result;
    }

    /**
     * Returns the value of a digit if it's as char
     * @param ch the digit
     * @return decimal represantation of the digit
     */
    public static int valueOf(char ch) {
        if(Character.isDigit(ch)) {
            return ch - '0';
        }

        return Character.toLowerCase(ch) - 'a' + 10;
    }

    /**
     * Returns the char representation of a number as char
     * @param num the number to be converted into char
     * @return the char which correspond to this digit
     */
    public static char valueOf(int num) {
        return (char)(num > 9 ? (num + 'A' - 10) : num + '0');
    }
}
