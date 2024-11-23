package past._23년백준풀이._23년5월2째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2503
 */
public class 숫자야구_실버3 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Info> infos = new ArrayList<>();
        while (n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            infos.add(new Info(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        List<String> numbers = new ArrayList<>();
        root: for (int i=123; i<1000; i++) {
            String number = String.valueOf(i);
            if (number.contains("0")) {
                continue;
            }
            if (isDuplicate(number)) {
                continue;
            }
            for (Info info : infos) {
                if (info.isNotMatchedNumber(number)) {
                    continue root;
                }
            }
            numbers.add(number);
        }
        System.out.println(numbers.size());
    }

    private static boolean isDuplicate(String number) {
        for (int i=0; i<2; i++) {
            for (int j=i+1; j<3; j++) {
                if (number.charAt(i) == number.charAt(j)) {
                    return true;
                }
            }
        }
        return false;
    }
}
class Info {
    private String number;

    private int strike;

    private int ball;

    public Info(String number, int strike, int ball) {
        this.number = number;
        this.strike = strike;
        this.ball = ball;
    }

    public String getNumber() {
        return number;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isNotMatchedNumber(String number) {
        int strike = 0;
        int ball = 0;
        for (int i=0; i<3; i++) {
            if (this.number.charAt(i) == number.charAt(i)) {
                strike++;
            }
            if (this.number.contains(number.substring(i,i+1))) {
                ball++;
            }
        }
        ball -= strike;
        if (this.strike == strike && this.ball == ball) {
            return false;
        }
        return true;
    }
}
