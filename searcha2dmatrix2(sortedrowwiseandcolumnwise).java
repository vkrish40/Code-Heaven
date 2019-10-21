class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null || matrix.length==0)
            return false;
        int x_start = matrix.length-1;
        int y=0;
        
        while(x_start>=0 && y<matrix[0].length)
        {
            if(matrix[x_start][y]==target)
                return true;
            else if(matrix[x_start][y]<target)
                y++;
            else
                x_start--;
        }
        
        return false;
        
        
    }
}