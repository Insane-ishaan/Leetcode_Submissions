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
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private ListNode getRev(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public void reorderList(ListNode head) {
        ListNode mid = getMid(head);
        ListNode revPart = getRev(mid);
        mid.next = null;

        ListNode first = head;
        ListNode second = revPart;

        while (first != null && second != null) {
            ListNode newFirst = first.next;
            ListNode newSecond = second.next;

            first.next = second;
            second.next = newFirst;

            first = newFirst;
            second = newSecond;
        }
    }
}
