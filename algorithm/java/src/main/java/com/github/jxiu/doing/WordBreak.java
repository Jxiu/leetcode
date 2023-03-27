package com.github.jxiu.doing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 139. 单词拆分(medium)
 * TODO 使用动态规划
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word: wordDict) {
                int len = word.length();
                if (i >= len && Objects.equals(s.substring(i-len, i),word)){
                    // 判断一个新的单词是否能由前一个单词组成
                    dp[i] = dp[i] || dp[i-len];
                }
            }
        }
        return dp[n];
    }

    public boolean wordBreak_i(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0){
            return false;
        }
        // 按照首字母排序
        Map<Character, List<String>> map = wordDict.stream().collect(Collectors.groupingBy(si -> Character.valueOf(si.charAt(0)), Collectors.mapping(Function.identity(), Collectors.toList())));
        return findNext(s, map);
    }

    private boolean findNext(String s, Map<Character, List<String>> map) {
        Character fc = s.charAt(0);
        List<String> fWords = null;
        if ((fWords = map.get(fc)) != null){
            for (int i = 0; i < fWords.size(); i++) {
                String fWord = fWords.get(i);
                if (s.equals(fWord)) return true;
                if (s.startsWith(fWord)){
                    String sub = s.replace(fWord, "");
                    if (findNext(sub, map)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
