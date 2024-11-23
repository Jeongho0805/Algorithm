package past.풀문제들;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Cubeditor_골드3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();

        String answer = "";
        HashSet<String> set = new HashSet<>();
        root : for (int i=word.length()-1; i>0; i--) {
            for (int j=0; j<word.length()-i; j++) {
                String token = word.substring(j, j+i+1);
                if (set.contains(token)) {
                    answer = token;
                    break root;
                }
                set.add(token);
            }
            set.clear();
        }
        System.out.println(answer.length());
    }
}
