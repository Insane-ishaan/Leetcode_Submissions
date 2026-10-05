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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }

        int effectiveRotation = k % len;
        if (effectiveRotation == 0) {
            return head;
        }

        int cutPoint = len - effectiveRotation;
        len = 1;
        curr = head;
        while (len != cutPoint) {
            len++;
            curr = curr.next;
        }

        ListNode newH = curr.next;
        ListNode newHcurr = newH;
        curr.next = null;

        while(newHcurr.next != null){
            newHcurr = newHcurr.next;
        }

        newHcurr.next = head;
        return newH;
    }
}