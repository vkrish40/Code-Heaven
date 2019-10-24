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

/* Alternate approach */

class Solution {
    public int totalFruit(int[] tree) {
        
        Map<Integer,Integer> map = new HashMap<>();
        
        int left=0;
        int right=0;
        int max = Integer.MIN_VALUE;
        
        while(right<tree.length)
        {
            if(map.size()<2 && !map.containsKey(tree[right]))
            {
                map.put(tree[right],1);
                right++;
            }
            else if(map.containsKey(tree[right]))
            {
                int val = map.get(tree[right])+1;
                map.put(tree[right],val);
                right++;
            }
            else
            {
                max = max>(right-left)?max:right-left;
                int val = map.get(tree[left])-1;
                if(val==0)
                    map.remove(tree[left]);
                else
                    map.put(tree[left],val);
                left++;                
            }
        }
        max = max>(right-left)?max:right-left;
        
        return max;
        
    }
}

