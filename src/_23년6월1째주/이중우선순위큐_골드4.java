package _23년6월1째주;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/7662
 */
public class 이중우선순위큐_골드4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            HashMap<Integer, Integer> maxDeleteMap = new HashMap<>();
            HashMap<Integer, Integer> minDeleteMap = new HashMap<>();
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            while (n-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int number = Integer.parseInt(st.nextToken());
                if (order.equals("I")) {
                    maxQueue.add(number);
                    minQueue.add(number);
                    continue;
                }
                if (number == -1) {
                    while (!minQueue.isEmpty()) {
                        int poll = minQueue.poll();
                        if (minDeleteMap.containsKey(poll) && minDeleteMap.get(poll) > 0) {
                            minDeleteMap.put(poll, minDeleteMap.get(poll) -1);
                            continue;
                        }
                        maxDeleteMap.put(poll, maxDeleteMap.getOrDefault(poll, 0) +1);
                        break;
                    }
                }
                if (number == 1) {
                    while (!maxQueue.isEmpty()) {
                        int poll = maxQueue.poll();
                        if (maxDeleteMap.containsKey(poll) && maxDeleteMap.get(poll) > 0) {
                            maxDeleteMap.put(poll, maxDeleteMap.get(poll) -1);
                            continue;
                        }
                        minDeleteMap.put(poll, minDeleteMap.getOrDefault(poll, 0) + 1);
                        break;
                    }
                }
            }
            int min = 0;
            int max = 0;
            boolean isMin = false;
            boolean isMax = false;
            while (!minQueue.isEmpty()) {
                int poll = minQueue.poll();
                if (minDeleteMap.containsKey(poll) && minDeleteMap.get(poll) > 0) {
                    minDeleteMap.put(poll, minDeleteMap.get(poll) -1);
                    continue;
                }
                min = poll;
                isMin = true;
                break;
            }
            while (!maxQueue.isEmpty()) {
                int poll = maxQueue.poll();
                if (maxDeleteMap.containsKey(poll) && maxDeleteMap.get(poll) > 0) {
                    maxDeleteMap.put(poll, maxDeleteMap.get(poll) -1);
                    continue;
                }
                max = poll;
                isMax = true;
                break;
            }
            if (isMax && isMin) {
                System.out.println(max + " " + min);
            } else {
                System.out.println("EMPTY");
            }
        }
    }
}
