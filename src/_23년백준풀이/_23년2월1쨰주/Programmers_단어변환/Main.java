package _23년백준풀이._23년2월1쨰주.Programmers_단어변환;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/43163
 * 풀이 날짜 : 2023-02-04
 */
public class Main {
    public static void main(String[] args) {

        Solution s = new Solution();
        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        int result = s.solution(begin, target, words);
        System.out.println(result);
    }
}

class Solution {

    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        if (answer == Integer.MAX_VALUE) {
            return 0;
        }
        return answer;
    }

    private void dfs(String cur, String target, String[] words, boolean[] visited, int count) {
        if (cur.equals(target)) {
            answer = Math.min(count, answer);
            return;
        }

        for (int i=0; i<words.length; i++) {
            if (isNextWord(cur, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(words[i], target, words, visited, count+1);
                visited[i] = false;
            }
        }
    }

    private boolean isNextWord(String word1, String word2) {
        int count = 0;
        for (int i=0; i<word1.length(); i++) {
            if (word1.charAt(i) == word2.charAt(i)) {
                count++;
            }
        }
        if (count == word1.length()-1) {
            return true;
        }
        return false;
    }
}