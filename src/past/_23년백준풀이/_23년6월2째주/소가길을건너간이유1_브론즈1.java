package past._23년백준풀이._23년6월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/14467
 */
public class 소가길을건너간이유1_브론즈1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cows = new int[11];
        HashMap<Integer, Integer> positions = new HashMap<>();
        while (n-- > 0 ) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cow = Integer.parseInt(st.nextToken());
            int pos = Integer.parseInt(st.nextToken());
            if (positions.containsKey(cow)) {
                if (positions.get(cow) == pos) {
                    continue;
                }
                cows[cow]++;
                positions.put(cow, pos);
            } else {
                positions.put(cow, pos);
            }
        }
        System.out.println(Arrays.stream(cows).sum());
    }
}
