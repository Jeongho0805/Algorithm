
package _23년9월2째주;

import java.util.*;

class Programmers_JadenCase {
    public String solution(String input) {
        StringBuilder sb = new StringBuilder();

        boolean isPrevEmpty = true;
        String[] word = input.split("");
        for (int i=0; i<word.length; i++) {
            if (word[i].equals(" ")) {
                sb.append(" ");
                isPrevEmpty = true;
            } else {
                if (isPrevEmpty) {
                    sb.append(word[i].substring(0, 1).toUpperCase());
                    isPrevEmpty = false;
                } else {
                    sb.append(word[i].substring(0, 1).toLowerCase());
                }
            }
        }



        return sb.toString();
    }
}