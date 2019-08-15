class Solution { 
    /*public void bfs(char[][] grid, int i, int j)
    {
        int[] temp={i,j};
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(temp);
        while(!queue.isEmpty())
        {
            temp=queue.poll();
            grid[temp[0]][temp[1]]=0;
            if(temp[0]-1>=0 && grid[temp[0]-1][temp[1]]=='1')
                queue.offer(new int[]{temp[0]-1,temp[1]});
            if(temp[0]+1<grid.length && grid[temp[0]+1][temp[1]]=='1')
                queue.offer(new int[]{temp[0]+1,temp[1]});
            if(temp[1]-1>=0 && grid[temp[0]][temp[1]-1]=='1')
                queue.offer(new int[]{temp[0],temp[1]-1});
            if(temp[1]+1<grid[temp[0]].length && grid[temp[0]][temp[1]+1]=='1')
                queue.offer(new int[]{temp[0],temp[1]+1});
            
        }
            
    }*/
    
    /*
        BFS approach throws an error: time limit exceeded    
    */
    
    public void dfs(char[][] grid, int i, int j)
    {
        if(i<0 || j<0 || i>=grid.length || j>=grid[i].length || grid[i][j]=='0')
            return;
        grid[i][j]='0';
        dfs(grid, i-1,j);
        dfs(grid, i+1,j);
        dfs(grid, i,j-1);
        dfs(grid, i,j+1);
        return;     
    }
    
    public int numIslands(char[][] grid) {
        
        if(grid==null || grid.length==0)
            return 0;
        int num_islands=0;
        
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                if(grid[i][j]=='1')
                {
                    num_islands=num_islands+1;
                    //bfs(grid,i,j);
                    dfs(grid,i,j);
                }
            }
        }
        
        return num_islands;
        
    }
}