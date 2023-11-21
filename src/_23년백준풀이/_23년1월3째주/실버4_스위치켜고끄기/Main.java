package _23년백준풀이._23년1월3째주.실버4_스위치켜고끄기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/1244
 * 풀이 날짜 : 2023-01-21
 * 마지막에 20개 출력 때문에 틀린 문제 if에서 continue를 하면 어떡하냐,,,
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] switches = new int[n+1];
        switches[0] = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=n; i++) {
            int state = Integer.parseInt(st.nextToken());
            if (state == 0) {
                switches[i] = -1;
                continue;
            }
            switches[i] = 1;
        }

        int studentCount = Integer.parseInt(br.readLine());
        while (studentCount-- > 0 ) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int no = Integer.parseInt(st.nextToken());
            if (gender == 1) {
                changeSwitchesForMan(no, switches);
                continue;
            }
            changeSwitchesForWoman(no, switches);
        }

        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i=1; i<=n; i++) {
            if (count > 20) {
                count = 1;
                sb.delete(sb.length()-1, sb.length());
                sb.append("\n");
            }
            int value = switches[i];
            if (value == -1) {
                sb.append(0 + " ");
            } else {
                sb.append(value + " ");
            }
            count++;
        }
        System.out.println(sb);
    }

    private static void changeSwitchesForWoman(int no, int[] switches) {
        switches[no] *= -1;
        int left = no - 1;
        int right = no + 1;
        while (true) {
            if (left < 1 || right > switches.length - 1) {
                break;
            }
            if (switches[left] != switches[right]) {
                break;
            }
            switches[left] *= -1;
            switches[right] *= -1;
            left -= 1;
            right += 1;
        }
    }

    private static void changeSwitchesForMan(int no, int[] switches) {
        int index = no;
        while (index < switches.length) {
            switches[index] *= -1;
            index += no;
        }
    }
}
