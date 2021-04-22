package org.sweatshop.tests;

public class AddTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode total = addTwoNumbers(l1, l2);
        System.out.println(total);
    }


    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int digit = l1.val + l2.val;
        ListNode total = new ListNode(digit % 10);
        return addTwoNumbers(l1.next, l2.next, total, total, digit / 10);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2, ListNode totalHead, ListNode totalTail, int carry)
    {
        if (l1 == null && l2 == null) {
            return totalHead;
        } else {
            int digit = getVal(l1) + getVal(l2) + carry;
            ListNode total = new ListNode(digit % 10);
            totalTail.next = total;
            totalTail = total;
            return addTwoNumbers(getNext(l1), getNext(l2), totalHead, totalTail, digit / 10);
        }
    }

    public static final int getVal(ListNode l) {
        if (null == l) {
            return 0;
        } else {
            return l.val;
        }
    }

    public static final ListNode getNext(ListNode l) {
        if (null == l) {
            return null;
        } else {
            return l.next;
        }
    }
}
