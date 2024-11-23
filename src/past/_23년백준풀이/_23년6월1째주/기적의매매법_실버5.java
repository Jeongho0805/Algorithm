package past._23년백준풀이._23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기적의매매법_실버5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int money = Integer.parseInt(br.readLine());
        int bnfMoney = money;
        int timingMoney = money;

        int[] bnfBuyList = new int[15];
        int[] timingBuyList = new int[15];
        int[] price = new int[15];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=14; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        int bnfProfit = calProfitForBnf(price, bnfMoney, bnfBuyList);
        int timingProfit = calProfitForTiming(price, timingMoney, timingBuyList);

        if (bnfProfit > timingProfit) {
            System.out.println("BNF");
        }
        else if (bnfProfit < timingProfit) {
            System.out.println("TIMING");
        }
        else {
            System.out.println("SAMESAME");
        }



    }

    private static int calProfitForTiming(int[] price, int timingMoney, int[] timingBuyList) {
        int total = 0;
        for (int i=4; i<14; i++) {
            if (price[i-1] > price[i-2] && price[i-2] > price[i-3] && timingMoney > price[i]) {
                timingBuyList[i] += timingMoney / price[i];
                timingMoney -= timingBuyList[i] * price[i];
            }
            if (price[i-1] < price[i-2] && price[i-2] < price[i-3]) {
                int endPrice = price[i];
                for (int j=1; j<i; j++) {
                    if (timingBuyList[j] != 0) {
                        timingMoney += (endPrice - price[j]) * timingBuyList[j];
                        timingBuyList[j] = 0;
                    }
                }
            }
        }
        int lastDayPrice = price[14];
        for (int i=1; i<14; i++) {
            if (timingBuyList[i] != 0) {
                total += (lastDayPrice - price[i]) * timingBuyList[i];
            }
        }
        return total + timingMoney;

    }

    private static int calProfitForBnf(int[] price, int bnfMoney, int[] bnfBuyList) {
        int total = 0;
        for (int i=1; i<14; i++) {
            if (bnfMoney / price[i]  != 0) {
                bnfBuyList[i] = bnfMoney / price[i];
                bnfMoney -= bnfBuyList[i] * price[i];
            }
        }
        int endPrice = price[14];
        for (int i=1; i<14; i++) {
            if (bnfBuyList[i] != 0) {
                total += (endPrice - price[i]) * bnfBuyList[i];
            }
        }
        return total + bnfMoney;
    }
}
