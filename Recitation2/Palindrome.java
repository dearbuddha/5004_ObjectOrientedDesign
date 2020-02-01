package Recitation2;

public class Palindrome {

    static boolean isPalindrome(String s){
        // index first and last character
        int first = 0;
        int last = s.length() - 1;
        // for each iteration
        while (first < last) {
            // compare first and last character
            if (s.charAt(first) != s.charAt(last)) {
                // false if not same
                return false;
            }
            // increment first, decrement last
            first = first + 1;
            last = last - 1;
            // true
        }
        return true;
    }

    static String makePalindrome(String s){
        // create reverse string
        String r = Palindrome.reverseString(s);
        // concatenate string and reverse string
        String pal = s + r;
        // return palindrome string
        return "";
    }

    static String reverseString(String s){
        String rev = "";
        for (int i = 0; i < s.length(); i++){
            rev = s.charAt(i) + rev;
        }
        return rev;
    }

    public static void main(String[] args) {

    }
}
