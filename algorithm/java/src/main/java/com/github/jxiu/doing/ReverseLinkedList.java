package com.github.jxiu.doing;

import java.util.Objects;

/**
 * 206. 反转链表 (Easy)
 */
public class ReverseLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        public static ListNode valueOf(int[] a){
            if (a == null){
                return null;
            }
            ListNode dummy = new ListNode();
            ListNode pre = null;
            for (int i : a ){
                ListNode curr = new ListNode(i);
                if (dummy.next == null){
                    dummy.next = curr;
                }else {
                    pre.next = curr;
                }
                    pre = curr;
            }
            return dummy.next;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            ListNode pre = new ListNode(0,this);
            ListNode curr = null;
            do {
                curr = pre.next;
                sb.append(curr.val).append(",");
                pre = curr;
            }while (curr.next != null);
            if (sb.length() > 0 ){
                sb.delete(sb.length()-1,sb.length());
            }
            return sb.toString();
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null){
                return false;
            }
            if (! (obj instanceof ListNode)){
                return false;
            }
            ListNode o = (ListNode) obj;
            if (val != o.val){
                return false;
            }
            if (Objects.equals(next,o.next)){
                return true;
            }
            return false;
        }
    }

    /**
     * 1,2,3
     * 指针实现
     * @param head
     * @return
     */
    public ListNode reverseList_ptr(ListNode head) {
        ListNode prev = null, next;
        while (head != null){
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    /**
     *  递归实现
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        return recursive(head);
    }

    private ListNode recursive(ListNode node) {
        if (node.next == null){
            // 最后一个元素
            return node;
        }
        ListNode next = node.next;
        node.next = null;
        ListNode head = recursive(next);
        next.next = node;
        return head;
    }

}
