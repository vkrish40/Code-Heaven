class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix==null || matrix.length==0)
            return false;
        int start_index = 0;
        int end_index = (matrix.length * matrix[0].length)-1;
        
        while(start_index<=end_index)
        {
            int middle=(start_index + end_index)/2;
            
            int i_map = middle/matrix[0].length;
            int j_map = middle%matrix[0].length;
            
            if(matrix[i_map][j_map]==target)
                return true;
            else if(matrix[i_map][j_map]<target)
                start_index=middle+1;
            else
                end_index=middle-1;
        }
        
        return false;
        
    }
}