package problems.medium;

import java.util.*;

/**
 * leetcode 129
 * 
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * See leetcode 5
 */
public class PalindromePartitioning {
    //
    //
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return new ArrayList<>();
        }
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int length = 1; length <= s.length(); length++) {
            for (int i = 0; i < s.length() - length + 1; i++) {
                if (length == 1)
                    isPalindrome[i][i + length - 1] = true;
                if (length == 2)
                    isPalindrome[i][i + length - 1] = (s.charAt(i) == s.charAt(i + length - 1));
                else
                    isPalindrome[i][i + length - 1] = isPalindrome[i + 1][i + length - 2];
            }
        }
        List<List<String>> result = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();

        return null;
    }

    void backtracking(List<List<String>> result,List<String> tmpList,boolean[][] isPalin,int index,String s){
        if(index == s.length()){
            
        }else{ 

        }
    }

}