class Solution {
    
    Map<Integer,List<Integer>> map;
    int[] order;
    Set<Integer> visited;
    Set<Integer> parent;
    int counter;
    boolean global;
    public void dfs(int val)
    {
        if(!map.containsKey(val))
        {
            order[counter]=val;
            visited.add(val);
            counter++;
            return;
        }
        List<Integer> temp=map.get(val);
        Iterator<Integer> itr=temp.iterator();
        while(itr.hasNext() && global==true)
        {
            int value=itr.next();
            if(!visited.contains(value) && !parent.contains(value))
            {
                parent.add(value);
                dfs(value);
                parent.remove(value);
            }                
            if(parent.contains(value))
            {
                global=false;
                return;
            }
        }
        if(global==false)
            return;
        visited.add(val);
        order[counter]=val;
        counter++;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        order=new int[numCourses];        
        if(prerequisites.length==0)
        {
            for(int i=0;i<numCourses;i++)
                order[i]=i;
            return order;
        }
        
        map=new HashMap<>();
        visited=new HashSet<>();
        parent=new HashSet<>();        
        counter=0;
        global=true;
        
        for(int i=0;i<prerequisites.length;i++)
        {
            List<Integer> list=map.getOrDefault(prerequisites[i][0], new ArrayList<>());
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], list);
        }
        Set<Integer> keys=map.keySet();
        Iterator<Integer> itr=keys.iterator();
        while(itr.hasNext())
        {
            int val=itr.next();
            if(!visited.contains(val))
            {
                parent.add(val);
                dfs(val);
                parent.remove(val);
            }
                
            if(global==false)
                return new int[]{}; 
        }
        int flag=0;
        if(counter!=numCourses)
        {
            int index=counter;
            while(index<numCourses)
            {
                if(!visited.contains(flag))
                {
                    order[index]=flag;
                    index++;
                }   
                flag++;
            }
       }
        return order;
        
    }
}