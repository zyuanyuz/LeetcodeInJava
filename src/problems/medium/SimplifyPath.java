package problems.medium;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * leetcode 71 SimplifyPath Medium Given an absolute path for a file
 * (Unix-style), simplify it. Or in other words, convert it to the canonical
 * path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory.
 * Furthermore, a double period .. moves the directory up a level. For more
 * information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and
 * there must be only a single slash / between two directory names. The last
 * directory name (if it exists) must not end with a trailing /. Also, the
 * canonical path must be the shortest string representing the absolute path.
 */
public class SimplifyPath {

    //Runtime: 41 ms, faster than 5.05% of Java online submissions for Simplify Path.
    //Memory Usage: 36.9 MB, less than 100.00% of Java online submissions for Simplify Path.
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();
        String[] pathSplit = Arrays.stream(path.split("/")).filter(p -> !p.isEmpty() && !p.equals("."))
                .toArray(String[]::new);
        if (!path.startsWith("/")) {
            return "";
        }

        for (int i = 0; i < pathSplit.length; i++) {
            if (i >= 0 && pathSplit[i].equals("..")) {
                pathSplit[i] = "";
                for (int j = i - 1; j >= 0; j--) {
                    if (pathSplit[j].isEmpty())
                        continue;
                    pathSplit[j] = "";
                    break;
                }
                pathSplit[i] = "";
            }
        }
        for (int i = 0; i < pathSplit.length; i++) {
            if (!pathSplit[i].isEmpty()) {
                result.append("/" + pathSplit[i]);
            }
        }
        if(result.toString().isEmpty()){
            result.append("/");
        }

        return result.toString();
    }

    public void test() {
        // "/home/" -> "/home"
        // "/../" -> "/"
        // "/home//foo/" -> "/home/foo"
        // "/a/./b/../../c/" -> "/c"
        // "/a/../../b/../c//.//" -> "/c"
        // "/a//b////c/d//././/.." -> "/a/b/c"
        System.out.println(simplifyPath("/../"));
    }

    public static void main(String[] args) {
        SimplifyPath simplifyPath = new SimplifyPath();
        simplifyPath.test();
    }
}
