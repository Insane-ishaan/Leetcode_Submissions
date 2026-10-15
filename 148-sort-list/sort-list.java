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

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                temp = temp.next;
                left = left.next;
            } else {
                temp.next = right;
                temp = temp.next;
                right = right.next;
            }
        }

        if (left != null) {
            temp.next = left;
        } else if (right != null) {
            temp.next = right;
        }

        return dummyNode.next;
    }

    private ListNode sortListHelper(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        ListNode l = sortListHelper(left);
        ListNode r = sortListHelper(right);

        return merge(l, r);
    }

    public ListNode sortList(ListNode head) {
        return sortListHelper(head);
    }
}