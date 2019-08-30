class Solution {
    
    boolean globe=false;
    boolean[][] track;
        
        public void dfs(char[][] board, String word, int i, int j)
        {
            if(word.length()==0)
            {
                globe=true;
                return;
            }
            if(i<0 || j<0 || i>=board.length || j>=board[0].length || track[i][j])
                return;
            if(board[i][j]!=word.charAt(0))
                return;
            track[i][j]=true;
            
            if(globe!=true)
                dfs(board, word.substring(1), i+1, j);              
            
            if(globe!=true)
                dfs(board, word.substring(1), i-1, j);
            
            if(globe!=true)                          
                dfs(board, word.substring(1), i, j+1);
             
            if(globe!=true)
                dfs(board, word.substring(1), i, j-1);  
            
            track[i][j]=false;
        }
        
    public boolean exist(char[][] board, String word) {
        
        if(board.length==0 && word.length()==0)
            return true;
        else if(board.length==0)
            return false;
        else if(word.length()==0)
            return false;
        
        track=new boolean[board.length][board[0].length];
    
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    dfs(board,word,i,j);
                    if(globe==true)
                        return true;
                }
            }
        }
        
        return false;
        
    }
}

/* slightly faster approach without using substring function.

class Solution {
    
    boolean globe=false;
    boolean[][] track;
        
        public void dfs(char[][] board, String word, int i, int j, int count)
        {
            if(word.length()==count)
            {
                globe=true;
                return;
            }
            if(i<0 || j<0 || i>=board.length || j>=board[0].length || track[i][j])
                return;
            if(board[i][j]!=word.charAt(count))
                return;
            track[i][j]=true;
            
            if(globe!=true)
                dfs(board, word, i+1, j, count+1);              
            
            if(globe!=true)
                dfs(board, word, i-1, j, count+1);
            
            if(globe!=true)                          
                dfs(board, word, i, j+1, count+1);
             
            if(globe!=true)
                dfs(board, word, i, j-1, count+1);  
            
            track[i][j]=false;
        }
        
    public boolean exist(char[][] board, String word) {
        
        if(board.length==0 && word.length()==0)
            return true;
        else if(board.length==0)
            return false;
        else if(word.length()==0)
            return false;
        
        track=new boolean[board.length][board[0].length];
    
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(word.charAt(0)==board[i][j])
                {
                    dfs(board,word,i,j,0);
                    if(globe==true)
                        return true;
                }
            }
        }
        
        return false;
        
    }
}

*/