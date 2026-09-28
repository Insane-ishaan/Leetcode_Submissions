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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        List<Integer> ls = new ArrayList<>();

        for (ListNode list : lists) {
            ListNode curr = list;
            while (curr != null) {
                ls.add(curr.val);
                curr = curr.next;
            }
        }
        
        if(ls.isEmpty()) return null;

        Collections.sort(ls);
        for (int v : ls) {
            System.out.print(v + " ");
        }

        int value = ls.remove(0);
        ListNode newList = new ListNode(value);
        ListNode curr = newList;

        while (!ls.isEmpty()) {
            int v = ls.remove(0);
            ListNode newNode = new ListNode(v);
            curr.next = newNode;
            curr = curr.next;
        }

        return newList; 
    }
}