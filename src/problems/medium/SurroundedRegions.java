package problems.medium;

/**
 * leetcode 130
 * 
 */

public class SurroundedRegions {
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
                }
            }
        }
    }

    private boolean isSurrounded(char[][] board, VisitStatus[][] isVisited, int i, int j) {
        isVisited[i][j] = VisitStatus.VISITED;
        if ((i == 0 || i == board.length || j == 0 || j == board[0].length) && board[i][j] == 'O') {
            return false;
        }
        /** ↑ ← ↓ → */
        if (i > 0 && board[i - 1][j] == 'O' && isVisited[i - 1][j] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i - 1, j)) {
            return false;
        }
        if (j > 0 && board[i][j - 1] == 'O' && isVisited[i][j - 1] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i, j - 1)) {
            return false;
        }
        if (i < board.length-1 && board[i + 1][j] == 'O' && isVisited[i + 1][j] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i + 1, j)) {
            return false;
        }
        if (j < board[0].length-1 && board[i][j + 1] == 'O' && isVisited[i][j + 1] == VisitStatus.NO_VISIT
                && !isSurrounded(board, isVisited, i, j + 1)) {
            return false;
        }
        return true;
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
        if (i < board.length-1 && board[i + 1][j] == 'O' && isVisited[i + 1][j] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i + 1, j);
        }
        if (j < board[0].length-1 && board[i][j + 1] == 'O' && isVisited[i][j + 1] != VisitStatus.SETTED) {
            setSurroundedX(board, isVisited, i, j + 1);
        }
    }
}