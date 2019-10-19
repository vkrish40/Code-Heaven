class Solution {
    
    List<List<String>> ans;
    
    //public boolean isValidPlacement(List<String> currentList, int row, int col)
    public boolean isValidPlacement(List<Integer> currentList, int row, int col)
    {
        for(int i=0;i<row;i++)
        {
            //int col_check = Integer.parseInt(currentList.get(i));
            int col_check = currentList.get(i);
            if(col == col_check)
                return false;
            int dist = Math.abs(col-col_check);
            if(dist == row-i)
                return false;
        }
        return true;
    }
    
    //public void buildNQueen(int row, int n, List<String> currentList)
    public void buildNQueen(int row, int n, List<Integer> currentList)
    {
        if(row==n)
        {
            //ans.add(new ArrayList<>(currentList));
            List<String> list = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String temp = "";
                for(int j=0;j<n;j++)
                {
                    if(j == currentList.get(i))
                    {
                        temp+="Q";
                        continue;
                    }
                    temp+=".";
                }
                    list.add(temp);
            }
            ans.add(list);
            return;
        }
        
        for(int col=0;col<n;col++)
        {
            if(isValidPlacement(currentList, row, col))
            {
                //currentList.add(""+col);
                currentList.add(col);
                buildNQueen(row+1, n, currentList);
                currentList.remove(currentList.size()-1);
            }
        }
    }
    
    public List<List<String>> solveNQueens(int n) {
        
        if(n==0)
            return Arrays.asList();
        
        ans = new ArrayList<>();
        
        buildNQueen(0, n, new ArrayList<>());
        
        return ans;
      
        
    }
}