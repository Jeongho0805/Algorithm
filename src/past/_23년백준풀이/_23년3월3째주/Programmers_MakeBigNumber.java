package past._23년백준풀이._23년3월3째주;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/42883?language=java
 *
 */
public class Programmers_MakeBigNumber {
    public String solution(String number, int k) {

        StringBuilder answer = new StringBuilder();
        int extraSpace = number.length() - k;
        char[] numbers = number.toCharArray();

        for (int i=0; i<numbers.length; i++) {
            if (extraSpace == 0) {
                break;
            }
            int maxValue = 0;
            for (int j=i; j<= numbers.length - extraSpace; j++) {
                if (maxValue < numbers[j] - '0') {
                    maxValue = numbers[j] - '0';
                    i = j;
                }
            }
            answer.append(maxValue);
            extraSpace--;
        }
        return answer.toString();
    }
}
