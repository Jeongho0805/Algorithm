package LeetCode;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length = Math.max(word1.length(), word2.length());
        for (int i=0; i<length; i++) {
            if (word1.length() > i) {
                sb.append(word1.charAt(i));
            }
            if (word2.length() > i) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
