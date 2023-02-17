package com.github.jxiu.doing;

import java.util.*;

public class FindAllNumbersDisappearedInArray {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int i : nums){
            set.add(i);
        }
        List<Integer> r = new ArrayList<>(nums.length-set.size());
        for (int i=1; i<=nums.length; i++){
            if (!set.contains(i)){
                r.add(i);
            }
        }
        return r;
    }
}
