package reversingString;

/**
 Write a function:

 class Solution { public int solution(String S); }

 that, given a string S, returns the index (counting from 0) of a character such that the part of the string to the left of that character is a reversal of the part of the string to its right. The function should return −1 if no such index exists.

 Note: reversing an empty string (i.e. a string whose length is zero) gives an empty string.

 For example, given a string:

 "racecar"

 the function should return 3, because the substring to the left of the character "e" at index 3 is "rac", and the one to the right is "car".

 Given a string:

 "x"

 the function should return 0, because both substrings are empty.
 */

public class ReversingString {

    private ReversingString() {

    }

    public static int solution1(String S) {
        if (S == null || S.length() == 1) {
            return -1;
        }
        if (S.length() % 2 != 0) {
            int index = S.length() / 2;
            String s1 = S.substring(0, index);
            String s2 = S.substring(index + 1, S.length());
            String reverse = new StringBuilder(s1).reverse().toString();
            if (reverse.equals(s2)) {
                return index;
            }
        }
        return -1;
    }
}
