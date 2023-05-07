package com.github.jxiu.struct;

import java.util.Objects;

public class ListNode {

    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

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
