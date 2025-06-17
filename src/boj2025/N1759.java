package boj2025;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class N1759 {

    static int l;
    static int c;
    static String[] alpha;

    private static final List<String> moem = List.of("a", "e", "i", "o", "u");

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        alpha = new String[c];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            alpha[i] = st.nextToken();
        }
        Arrays.sort(alpha);
        StringBuilder sb = new StringBuilder();
        dfs(0, 0, new StringBuilder(), sb);
        System.out.print(sb);
    }

    public static void dfs(int idx, int depth, StringBuilder temp, StringBuilder output) {
        if (depth == l) {
            String result = temp.toString();
            int moCnt = 0;
            for (String m : moem) {
                if (result.contains(m)) {
                    moCnt++;
                }
            }
            int zaCnt = result.length() - moCnt;
            if (zaCnt >= 2 && moCnt >= 1) {
                output.append(result).append("\n");
            }
            return;
        }
        for (int i=idx; i< alpha.length; i++) {
            temp.append(alpha[i]);
            dfs(i+1, depth + 1, temp, output);
            temp.deleteCharAt(temp.length() -1 );
        }
    }
}
