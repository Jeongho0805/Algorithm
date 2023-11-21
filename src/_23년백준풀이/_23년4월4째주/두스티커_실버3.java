package _23년백준풀이._23년4월4째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 링크 - https://www.acmicpc.net/problem/16937
 */
public class 두스티커_실버3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(br.readLine());
        List<Sticker> stickers = new ArrayList<>();
        while(n-- > 0) {
            st = new StringTokenizer(br.readLine());
            stickers.add(new Sticker(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(stickers, (o1, o2) -> o2.getS() - o1.getS()); // 넓이순 정렬

        int maxArea = 0;
        for (int i=0; i<stickers.size()-1; i++) {
            for (int j=i+1; j<stickers.size(); j++) {
                if (isPossible(stickers.get(i), stickers.get(j), h, w)) {
                    maxArea = Math.max(maxArea, stickers.get(i).getS() + stickers.get(j).getS());
                }
            }
        }
        System.out.println(maxArea);
    }

    public static boolean isPossible(Sticker t1, Sticker t2, int maxH, int maxW) {
        int[][] extraLengthInfo = t1.getExtraLength(maxH, maxW);
        int[][] extraLengthRotateInfo = t1.getExtraLengthRotate(maxH, maxW);
        if (t2.isFitInMaxArea(extraLengthInfo)) {
            return true;
        }
        if (t2.isFitInMaxArea(extraLengthRotateInfo)) {
            return true;
        }
        return false;
    }
}

class Sticker {
    private int h;
    private int w;
    private int s;


    public Sticker(int h, int w) {
        this.h = h;
        this.w = w;
        this.s = h * w;
    }

    public int getS() {
        return s;
    }

    public int[][] getExtraLength(int maxH, int maxW) {
        int[][] result = new int[2][2];
        result[0][0] = maxH - this.h;
        result[0][1] = maxW;
        result[1][0] = maxW - this.w;
        result[1][1] = maxH;
        return result;
    }

    public int[][] getExtraLengthRotate(int maxH, int maxW) {
        int[][] result = new int[2][2];
        result[0][0] = maxH - this.w;
        result[0][1] = maxW;
        result[1][0] = maxW - this.h;
        result[1][1] = maxH;
        return result;
    }

    public boolean isFitInMaxArea(int[][] extraLengthInfo) {
        if (extraLengthInfo[0][0] < 0 || extraLengthInfo[1][0] < 0) { // 하나라도 minus이면 성립 x
            return false;
        }
        if (extraLengthInfo[0][0] >=h && extraLengthInfo[0][1] >= w) {
            return true;
        }
        if (extraLengthInfo[0][0] >=w && extraLengthInfo[0][1] >= h) {
            return true;
        }
        if (extraLengthInfo[1][0] >= h && extraLengthInfo[1][1] >= w) {
            return true;
        }
        if (extraLengthInfo[1][0] >= w && extraLengthInfo[1][1] >= h) {
            return true;
        }
        return false;
    }
}
