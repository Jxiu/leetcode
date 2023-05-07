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
}
