package problems.medium;

/**
 * leetcode 71 SimplifyPath Medium
 * Given an absolute path for a file (Unix-style), simplify it. Or in other words, convert it to the canonical path.
 * <p>
 * In a UNIX-style file system, a period . refers to the current directory. Furthermore, a double period .. moves the directory up a level. For more information, see: Absolute path vs relative path in Linux/Unix
 * <p>
 * Note that the returned canonical path must always begin with a slash /, and there must be only a single slash / between two directory names. The last directory name (if it exists) must not end with a trailing /. Also, the canonical path must be the shortest string representing the absolute path.
 */
public class SimplifyPath {

    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();

        return null;
    }

    public void test(){
        // "/home/" -> "/home"
        // "/../" -> "/"
        // "/home//foo/" -> "/home/foo"
        // "/a/./b/../../c/" -> "/c"
        // "/a/../../b/../c//.//" -> "/c"
        // "/a//b////c/d//././/.." -> "/a/b/c"
        System.out.println(simplifyPath("/home/"));
    }
}
