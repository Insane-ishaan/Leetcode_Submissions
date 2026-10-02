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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> mp = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        mp.put(0, dummy);
        int prefixSum = 0;

        while (head != null) {
            prefixSum += head.val;

            if (mp.containsKey(prefixSum)) {
                ListNode st = mp.get(prefixSum);
                ListNode temp = st.next;
                int p = prefixSum;

                while (temp != head) {
                    p += temp.val;
                    mp.remove(p);
                    temp = temp.next;
                }

                st.next = head.next;
            } else {
                mp.put(prefixSum, head);
            }
            head = head.next;
        }

        return dummy.next;
    }
}