/*
Hi, here's your problem today. This problem was recently asked by Microsoft:

You are given two linked-lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
*/
package main.java;

class Node {
    int val;
    Node next;
    Node(int val) {
        this.val = val;
    }
    Node() {
    }
}

public class _1_Add_two_numbers_as_a_linked_list {

    public static void main(String[] args) {
        Node firstnum = new Node(2);
        firstnum.next = new Node(4);
        firstnum.next.next = new Node(3);

        Node secondnum = new Node(5);
        secondnum.next = new Node(6);
        secondnum.next.next = new Node(4);

        Node sum = addTwoNumbers(firstnum, secondnum);

        while(sum!=null) {
            System.out.print(sum.val+" ");
            sum = sum.next;
        }
    }

    public static Node addTwoNumbers(Node firstnum, Node secondnum) {
        Node sum = null;
        Node sumtail = null;
        int carry = 0;
        while(firstnum != null && secondnum != null) {
            int digitsum = firstnum.val + secondnum.val + carry;
            
            if(sum == null) {
                sum = new Node();
                sum.val = digitsum % 10;
                sumtail = sum;
            }
            else {
                sumtail.next = new Node();
                sumtail = sumtail.next;
                sumtail.val = digitsum % 10;
            }
            carry = digitsum / 10;
            firstnum = firstnum.next;
            secondnum = secondnum.next;
        }

        while(firstnum != null) {
            int digitsum = firstnum.val + carry;
            if(sum == null) {
                sum = new Node();
                sum.val = digitsum % 10;
                sumtail = sum;
            }
            else {
                sumtail.next = new Node();
                sumtail = sumtail.next;
                sumtail.val = digitsum % 10;
            }
            carry = digitsum / 10;
        }

        while(secondnum != null) {
            int digitsum = secondnum.val + carry;
            if(sum == null) {
                sum = new Node();
                sum.val = digitsum % 10;
                sumtail = sum;
            }
            else {
                sumtail.next = new Node();
                sumtail = sumtail.next;
                sumtail.val = digitsum % 10;
            }
            carry = digitsum / 10;
        }

        if(carry > 0) {
            sumtail.next = new Node();
            sumtail = sumtail.next;
            sumtail.val = carry;
        }

        return sum;
    }



}