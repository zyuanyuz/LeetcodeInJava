package basic.algorithm;

/**
 * KMP string match algorithom
 */

public class KMP {

    public static int isMatch(String pattern, String str) {
        int[] array = KMP.computePrefixFunction(pattern);
        int k = -1;
        for (int i = 0; i < str.length(); i++) {
            while (k >= 0 && pattern.charAt(k + 1) != str.charAt(i)) {
                k = array[k];
            }
            if (pattern.charAt(k + 1) == str.charAt(i)) {
                k++;
            }
            if (k == pattern.length() - 1) {
                return (i - pattern.length() + 1);
            }
        }
        return -1;
    }

    /**
     * from CLRS
     * 
     * @param pattern
     * @return
     */
    public static int[] computePrefixFunction(String pattern) {
        int[] array = new int[pattern.length()];
        array[0] = -1;
        int k = -1;
        for (int i = 1; i < pattern.length(); i++) {
            while (k >= 0 && pattern.charAt(k + 1) != pattern.charAt(i)) {
                k = array[k]; // ?
            }
            if (pattern.charAt(k + 1) == pattern.charAt(i)) {
                k++;
            }
            array[i] = k;
        }
        return array;
    }

    public static void main(String[] args) {
        String pattern = "ababaca";
        String str = "abbcabcbacabda";
        System.out.println(isMatch(pattern, str));
    }
}