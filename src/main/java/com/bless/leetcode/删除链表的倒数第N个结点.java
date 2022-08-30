package com.bless.leetcode;

public class 删除链表的倒数第N个结点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public int length;
    public int n;

    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.n = n;
        ListNode temp = new ListNode(0, head);
        dfs(temp, 0);
        return temp.next;
    }

    private void dfs(ListNode node, int num) {
        if (node == null) {
            length = num;
            return;
        }
        dfs(node.next, num + 1);
        if (length == num + n + 1) {
            node.next = node.next.next;
        }
    }

    /**
     * 永栈解决
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode temp = new ListNode(0, head);
        ListNode left = temp;
        ListNode right = temp;
        while (right != null) {
            if (n < 0) {
                left = left.next;
            }
            right = right.next;
            n--;
        }
        left.next = left.next.next;
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(3, null);
        ListNode a2 = new ListNode(2, a1);
        ListNode a3 = new ListNode(1, a2);
        删除链表的倒数第N个结点 o = new 删除链表的倒数第N个结点();
        System.out.println(o.removeNthFromEnd2(a3, 1));
    }

}
