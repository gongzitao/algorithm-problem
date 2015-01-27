public class Solution {
    public boolean exist(char[][] board, String word) {
        if(board == null || board.length == 0 || board[0].length == 0){
            if(word == null || word.length() == 0) return true;
            else return false;
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        return helper(board,visited,word);
    }
    private boolean helper(char[][] board, boolean[][] visited, String word){
        //if(item.equals(word))   return true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    visited[i][j] = true;
                    if(searchNearby(board,visited,i,j,word,1)) return true;
                    visited[i][j] = false;
                }
            }
        }
        return false;
    }
    private boolean searchNearby(char[][] board, boolean[][] visited, int i, int j, String word, int index){
        if(index == word.length()) return true;
        if(i > 0 && i < board.length && j >= 0 && j < board[0].length && !visited[i - 1][j] && board[i - 1][j] == word.charAt(index)){
            visited[i - 1][j] = true;
            if(searchNearby(board,visited,i - 1,j,word,index + 1)) return true;
            visited[i - 1][j] = false;
        }
        if(i >= 0 && i < board.length - 1 && j >= 0 && j < board[0].length && !visited[i + 1][j] && board[i + 1][j] == word.charAt(index)){
            visited[i + 1][j] = true;
            if(searchNearby(board,visited,i + 1,j,word,index + 1)) return true;
            visited[i + 1][j] = false;
        }
        if(i >= 0 && i < board.length && j > 0 && j < board[0].length && !visited[i][j - 1] && board[i][j - 1] == word.charAt(index)){
            visited[i][j - 1] = true;
            if(searchNearby(board,visited,i ,j - 1,word,index + 1)) return true;
            visited[i][j - 1] = false;
        }
        if(i >= 0 && i < board.length && j >= 0 && j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word.charAt(index)){
            visited[i][j + 1] = true;
            if(searchNearby(board,visited,i ,j + 1,word,index + 1)) return true;
            visited[i][j + 1] = false;
        }
        return false;
    }
}