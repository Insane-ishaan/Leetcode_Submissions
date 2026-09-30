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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ls1 = l1;
        ListNode ls2 = l2;
        ListNode result = new ListNode(-1);
        ListNode resultIt = result;
        int carry = 0;
        int sum = 0;

        while (ls1 != null || ls2 != null || carry != 0) {
            sum = 0;
            int ls1Val = ls1 != null ? ls1.val : 0;
            int ls2Val = ls2 != null ? ls2.val : 0;
            sum = ls1Val + ls2Val + carry;
            int digit = sum % 10;
            carry = sum / 10;
            resultIt.next = new ListNode(digit);

            if(ls1 != null){
                ls1 = ls1.next;
            }

            if(ls2 != null){
                ls2 = ls2.next;
            }
            
            resultIt = resultIt.next;
        }

        return result.next;
    }
}