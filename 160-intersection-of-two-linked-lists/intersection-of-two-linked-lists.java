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

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int len1 = getLen(headA);
        int len2 = getLen(headB);
        int skips;
        ListNode curr1;
        ListNode curr2;
        if (len1 > len2) {
            skips = len1 - len2;
            curr1 = headA;
            len2 = 0;
            while (len2 != skips) {
                len2 += 1;
                curr1 = curr1.next;
            }

            curr2 = headB;
            while (curr1 != null && curr2 != null) {
                if (curr1 == curr2) {
                    return curr1;
                }

                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        } else if (len2 > len1) {
            skips = len2 - len1;
            len1 = 0;
            curr2 = headB;
            while (len1 != skips) {
                len1 += 1;
                curr2 = curr2.next;
            }

            curr1 = headA;
            while (curr1 != null && curr2 != null) {
                if (curr1 == curr2) {
                    return curr1;
                }

                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        } else {
            curr1 = headA;
            curr2 = headB;

            while (curr1 != null && curr2 != null) {
                if (curr1 == curr2) {
                    return curr1;
                }

                curr1 = curr1.next;
                curr2 = curr2.next;
            }
        }

        return null;
    }
}