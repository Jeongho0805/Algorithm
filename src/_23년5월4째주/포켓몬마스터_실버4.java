package _23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1620
 */
public class 포켓몬마스터_실버4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> wordsMap = new HashMap<>();
        HashMap<Integer, String> idxMap  = new HashMap<>();
        for (int i=1; i<=n; i++) {
            String word = br.readLine();
            wordsMap.put(word, i);
            idxMap.put(i, word);
        }
        for (int i=0; i<m; i++) {
            String problem = br.readLine();
            try {
                int idx = Integer.parseInt(problem);
                System.out.println(idxMap.get(idx));
            } catch (NumberFormatException e) {
                System.out.println(wordsMap.get(problem));
            }
        }
    }
}
