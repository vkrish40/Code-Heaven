class Solution {
    public void rotate(int[][] matrix) {
        int swap;
        int temp=matrix.length-1;
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=i;j<matrix.length;j++)
            {
                swap=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=swap;
            }
        }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix.length/2;j++)
            {
                swap=matrix[i][temp];
                matrix[i][temp]=matrix[i][j];
                matrix[i][j]=swap;
                temp--;
            }
            temp=matrix.length-1;
        }
    }
}