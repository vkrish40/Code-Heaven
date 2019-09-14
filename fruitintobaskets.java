class Solution {
    public int totalFruit(int[] tree) {
        
        Map<Integer,Integer> map=new HashMap<>();
        int pos=0;
        int dist=0;
        int prev=Integer.MIN_VALUE;
        int max=Integer.MIN_VALUE;
        
        for(int i=0;i<tree.length;i++)
        {
            if(!map.containsKey(tree[i]) && map.size()<2)
            {
                map.put(tree[i],i);
                prev=tree[i];
            }
            else if(!map.containsKey(tree[i]) && map.size()==2)
            {
                dist=i-pos;
                max=max>dist?max:dist;
                pos=map.get(prev);
                i=pos-1;
                map.clear();
            }
            else if(map.containsKey(tree[i]) && tree[i]!=prev)
            {
                map.put(tree[i],i);
                prev=tree[i];
            }
        }
        
        dist=tree.length-pos;
        max=max>dist?max:dist;
        
        return max;
        
    }
}