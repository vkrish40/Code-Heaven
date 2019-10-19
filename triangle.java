/*Constant space O(1) solution*/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle==null || triangle.size()==0)
            return 0;
        
        int min=Integer.MAX_VALUE;
        
        List<Integer> comp=triangle.get(0);   
        
        for(int i=1;i<triangle.size();i++)
        {
            List<Integer> temp=triangle.get(i);
            
            for(int j=0;j<temp.size();j++)
            {
                int val=temp.get(j);
                
                if(j-1>=0 && j<comp.size())
                    val+=Math.min(comp.get(j),comp.get(j-1));
                else if(j>=comp.size())
                    val+=comp.get(j-1);
                else
                    val+=comp.get(j);
                
                temp.set(j,val);
            }
            
            comp=temp;            
        }
        
        for(int i=0;i<comp.size();i++)
            min=min>comp.get(i)?comp.get(i):min;
        return min;
    }
}