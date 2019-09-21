class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        if(triangle==null || triangle.size()==0)
            return 0;
        List<List<Integer>> list=new ArrayList<>();
        
        list.add(triangle.get(0));
    
        
        for(int i=1;i<triangle.size();i++)
        {
            List<Integer> temp=triangle.get(i);
            List<Integer> comp=list.get(i-1);
            List<Integer> coll=new ArrayList<>();
            for(int j=0;j<temp.size();j++)
            {
                int val=temp.get(j);
                if(j-1>=0 && j<comp.size())
                    val+=Math.min(comp.get(j),comp.get(j-1));
                else if(j>=comp.size())
                    val+=comp.get(j-1);
                else
                    val+=comp.get(j);
                coll.add(val);                      
            }
            list.add(coll);
        }
        List<Integer> temp=list.get(list.size()-1);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<temp.size();i++)
            min=min>temp.get(i)?temp.get(i):min;
        return min;
    }
}