package past._23년백준풀이._23년9월2째주;

public class Programmers_점프와순간이동 {
    public int solution(int n) {

        int target = n;
        int answer = 0;
        while (target != 0) {
            if (target % 2 != 0) {
                target--;
                answer++;
                continue;
            }
            target /= 2;
        }
        return answer;
    }
}
