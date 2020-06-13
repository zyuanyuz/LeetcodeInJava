package problems.offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P38 {
    /**
     * 执行用时 : 18 ms , 在所有 Java 提交中击败了 78.81% 的用户 内存消耗 : 44.1 MB , 在所有 Java 提交中击败了
     * 100.00% 的用户
     */
    public String[] permutation(String s) {
        char[] charArray = s.toCharArray();
        Set<String> result = new HashSet<>();
        backtracking(result, charArray, 0);
        String[] strResult = new String[result.size()];
        int index = 0;
        for (String str : result) {
            strResult[index++] = str;
        }
        return strResult;
    }

    void backtracking(Set<String> result, char[] arr, int index) {
        if (index >= arr.length) {
            result.add(new String(arr));
        } else {
            backtracking(result, arr, index + 1);
            for (int i = index + 1; i < arr.length; i++) {
                if (arr[i] == arr[index]) {
                    continue;
                }
                char tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
                backtracking(result, arr, index + 1);
                tmp = arr[index];
                arr[index] = arr[i];
                arr[i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        P38 p = new P38();
        p.permutation("abbc");
    }
}