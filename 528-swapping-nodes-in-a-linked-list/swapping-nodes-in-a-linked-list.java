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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        while(k-- > 1){
            temp = temp.next;
        }

        ListNode p1 = temp;
        ListNode p2 = head;
        while (temp != null && temp.next != null) {
            p2 = p2.next;
            temp = temp.next;
        }

        int node1 = p1.val;
        int node2 = p2.val;

        p1.val = node2;
        p2.val = node1;

        return head;
    }
}