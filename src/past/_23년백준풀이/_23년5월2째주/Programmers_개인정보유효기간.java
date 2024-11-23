package past._23년백준풀이._23년5월2째주;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/150370
 */
public class Programmers_개인정보유효기간 {
    public static final int MONTH = 28;
    HashMap<String, Integer> types = new HashMap<>();

    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> deleteList = new ArrayList<>();

        int todayNumber = dateToNumber(today);
        for (String term : terms) {
            String[] info = term.split(" ");
            types.put(info[0], Integer.parseInt(info[1]));
        }
        int[] privaciesNumbers = privaciesToNumberList(privacies);

        System.out.println("today = " + todayNumber);
        for (int i=0; i<privaciesNumbers.length; i++) {
            System.out.println(privaciesNumbers[i]);
            if (todayNumber >= privaciesNumbers[i]) {
                deleteList.add(i+1);
            }
        }


        int[] answer = new int[deleteList.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = deleteList.get(i);
        }
        return answer;
    }

    private int[] privaciesToNumberList(String[] privacies) {
        int[] privaciesNumbers = new int[privacies.length];
        for (int i=0; i<privacies.length; i++) {
            String privacy = privacies[i];
            privaciesNumbers[i] = privacyToNumber(privacy);
        }
        return privaciesNumbers;
    }

    private int privacyToNumber(String privacy) {
        String[] info = privacy.split(" ");
        int number = dateToNumber(info[0]);
        number += types.get(info[1]) * MONTH;
        return number;
    }

    private int dateToNumber(String today) {
        String[] date = today.split("\\.");
        int year = Integer.parseInt(date[0]) - 2000;
        int month = Integer.parseInt(date[1]);
        int day = Integer.parseInt(date[2]);

        return year * 336 + month * MONTH + day;
    }
}
