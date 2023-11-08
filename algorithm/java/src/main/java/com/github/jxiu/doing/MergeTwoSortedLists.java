package com.github.jxiu.doing;

import com.github.jxiu.struct.ListNode;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(),node = dummy;
        // 合并两个链表
        while (l1 != null && l2 != null){
            if (l1.val <= l2.val){
                node.next = l1;
                l1 = l1.next;
            }else {
                node.next = l2;
                l2 = l2.next;
            }
            node = node.next;
        }
        node.next = l1 == null ? l2: l1;
        return dummy.next;
    }


    public int[] mergeTwoArrays(int[] a1, int[] a2){
        if (a1 == null && a2 == null) return null;
        if (a1 == null) return  a2;
        if (a2 == null) return  a1;

        int l = a2.length + a1.length;
        int[] r = new int[l];
        int i1 = 0, i2 =0;
        for (int i = 0; i < l; i++) {
            if (i1 >= a1.length){
                r[i] = a2[i2];
                i2++;
            }else if (i2 >= a2.length){
                r[i] = a1[i1];
                i1++;
            }else if (a1[i1] <= a2[i2]){
                r[i] = a1[i1];
                i1++;
            } else {
                r[i] = a2[i2];
                i2++;
            }
        }
        return r;
    }
}
