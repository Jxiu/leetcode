package com.github.jxiu;

import com.github.jxiu.MergeKSortedLists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class MergeKSortedListsTest {

    @Test
    public void successTest(){
        MergeKSortedLists.ListNode[] list = new MergeKSortedLists.ListNode[]{
            MergeKSortedLists.ListNode.fromArray(new int[]{1,4,5}),
            MergeKSortedLists.ListNode.fromArray(new int[]{1,3,4}),
            MergeKSortedLists.ListNode.fromArray(new int[]{2,6})
        };
        System.out.println(Arrays.deepToString(list));
        MergeKSortedLists issue = new MergeKSortedLists();
        MergeKSortedLists.ListNode listNode = issue.mergeKLists(list);
        System.out.println(listNode);
    }

    @Test
    public void testNodeSort(){
        MergeKSortedLists.ListNode.fromArray(new int[]{1,3,4});
        MergeKSortedLists.ListNode.fromArray(new int[]{2,6});
        List<MergeKSortedLists.ListNode> list = Stream.of(MergeKSortedLists.ListNode.fromArray(new int[]{1,3,4}), MergeKSortedLists.ListNode.fromArray(new int[]{2,6}))
                .sorted((o1,o2)-> o2.val - o1.val).collect(Collectors.toList());
        Assertions.assertEquals(list.get(0).val, 2);
    }


}