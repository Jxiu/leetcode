package com.github.jxiu.doing;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 242. 有效的字母异位词(easy)
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        //若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()) return false;
        if (s.length() == 0) return true;
        Map<Character, Integer> sm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sm.computeIfPresent(s.charAt(i),(k,v) -> v +1);
            sm.putIfAbsent(s.charAt(i),1);
        }
        System.out.println(sm);
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            Integer nv = sm.computeIfPresent(c,(k,v) -> v - 1);
            if (nv != null && nv == 0){
                sm.remove(c);
            }
        }
        System.out.println(sm);
        return sm.isEmpty();
    }

}
