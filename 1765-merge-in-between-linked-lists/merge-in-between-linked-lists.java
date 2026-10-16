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
    private ListNode getNode(ListNode head, int pos) {
        int count = 0;

        while (pos != count) {
            head = head.next;
            count++;
        }

        return head;
    }

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode n1 = getNode(list1, a - 1);
        ListNode n2 = getNode(list1, b + 1);

        n1.next = list2;
        ListNode temp = n1;
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = n2;
        return list1;
    }
}