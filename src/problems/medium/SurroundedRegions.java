package problems.medium;

/**
 * leetcode 130 SurroundedRegions Medium
 * 
 */

public class SurroundedRegions {
    //Runtime: 5 ms, faster than 17.09% of Java online submissions for Surrounded Regions.
    //Memory Usage: 45.2 MB, less than 50.00% of Java online submissions for Surrounded Regions.
    enum VisitStatus {
        NO_VISIT, VISITED, SETTED
    }

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        VisitStatus[][] isVisited = new VisitStatus[board.length][board[0].length];
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                isVisited[i][j] = VisitStatus.NO_VISIT;
            }
        }
        for (int i = 0; i < isVisited.length; i++) {
            for (int j = 0; j < isVisited[0].length; j++) {
                if (board[i][j] == 'O' && isVisited[i][j] == VisitStatus.NO_VISIT
                        && isSurrounded(board, isVisited, i, j)) {
                    setSurroundedX(board, isVisited, i, j);
                    // for(int x=0;x<board.length;x++){
                    // for(int y=0;y<board[0].length;y++){
                    // System.out.print(board[x][y]+" ");
                    // }
                    // System.out.println();
                    // }
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, VisitStatus[][] isVisited, int i, int j) {
        isVisited[i][j] = VisitStatus.VISITED;
        boolean result = true;
        /** ↑ ← ↓ → */
        if (i > 0 && board[i - 1][j] == 'O' && isVisited[i - 1][j] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i - 1, j)) {
            result = false;
        }
        if (j > 0 && board[i][j - 1] == 'O' && isVisited[i][j - 1] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i, j - 1)) {
            result = false;
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O' && isVisited[i + 1][j] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i + 1, j)) {
            result = false;
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O' && isVisited[i][j + 1] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i, j + 1)) {
            result = false;
        }
        if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1) {
            result = false;
        }
        return result;
    }

    private void setSurroundedX(char[][] board, VisitStatus[][] isVisited, int i, int j) {
        board[i][j] = 'X';
        isVisited[i][j] = VisitStatus.SETTED;
        /** ↑ ← ↓ → */
        if (i > 0 && board[i - 1][j] == 'O' && isVisited[i - 1][j] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i - 1, j);
        }
        if (j > 0 && board[i][j - 1] == 'O' && isVisited[i][j - 1] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i, j - 1);
        }
        if (i < board.length - 1 && board[i + 1][j] == 'O' && isVisited[i + 1][j] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i + 1, j);
        }
        if (j < board[0].length - 1 && board[i][j + 1] == 'O' && isVisited[i][j + 1] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i, j + 1);
        }
    }
}
//[["O","O","O","O","X","X"],["O","O","O","O","O","O"],["O","X","O","X","O","O"],["O","X","O","O","X","O"],["O","X","O","X","O","O"],["O","X","O","O","O","O"]]