package LeetCode;

/**
 * https://leetcode.com/problems/add-two-numbers/description/
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        StringBuilder sb = new StringBuilder();
        int prev = 0;

        while (true) {
            int cur = 0;
            if (l1 == null && l2 == null) {
                break;
            }
            if (l1 != null) {
                cur += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                cur += l2.val;
                l2 = l2.next;
            }

            cur += prev;
            sb.append(cur % 10);
            prev = cur / 10;
        }

        if (prev != 0) {
            sb.append(prev);
        }

        ListNode answer = new ListNode(sb.charAt(0) - '0');
        ListNode nextNode = answer;
        for (int i=1; i<sb.length(); i++) {
            int num = sb.charAt(i) - '0';
            nextNode.next = new ListNode(num);
            nextNode = nextNode.next;
        }
        return answer;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}


