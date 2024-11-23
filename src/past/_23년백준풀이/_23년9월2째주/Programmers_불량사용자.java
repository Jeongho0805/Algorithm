package past._23년백준풀이._23년9월2째주;

import java.util.HashSet;

public class Programmers_불량사용자 {
    static HashSet<HashSet<String>> set = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        dfs(0, new HashSet<>(), user_id, banned_id);
        return set.size();
    }

    public void dfs (int depth, HashSet<String> temp, String[] userId, String[] bannedId) {

        if (depth == bannedId.length) {
            set.add(new HashSet<>(temp));
            return;
        }

        for (int i=0; i<userId.length; i++) {
            if (temp.contains(userId[i]))  {
                continue;
            }
            if (isMatched(userId[i], bannedId[depth])) {
                temp.add(userId[i]);
                dfs(depth + 1, temp, userId, bannedId);
                temp.remove(userId[i]);
            }
        }
    }

    public boolean isMatched(String temp1, String temp2) {
        if (temp1.length() != temp2.length()) {
            return false;
        }
        for (int i=0; i<temp1.length(); i++) {
            if (temp2.charAt(i) != '*' && temp1.charAt(i) != temp2.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
