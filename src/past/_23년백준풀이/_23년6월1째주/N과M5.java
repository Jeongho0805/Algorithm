package past._23년백준풀이._23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/15654
 */
public class N과M5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] numbers = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<numbers.length; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(m, numbers));
    }

    public static String solution(int pick, int[] numbers) {

        StringBuilder answer = new StringBuilder();
        Arrays.sort(numbers);

        boolean[] visited = new boolean[numbers.length];
        List<Integer> temp = new ArrayList<>();
        for (int i=0; i<numbers.length; i++) {
            visited[i] = true;
            temp.add(numbers[i]);
            dfs(numbers, visited, answer, temp, pick);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
        return answer.toString();
    }

    private static void dfs(int[] numbers, boolean[] visited, StringBuilder answer, List<Integer> temp, int size) {
        if (temp.size() == size) {
            for (Integer num : temp) {
                answer.append(num +" ");
            }
            answer.append("\n");
        }
        for (int i=0; i<numbers.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            temp.add(numbers[i]);
            dfs(numbers, visited, answer, temp, size);
            temp.remove(temp.size()-1);
            visited[i] = false;
        }
    }
}
