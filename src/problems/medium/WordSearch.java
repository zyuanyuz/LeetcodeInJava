package problems.medium;

/**
 * leetcode 79 WordSearch Medium
 * Given a 2D board and a word, find if the word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * <p>
 * Example:
 * <p>
 * board =
 * [
 * ['A','B','C','E'],
 * ['S','F','C','S'],
 * ['A','D','E','E']
 * ]
 * <p>
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 */
public class WordSearch {
    //Runtime: 5 ms, faster than 85.09% of Java online submissions for Word Search.
    //Memory Usage: 43 MB, less than 19.97% of Java online submissions for Word Search.
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) return true;
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }

        int[][] symbol = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {  //start a judge
                    if (isValid(board, symbol, i, j, 0, word)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isValid(char[][] board, int[][] symbol, int x, int y, int n, String word) {
        if (n == word.length() - 1) {
            return true;
        } else {
            symbol[x][y] = 1;
            if ((x > 0 && symbol[x - 1][y] == 0 && board[x - 1][y] == word.charAt(n + 1) && isValid(board, symbol, x - 1, y, n + 1, word))    //case 1 : to up
                    || (y > 0 && symbol[x][y - 1] == 0 && board[x][y - 1] == word.charAt(n + 1) && isValid(board, symbol, x, y - 1, n + 1, word))  // case 2: to left
                    || (x < board.length - 1 && symbol[x + 1][y] == 0 && board[x + 1][y] == word.charAt(n + 1) && isValid(board, symbol, x + 1, y, n + 1, word))  //case 3:to down
                    || (y < board[0].length - 1 && symbol[x][y + 1] == 0 && board[x][y + 1] == word.charAt(n + 1) && isValid(board, symbol, x, y + 1, n + 1, word))) {  //case 4: to right
                return true;
            }
            symbol[x][y] = 0;
            return false;
        }
    }

    public void test() {
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        //ABCCED
        //
        char[][] board = new char[][]{{'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}, {'A', 'A', 'A', 'A'}};
        System.out.println(exist(board, "AAAAA"));
    }
}
