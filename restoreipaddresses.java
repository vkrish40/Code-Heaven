class Solution {
    
    List<String> ans;
    
    public void build(String s, List<Integer> current_list, int start_index, int segment)
    {
        if(segment==4 && start_index==s.length())
        {
            String temp = current_list.get(0) + "." + current_list.get(1) + "." + current_list.get(2) + "." + current_list.get(3);
            ans.add(temp);
            return;
        }
        else if(segment==4 || start_index==s.length())
            return;
        for(int i=1;i<=3;i++)
        {
            if((start_index+i)>s.length())
                break;
            int val = Integer.parseInt(s.substring(start_index, start_index+i));
            String check = ""+val;
            if(val>255 || check.length()!=i)
                continue;
            current_list.add(val);
            build(s, current_list, start_index+i, segment+1);
            current_list.remove(current_list.size()-1);            
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        
        if(s==null || s.length()==0)
            return Arrays.asList();
        
        ans = new ArrayList<>();
        
        build(s, new ArrayList<>(), 0, 0);
        
        return ans;   
    }
}