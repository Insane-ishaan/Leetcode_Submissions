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
    public ListNode partition(ListNode head, int X) {
        if (head == null || head.next == null)
            return head;
        ListNode curr = head;
        ListNode smallLs = new ListNode(-1);
        ListNode sCurr = smallLs;

        while (curr != null) {
            if (curr.val < X) {
                sCurr.next = new ListNode(curr.val);
                sCurr = sCurr.next;
            }

            curr = curr.next;
        }

        curr = head;
        ListNode largeLs = new ListNode(-1);
        ListNode lCurr = largeLs;

        while (curr != null) {
            if (curr.val > X) {
                lCurr.next = new ListNode(curr.val);
                lCurr = lCurr.next;
            } else if (curr.val == X) {
                lCurr.next = new ListNode(curr.val);
                lCurr = lCurr.next;
            }
            curr = curr.next;
        }

        sCurr.next = largeLs.next;
        return smallLs.next;
    }
}