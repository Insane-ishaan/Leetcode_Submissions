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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> st = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            st.add(curr);
            curr = curr.next;
        }

        curr = headB;
        while (curr != null) {
            if (st.contains(curr)) {
                return curr;
            }
            st.add(curr);
            curr = curr.next;
        }

        return null;
    }
}