package _23년백준풀이._23년9월2째주;

class Programmers_피보나치수 {
    public int solution(int n) {
        int[] dp = new int[100001];
        dp[0] = 0;
        dp[1] = 1;
        for (int i=2; i<=100000; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        return dp[n];
    }
}
