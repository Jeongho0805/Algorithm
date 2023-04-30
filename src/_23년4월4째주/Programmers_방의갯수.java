package _23년4월4째주;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * 링크 - https://school.programmers.co.kr/learn/courses/30/lessons/49190
 */
public class Programmers_방의갯수 {

    public static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    public static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        /* 해당 노드와 해당 노드 이전의 노드 리스트 */
        HashMap<Node, List<Node>> map = new HashMap<>();

        Node curNode = new Node(0, 0);
        map.put(curNode, new ArrayList<>());

        int answer = 0;

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) { // 스케일업
                int nextX = curNode.x + dx[arrow];
                int nextY = curNode.y + dy[arrow];
                Node nextNode = new Node(nextX, nextY);

                // 해당 정점을 방문한 적이 있는 경우
                if (map.containsKey(nextNode)) {
                    List<Node> nodes = map.get(nextNode); // 해당 노드를 방문하기 이전 노드 리스트
                    if (!nodes.contains(curNode)) { // 새로운 간선
                        nodes.add(curNode);
                        map.get(curNode).add(nextNode);
                        answer++; // 방 갯수 1 증가
                    }
                }
                // 해당 정점을 방문학 적이 없는 경우
                else {
                    List<Node> edges = new ArrayList<>();
                    edges.add(curNode);
                    map.put(nextNode, edges);
                    map.get(curNode).add(nextNode);
                }
                curNode = nextNode;
            }
        }
        return answer;
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }

        @Override
        public boolean equals(Object obj) {
            Node node = (Node) obj;
            if (node.x == this.x && node.y == this.y) {
                return true;
            }
            return false;
        }
    }
}



class Main {
    public static void main(String[] args) {
        Programmers_방의갯수 problem = new Programmers_방의갯수();
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        int result = problem.solution(arrows);
        System.out.println(result);
    }
}
