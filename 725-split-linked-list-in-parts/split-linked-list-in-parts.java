/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private int getLen(ListNode head) {
        int len = 0;

        while (head != null) {
            len++;
            head = head.next;
        }

        return len;
    }

    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = getLen(head);

        int part = len / k;
        int extraEl = len % k;

        ListNode[] result = new ListNode[k];

        for (int i = 0; i < k; i++) {
            result[i] = head;
            ListNode prev = null;
            ListNode temp = head;
            if (temp == null) {
                continue;
            }
            int count = part;

            while (count > 0) {
                prev = temp;
                temp = temp.next;
                count--;
            }

            if (extraEl > 0) {
                prev = temp;
                temp = temp.next;
                extraEl--;
            }

            if(prev != null){
                head = temp;
                prev.next = null;
            }
        }

        return result;
    }
}