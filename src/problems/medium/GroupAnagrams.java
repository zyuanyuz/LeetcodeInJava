package problems.medium;

import java.util.*;

/**
 * leetcode 49 Medium
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * <p>
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class GroupAnagrams {
    //Runtime: 13 ms, faster than 80.56% of Java online submissions for Group Anagrams.
    //Memory Usage: 45.4 MB, less than 22.35% of Java online submissions for Group Anagrams.
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<String>());
                map.get(key).add(str);
            }else{
                map.get(key).add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    public void test() {
        //["tho","tin","erg","end","pug","ton","alb","mes","job","ads","soy","toe","tap","sen","ape","led","rig","rig","con","wac","gog","zen","hay","lie","pay","kid","oaf","arc","hay","vet","sat","gap","hop","ben","gem","dem","pie","eco","cub","coy","pep","wot","wee"]
        //["mod","mop","pip","tug","hop","dog","met","zoe","axe","mug","fdr","for","fro","fdr","pap","ray","lop","nth","old","eva","ell","mci","wee","ind","but","all","her","lew","ken","awl","law","rim","zit","did","yam","not","ref","lao","gab","sax","cup","new","job","new","del","gap","win","pot","lam","mgm","yup","hon","khz","sop","has","era","ark"]
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        System.out.println(result);
    }
}
