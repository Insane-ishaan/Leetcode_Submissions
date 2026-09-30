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
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return head;
        if (head.next == null && n == 1)
            return null;

        ListNode rev = reverse(head);
        if (1 == n) {
            ListNode recover = reverse(rev.next);
            return recover;
        }
        ListNode temp = rev;
        ListNode curr = rev.next;
        ListNode prev = rev;
        int count = 2;
        while (curr != null) {
            if (count == n) {
                prev.next = curr.next;
                break;
            }

            count += 1;
            prev = curr;
            curr = curr.next;
        }

        ListNode recover = reverse(rev);
        return recover;
    }
}