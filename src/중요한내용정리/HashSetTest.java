package 중요한내용정리;

import java.util.*;
public class HashSetTest {
    public static void main(String[] args) {
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        String[] temp = {"가", "나", "다"};

        for (int i=0; i<3; i++) {
            set1.add(temp[i]);
            set2.add(temp[i]);
        }
        System.out.println(set1 == set2);
        System.out.println(set1.equals(set2));

        StringBuilder sb = new StringBuilder();

    }
}
