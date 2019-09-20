class Solution {
    
    LinkedList<String> ans;
    Map<String,Queue> map;
    
    public void dfs(String str)
    {
        Queue<String> queue=map.get(str);
        while(queue!=null && !queue.isEmpty())
        {
            dfs(queue.poll());
        }
        ans.addFirst(str);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        
        if(tickets==null || tickets.size()==0)
            return new ArrayList<>();
        
        map=new HashMap<>();
        ans = new LinkedList<>();
        for(int i=0;i<tickets.size();i++)
        {
            List<String> list=tickets.get(i);
            Queue<String> queue=map.getOrDefault(list.get(0), new PriorityQueue<>());
            queue.offer(list.get(1));
            map.put(list.get(0),queue);
        }
        dfs("JFK");        
        return ans;
    }
}