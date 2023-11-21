package _23년백준풀이._23년3월3째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 풀이 링크 - https://www.acmicpc.net/problem/2564
 */
public class 경비원_실버1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine()) + 1;
        List<Position> positions = new ArrayList<>();

        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken());

            if (direction == 1) {
                positions.add(new Position(Integer.parseInt(st.nextToken()), height, 0, direction));
            }
            else if (direction == 2) {
                positions.add(new Position(Integer.parseInt(st.nextToken()), 0, 0, direction));
            }
            else if (direction == 3) {
                positions.add(new Position(0, height - Integer.parseInt(st.nextToken()), 1, direction));
            } else {
                positions.add(new Position(width, height - Integer.parseInt(st.nextToken()), 1, direction));
            }
        }

        int answer = 0;
        for (int i=0; i<positions.size()-1; i++) {
            Position target = positions.get(positions.size()-1);
            Position temp = positions.get(i);

            if (target.getType() == temp.getType()) {
                if (target.getDirection() == temp.getDirection()) {
                    answer += Math.abs(target.getX() - temp.getX()) + Math.abs(target.getY() - temp.getY());
                } else {
                    if (target.getType() == 0) {
                        int option1 = target.getX() + temp.getX();
                        int option2 = width - target.getX() + width - temp.getX();
                        answer += height + Math.min(option1, option2);
                    } else {
                        int option1 = target.getY() + temp.getY();
                        int option2 = height - target.getY() + height - temp.getY();
                        answer += width + Math.min(option1, option2);
                    }
                }
            }
            else {
                answer += Math.abs(target.getX() - temp.getX()) + Math.abs(target.getY() - temp.getY());
            }
        }
        System.out.println(answer);
    }
}

class Position {
    private int x;
    private int y;

    private int type;

    private int direction; // 0이면 north south, 1이면 east west

    public Position(int x, int y, int type, int direction) {
        this.x = x;
        this.y = y;
        this.type = type;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }

    public int getType() {
        return type;
    }
}
