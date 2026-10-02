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
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondH = slow.next;
        slow.next = null;
        ListNode curr;

        if (fast == null) {
            ListNode temp = head;
            while (temp.next.next != null) {
                temp = temp.next;
            }
            temp.next = null;
            curr = head;
        }else{
            curr = head;
        }

        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        ListNode firsthalf = prev;
        ListNode secondHalf = secondH;

        while (firsthalf != null || secondHalf != null) {
            if (firsthalf == null || secondHalf == null) {
                return false;
            }

            if (firsthalf.val != secondHalf.val) {
                return false;
            }

            firsthalf = firsthalf.next;
            secondHalf = secondHalf.next;
        }

        return true;
    }
}