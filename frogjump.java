class Solution {
    public boolean canCross(int[] stones) {
        
        if(stones.length==0 || stones[0]!=0 || stones[1]!=1 || stones==null)
            return false;
        
        for(int i=3;i<stones.length;i++) // Some mathematical logic which gets the job done, otherwise run time error
        {                               // time limit exceeded in some test cases.
            if(stones[i]>stones[i-1] *2)
                return false;
        }
        
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<stones.length;i++)
            set.add(stones[i]);
        Deque<Integer> position=new ArrayDeque<>();
        Deque<Integer> jump=new ArrayDeque<>();
        
        position.push(1);
        jump.push(1);
        while(!position.isEmpty())
        {
            int pos=position.pop();
            int distance=jump.pop();
            for(int i=distance-1;i<=distance+1;i++)
            {
                if(i<=0)
                    continue;
                else if(pos==stones[stones.length-1])
                    return true;
                else if(set.contains(pos+i))
                {
                    position.push(pos+i);
                    jump.push(i);
                }
            }
        }        
        return false;
    }
}




/*Alternative approach but gives a run time error Time limit exceeded*/




class Solution {
    
    boolean ans=false;
    Set<Integer> set;
    
    public void check(int[] stones, int pos, int k)
    {  
        if(pos==stones[stones.length-1])
        {
            ans=true;
            return;
        }
        if(ans!=true)
        {
            if((k-1!=0) && set.contains(pos+k-1))
                check(stones,pos+k-1,k-1);
        }
        if(ans!=true)
        {
            if(set.contains(pos+k))
                check(stones,pos+k,k);
        }
        if(ans!=true)
        {
            if(set.contains(pos+k+1))
                check(stones,pos+k+1,k+1);
        }
    }
    
    public boolean canCross(int[] stones) {
        
        if(stones==null||stones.length==0||stones[0]!=0||stones[1]!=1)
            return false;
        for(int i=3;i<stones.length;i++)
        {
            if(stones[i]>stones[i-1] *2)
                return false;
        }
        set=new HashSet<>();
        for(int i=0;i<stones.length;i++)
            set.add(stones[i]);
        check(stones, 1, 1);
        return ans;
        
    }
}