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
    List<Integer> list = new ArrayList<>();
    int size = 0;

    public Solution(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            size += 1;
            list.add(curr.val);

            curr = curr.next;
        }
    }

    public int getRandom() {
        int randIdx = (int) (Math.random() * size);

        return list.get(randIdx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */