/*
Hi, here's your problem today. This problem was recently asked by Google:

Given a singly-linked list, reverse the list. This can be done iteratively or recursively. Can you get both solutions?

Example:
Input: 4 -> 3 -> 2 -> 1 -> 0 -> NULL
Output: 0 -> 1 -> 2 -> 3 -> 4 -> NULL
*/
package main.java;
/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
public class _5_Reverse_a_Linked_List {

    //Reverse a linked List using iteration
    public ListNode reverseListIter(ListNode head) {
        ListNode curr = head;
        ListNode next = null;
        ListNode prev = null;        
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }        
        return prev;
    }
    
    //Reverse a linked list using recursion
    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        if(head.next == null)
            return head;
        ListNode curr = head;
        ListNode next = curr.next;
        ListNode newHead = reverseList(next);
        next.next = curr;
        curr.next = null;
        return newHead;        
    }
}