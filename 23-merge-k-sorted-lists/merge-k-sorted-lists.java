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

    private ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                temp = temp.next;
                list1 = list1.next;
            } else {
                temp.next = list2;
                temp = temp.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            temp.next = list1;
        } else if (list2 != null) {
            temp.next = list2;
        }

        return dummyNode.next;
    }

    private ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode left = head;

        ListNode l = sortList(left);
        ListNode r = sortList(right);

        return merge(l, r);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;
        if (len < 1) {
            return null;
        }

        ListNode result = new ListNode(-1);
        ListNode it = result;

        for (int i = 0; i < len; i++) {
            if (lists[i] == null)
                continue;
            it.next = lists[i];
            while (it.next != null) {
                it = it.next;
            }
        }

        ListNode temp = result;

        return sortList(result.next);
    }
}