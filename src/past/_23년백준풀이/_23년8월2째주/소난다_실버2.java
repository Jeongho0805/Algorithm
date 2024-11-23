package past._23년백준풀이._23년8월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 소난다_실버2 {

    static List<Integer> sumList = new ArrayList<>();
    static List<Integer> primeList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] cows = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            cows[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] visited = new boolean[10001];
        for (int i=2; i<=10000; i++) {
            for (int j=1; j<visited.length/i; j++) {
                if (i == i*j && !visited[i]) {
                    primeList.add(i);
                    continue;
                }
                visited[i*j] = true;
            }
        }
        makeSumList(cows, m, new ArrayList<>(), 0);
        if (sumList.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(sumList);
            StringBuilder sb = new StringBuilder();
            sumList.forEach(sum -> sb.append(sum + " "));
            sb.delete(sb.length()-1, sb.length());
            System.out.println(sb);
        }
    }

    private static void makeSumList(int[] cows, int m, ArrayList<Integer> temp, int start) {
        if (temp.size() == m) {
            int sum = temp.stream().mapToInt(Integer::intValue).sum();
            if (primeList.contains(sum) && !sumList.contains(sum)) {
                sumList.add(sum);
            }
            return;
        }

        for (int i=start; i<cows.length; i++) {
            temp.add(cows[i]);
            makeSumList(cows, m, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
}
