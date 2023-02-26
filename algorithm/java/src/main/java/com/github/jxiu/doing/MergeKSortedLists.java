package com.github.jxiu.doing;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * leectcode<br/>
 * no.23. 合并K个升序链表<url>https://leetcode.cn/problems/merge-k-sorted-lists/</url>
 */
public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));
        for (int i = 0; i < lists.length; i++) {
            queue.add(lists[i]);
        }
        System.out.println(queue);
        ListNode head = null, last = null;
        while (!queue.isEmpty()){
            ListNode minNode = queue.poll();
            if (head == null){
                head = minNode;
                last = minNode;
            }else {
                last.next = minNode;
                last = minNode;
            }
            ListNode next = minNode.next;
            if (next != null){
                queue.add(next);
            }
        }
        return head;
    }

   //Definition for singly-linked list.
   public static class ListNode {
       int val;
       ListNode next;
       ListNode() {}
       ListNode(int val) { this.val = val; }
       ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       public int getVal() {
           return val;
       }

       public ListNode getNext() {
           return next;
       }

       @Override
       public String toString() {
           StringBuilder sb = new StringBuilder();
           sb.append("[" + val);
           ListNode node = next;
           while (node != null){
               sb.append("," + node.val);
               node = node.next;
           }
           sb.append("]");
           return sb.toString();
       }

       public static ListNode fromArray(int[] a){
           if (a == null || a.length == 0){
               return null;
           }
           ListNode head = null, last = null;
           for (int i : a){
               ListNode node = new ListNode(i);
               if (head == null){
                   head = node;
                   last = node;
               }else {
                   last.next = node;
                   last = node;
               }
           }
           return head;
       }
   }



}
