package problems.easy;

/**leetcode 771
 *  
 * 
 *
 */
//优化思路：遍历S时存在即删除相应的字符
//Runtime:11 ms
public class JewelsAndStones {
	public int numJewelsInStones(String J, String S) {
        int jewels = 0;
        for(int i = 0;i<J.length();i++) {
        	for(int j = 0;j<S.length();j++) {
        		if(J.charAt(i)==S.charAt(j)) {
        			jewels++;
        		}
        	}
        }
        return jewels;
    }
}
