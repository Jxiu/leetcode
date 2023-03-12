package com.github.jxiu.doing;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素(easy)
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums){
            if (set.contains(num)){
                return true;
            }
            set.add(num);
        }
        return false;
    }
}
