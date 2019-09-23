class Solution {
    
    public boolean backtrack(char[][] board, int row, int col)
    {
        if(row==board.length)
            return true;
        boolean ans=false;
        if(col>=board[row].length)
        {
            ans=backtrack(board, row+1,0);
            return ans;
        }
        else if(board[row][col]!='.')
        {
            ans=backtrack(board, row, col+1);
            return ans;
        }        
        for(int i=1;i<=9;i++)
        {
            int val='0';
            board[row][col]=(char)(val+i);
            if(placementIsPossible(board, board[row][col], row, col))
            {
                ans=backtrack(board, row, col+1);
                if(ans==true)
                    return ans;
            }
        }
        board[row][col]='.';
        return ans;        
    }
    
    public boolean placementIsPossible(char[][] board, char ch, int row, int col)
    {
        for(int i=0;i<board[row].length;i++)
        {
            if(i!=col && board[row][i]==ch)
                return false;
        }
        for(int i=0;i<board.length;i++)
        {
            if(i!=row && board[i][col]==ch)
                return false;
        }
        int subgrid_row=(row/3)*3;
        int subgrid_col=(col/3)*3;
        for(int i=subgrid_row;i<subgrid_row+3;i++)
        {
            for(int j=subgrid_col;j<subgrid_col+3;j++)
            {
                if(i!=row && j!=col && board[i][j]==ch)
                    return false;
            }
        }
        return true;        
    }
    
    
    public void solveSudoku(char[][] board) {
        
        backtrack(board, 0, 0);
    }
}