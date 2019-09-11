package problems.medium;

import java.util.*;

/**
 * leetcode 139
 */
public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        
    }

    boolean isWordBreak(String s,int index,List<String> wordDict){
        
    }

    public static void main(String[] args) {
        WordBreak wBreak = new WordBreak();
        String s = "cars";
        List<String> wordDict = Arrays.asList("cars", "ca", "rs");
        System.out.println(wBreak.wordBreak(s, wordDict));
    }
}
//"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
//["a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"]
