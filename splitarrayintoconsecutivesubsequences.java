class Solution {
    public boolean isPossible(int[] nums) {
        
        if(nums.length<3 || nums==null)
            return false;
        
        Map<Integer,Queue<Integer>> map=new HashMap<>();
        
        map.put(nums[0],new PriorityQueue<>(Arrays.asList(1)));
        
        for(int i=1;i<nums.length;i++)
        {
            Queue<Integer> queue=map.get(nums[i]-1);
            Integer a=0;
            if(queue!=null)
                a=queue.poll();
            Queue<Integer> current=map.getOrDefault(nums[i],new PriorityQueue<>());
            if(queue==null || a==null)
            {
                current.offer(1);
            }
            else
            {
                current.offer(a+1);
            }
            map.put(nums[i],current);              
        }
        
        for(int i=0;i<nums.length;i++)
        {
            Queue<Integer> check=map.get(nums[i]);
            if(check.size()==0)
                continue;
            while(!check.isEmpty())
            {
                int temp=check.poll();
                if(temp<3)
                    return false;
            }   
        }
        return true;        
    }
}

    
    
    
    
    
    
    
    
    
    
    