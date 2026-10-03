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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while (curr != null && curr.next != null) {
            ListNode next = curr.next;
            prev.next = curr.next;
            curr.next = curr.next.next;
            next.next = curr;

            prev = curr;
            curr = curr.next;
        }


        return dummy.next;
    }
}