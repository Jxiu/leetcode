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

    /**
     *
     * [4,3,2,7,8,2,3,1]
     * [7,3,2,4,8,2,3,1]
     * [-1,2,3,4,8,2,7,1]
     * [-1,2,3,4,1,2,7,8]
     * [1,2,3,4,-1,-1,7,8]
     * @param nums
     * @return
     */
    public List<Integer> solution(int[] nums){

        List<Integer> result = new ArrayList<>();
        return result;
    }
}
