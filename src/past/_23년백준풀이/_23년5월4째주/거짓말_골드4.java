package past._23년백준풀이._23년5월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/1043
 * 다시 풀어보기 도저히 이해가 안되는 문제..
 */
public class 거짓말_골드4 {

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]);
        int m = Integer.parseInt(inputs[1]);

        boolean[] truthPeople = new boolean[n+1];

        HashSet<Integer>[] parties = new HashSet[m+1];
        for (int i = 1; i <= m; i++) {
            parties[i] = new HashSet<>();
        }

        inputs = br.readLine().split(" ");
        int know_num = Integer.parseInt(inputs[0]);

        for (int i = 1; i <= know_num; i++) {
            int idx = Integer.parseInt(inputs[i]);
            truthPeople[idx] = true;
        }

        parent = new int[n+1]; // parent 초기화
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= m; i++) { // party number

            inputs = br.readLine().split(" ");
            int number = Integer.parseInt(inputs[0]); // 파티에 오는 사람 수

            if(number<=1) {
                parties[i].add(Integer.parseInt(inputs[1]));
                continue;
            }

            for (int j = 1; j < number; j++) { // 연관 관계 이어줌
                int a = Integer.parseInt(inputs[j]);
                int b = Integer.parseInt(inputs[j+1]);
                if (find(a) != find(b)) {
                    union(a,b);
                }

                parties[i].add(a); // 파티에 참여하는 사람 저장
                parties[i].add(b);
            }
        }

        // 진실을 아는 사람과 연관 관계 있음 => people_know[i] T로 변경
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(truthPeople[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= n; j++){
                    if (find(j)==root) {
                        truthPeople[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }

        // 모든 파티 참석자가 F여야 과장된 얘기를 할 수 있음
        int result = 0;
        for (int i = 1; i <= m; i++) { // party
            boolean flag = false;
            for (int person : parties[i]) { // 참석자
                if(truthPeople[person]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        System.out.println(result);
    }

    public static int find(int idx) {
        if(parent[idx]==idx){
            return idx;
        }
        parent[idx] = find(parent[idx]);
        return parent[idx];
    }

    public static void union(int a, int b) {
        int parent_b = find(b);
        parent[parent_b] = a; // b의 parent를 a로 변경
    }
}
