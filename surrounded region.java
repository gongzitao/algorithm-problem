import java.util.LinkedList;
public class Solution {
    LinkedList<Integer> queue = new LinkedList<Integer>();
    public void solve(char[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        
        for(int i = 0; i < board[0].length; i++)
            findAllO(board,0,i);
        for(int i = 0 ;i < board.length; i++)
            findAllO(board,i,0);
        for(int i = 0; i < board[0].length; i++)
            findAllO(board,board.length - 1,i);
        for(int i = 0; i < board.length; i++)
            findAllO(board,i,board[0].length - 1);
        for(int i = 0; i  < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }
    private void findAllO(char[][] board, int i, int j){
        fill(board,i,j);
        while(!queue.isEmpty()){
            int index = queue.poll();
            int row = index / board[0].length;
            int col = index % board[0].length;
            fill(board,row - 1,col);
            fill(board,row + 1,col);
            fill(board,row ,col + 1);
            fill(board,row ,col - 1);
        }
    }
    private void fill(char[][] board,int i, int j){
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != 'O')
            return;
        board[i][j] = 'R';
        int num = i * board[0].length + j;
        queue.offer(num);
    }
}