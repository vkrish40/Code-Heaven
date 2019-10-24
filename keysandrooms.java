class Solution {
    
    Set<Integer> set;
    public void room_check(List<List<Integer>> rooms, int apt)
    {
        List<Integer> list = rooms.get(apt);
        for(int i=0;i<list.size();i++)
        {
            if(!set.contains(list.get(i)))
            {
                set.add(list.get(i));
                room_check(rooms,list.get(i));                    
            }            
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        
        if(rooms==null || rooms.size()==0)
            return false;
        
        set = new HashSet<>();
        set.add(0);
        room_check(rooms,0);
        
        return set.size()==rooms.size();
        
    }
}