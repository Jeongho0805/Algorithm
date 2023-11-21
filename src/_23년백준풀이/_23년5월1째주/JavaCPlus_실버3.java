package _23년백준풀이._23년5월1째주;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://www.acmicpc.net/problem/3613
 */
public class JavaCPlus_실버3 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] temp = input.split("");
        List<String> words = Arrays.stream(temp).collect(Collectors.toList());

        if (!words.contains("_")) {
            boolean flag = true;
            for (int i=0; i<words.size(); i++) {
                if (words.get(i).toUpperCase().equals(words.get(i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                System.out.println(input);
                System.exit(0);
            }
        }

        if (words.contains("_")) {
            boolean flag = true;
            String prevWord = "";
            for (int i=0; i<words.size(); i++) {
                if ((i == 0 && words.get(i).equals("_")) || (i == words.size()-1 && words.get(i).equals("_"))) {
                    System.out.println("Error!");
                    flag = false;
                    break;
                }

                if (words.get(i).equals("_")) {
                    if (prevWord.equals(words.get(i))) {
                        System.out.println("Error!");
                        flag = false;
                        break;
                    } else {
                        prevWord = "_";
                        continue;
                    }
                }
                String upperCase = words.get(i).toUpperCase();
                if (upperCase.equals(words.get(i))) {
                    System.out.println("Error!");
                    flag = false;
                    break;
                }
                prevWord = words.get(i);
            }
            if (flag) {
                toJava(input);
            }
        } else {
            boolean flag = false;
            for (int i=0; i<words.size(); i++) {

                if (words.get(i).toUpperCase().equals(words.get(i))) {
                    if (i == 0) {
                        break;
                    }
                    flag = true;
                    toCplus(words);
                    break;
                }
            }
            if (!flag) {
                System.out.println("Error!");
            }

        }
    }

    private static void toCplus(List<String> words) {
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (word.equals(word.toUpperCase())) {
                result.append("_")
                        .append(word.toLowerCase());
            } else {
                result.append(word);
            }
        }
        System.out.println(result);
    }

    private static void toJava(String input) {
        StringTokenizer st = new StringTokenizer(input, "_");
        StringBuilder result = new StringBuilder();
        result.append(st.nextToken());

        while(st.hasMoreTokens()) {
            String word = st.nextToken();
            String[] temp = word.split("");
            for (int i=0; i<temp.length; i++) {
                if (i == 0) {
                    result.append(temp[i].toUpperCase());
                } else {
                    result.append(temp[i]);
                }
            }
        }
        System.out.println(result);
    }
}
