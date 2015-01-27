public class Solution {
    public void solveSudoku(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        helper(board,0,0);
    }
    private boolean helper(char[][] board,int i, int j){
        if(i == 9){
            return true;
        }
        if(j == 9){
            return helper(board, i + 1, 0);
        }
        if(board[i][j] != '.') return helper(board,i,j + 1);
        else {
            for(int m = 1; m < 10; m++){
                board[i][j] = (char) (m + '0');
                if(isValid(board,i,j)){
                    if(helper(board,i,j + 1))
                        return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    private boolean isValid(char[][] board, int i, int j){
        for(int m = 0; m < 9; m++){
            if(m != j && board[i][m] == board[i][j])
                return false;
        }
        for(int n = 0 ; n < 9; n++){
            if(n != i && board[n][j] == board[i][j])
                return false;
        }
        for(int m = (i / 3) * 3; m < (i / 3) * 3 + 3; m++){
            for(int n = (j / 3) * 3; n < (j / 3) * 3 + 3; n++){
                if(m != i && n != j && board[m][n] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}