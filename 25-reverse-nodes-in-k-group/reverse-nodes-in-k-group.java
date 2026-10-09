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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode curr = head;
        int size = 0;
        while (size < k) {
            if (curr == null) {
                return head;
            }

            size++;
            curr = curr.next;
        }

        ListNode next;
        curr = head;
        size = 0;
        ListNode prev = null;
        while (curr != null && size < k) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            size++;
        }

        head.next = reverseKGroup(curr, k);
        return prev;
    }
}