/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    private int getLen(ListNode head) {
        ListNode curr = head;
        int len = 0;
        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        return len;
    }

    private ListNode getCollision(ListNode head, ListNode curr, int skips) {
        ListNode curr2 = head;

        int len = 0;
        while (len != skips) {
            len += 1;
            curr = curr.next;
        }

        while (curr != null && curr2 != null) {
            if (curr == curr2) {
                return curr;
            }

            curr = curr.next;
            curr2 = curr2.next;
        }

        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1 = getLen(headA);
        int len2 = getLen(headB);
        int skips;
        ListNode curr1;
        ListNode curr2;
        if (len1 > len2) {
            return getCollision(headB, headA, len1 - len2);
        } else if (len2 > len1) {
            return getCollision(headA, headB, len2 - len1);
        } else {
            return getCollision(headA, headB, 0);
        }
    }
}