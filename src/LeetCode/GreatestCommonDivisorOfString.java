package LeetCode;

public class GreatestCommonDivisorOfString {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int length = calLength(str1.length(), str2.length());
        return str1.substring(0, length);
    }

    private int calLength(int a, int b) {
        return b == 0? a : calLength(b, a%b);
    }
}
