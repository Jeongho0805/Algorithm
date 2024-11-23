package past._23년백준풀이._23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/18870
 */
public class 좌표압축_실버2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        HashSet<Integer> set = new HashSet<>(numbers);
        List<Integer> copys = new ArrayList<>(set);
        Collections.sort(copys);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<copys.size(); i++) {
            map.put(copys.get(i), Math.min(map.getOrDefault(copys.get(i), i), i));
        }
        StringBuilder answer = new StringBuilder();
        for (Integer number : numbers) {
            answer.append(map.get(number)).append(" ");
        }
        System.out.println(answer);
    }
}
