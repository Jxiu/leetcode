package com.github.jxiu.doing;

/**
 * 287. 寻找重复数 TODO 复习
 * <br/>你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 */
public class FindTheDuplicateNumber {

    /**
     * 快慢指针，线性级时间复杂度 O(n) 的解决方案
     * <p>
     *     快慢指针，一个时间复杂度为O(N)的算法。
     *     <ul>
     *         <li>其一，对于链表问题，使用快慢指针可以判断是否有环。</li>
     *         <li>其二，本题可以使用数组配合下标，抽象成链表问题。但是难点是要定位环的入口位置。</li>
     *         <li>其三，快慢指针问题，会在环内的[9]->1->5->3->6->8->7->[9]任何一个节点追上，不一定是在[9]处相碰，事实上会在7处碰上。</li>
     *         <li></li>
     *     </ul>
     * </p>
     * <p>
     *     nums = [2,5, 9 ,6,9,3,8, 9 ,7,1]
     *     构造成链表就是：2->[9]->1->5->3->6->8->7->[9],也就是在[9]处循环
     * </p>
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0], fast = nums[0];
        // 两个指针相等则存在环形
        do {
            // 连个指针有速度差，但是（在链表内）路径一样，所以到环形节点之后快指针重走路径必定会与慢指针相遇
            // 慢指针走一步
            slow = nums[slow];
            // 快指针两次寻址，走两步
            fast = nums[nums[fast]];
        }while (slow != fast);
        int p1 = nums[0]; // 2->[9]->1->5->3->6->8->7->[9]
        int p2 = slow;
        while (p2 != p1){
            p1 = nums[p1];
            p2 = nums[p2];
        }
        return p1;
    }

        /**
         * 二分查找
         * @param nums
         * @return
         */
    public int findDuplicate1(int[] nums) {
        int n = nums.length;
        // 初始化二分的起始坐标,数组中最小数是1，最大是n-1
        // 注意这里遍历的不是数组而是1...n-1这个升序的序列
        int l = 1, r = n-1, ans = -1;
        while( l <= r){
            int mid = (l+r)>>1; //中点坐标
            int cnt = 0;
            // 遍历数组
            for (int i = 0; i < n; i++) {
                if (nums[i] <= mid){
                    cnt++;// 找到所有小于等于中间数的个数
                }
            }
            // 对所有小于（要寻找数）target的满足，数组中小于target的数个数小于等于数字本身
            // 所有大于target，由于target出现了多次所以导致小于本身的数字个数大于数字本身
            // 这个性质满足单调性
            if (cnt <= mid){
                l = mid + 1;
            }else {
                // 查找到第一个满足性质的数字
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;
    }
}
