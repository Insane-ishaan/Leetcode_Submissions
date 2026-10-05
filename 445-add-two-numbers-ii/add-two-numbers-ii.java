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
    private ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode revl1 = reverse(l1);
        ListNode revl2 = reverse(l2);
        ListNode currRevl1 = revl1;
        ListNode currRevl2 = revl2;
        ListNode result = new ListNode(-1);
        ListNode currRes = result;
        int sum = 0;
        int carry = 0;

        while (currRevl1 != null || currRevl2 != null || carry != 0) {
            int currVal1 = currRevl1 == null ? 0 : currRevl1.val;
            int currVal2 = currRevl2 == null ? 0 : currRevl2.val;
            sum = currVal1 + currVal2 + carry;
            carry = sum / 10;
            int digit = sum % 10;

            ListNode newNode = new ListNode(digit);
            currRes.next = newNode;

            if (currRevl1 != null) {
                currRevl1 = currRevl1.next;
            }

            if (currRevl2 != null) {
                currRevl2 = currRevl2.next;
            }
            currRes = currRes.next;
        }

        return reverse(result.next);
    }
}