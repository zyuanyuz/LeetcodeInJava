package problems.medium;

/**
 * leetcode 130
 * 
 */

public class SurroundedRegions {

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        byte[][] isVisited = new byte[board.length][board[0].length];
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                if (board[i][j] == 'O' && isVisited[i][j] == 0) {

                }
            }
        }
    }

    
}