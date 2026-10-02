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
    private int getLen(ListNode head) {
        int len = 0;
        ListNode curr = head;

        while (curr != null) {
            len += 1;
            curr = curr.next;
        }

        return len;
    }

    ListNode prevSwapNodeOne = null;

    private ListNode getGetSwapNodeOne(ListNode head, int k) {
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (count == k) {
                break;
            }
            count += 1;
            prevSwapNodeOne = curr;
            curr = curr.next;
        }

        return curr;
    }

    private ListNode getGetSwapNodeTwo(ListNode head, int k) {
        ListNode curr = head;
        int count = 1;
        while (curr != null) {
            if (count == k) {
                break;
            }
            count += 1;
            curr = curr.next;
        }

        return curr;
    }

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        int len = getLen(head);
        ListNode getSwapOne = getGetSwapNodeOne(head, k);
        ListNode getSwapTwo = getGetSwapNodeTwo(head, len - k + 1);

        int node1 = getSwapOne.val;
        int node2 = getSwapTwo.val;

        getSwapOne.val = node2; 
        getSwapTwo.val = node1; 
        return head;
    }
}