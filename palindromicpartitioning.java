class Solution {
    
    List<List<String>> ans;
    
    public boolean isPalindrome(String s, int left, int right)
    {
        while(left<=right)
        {
            if(s.charAt(left)!=s.charAt(right))
                return false;
            left++;
            right--;
        }
        
        return true;
    }
    
    public void build(String s, int start, List<String> current_list)
    {
        if(start>=s.length())
        {
            ans.add(new ArrayList<>(current_list));
            return;
        }
        
        int left = start;
        for(int i=start;i<s.length();i++)
        {
            if(isPalindrome(s, left,i))
            {
                current_list.add(s.substring(left,i+1));
                build(s, i+1, current_list);
                current_list.remove(current_list.size()-1);                
            }
            
        }
    }
    
    public List<List<String>> partition(String s) {
        
        if(s==null || s.length()==0)
            return Arrays.asList();
        ans = new ArrayList<>();
        build(s, 0, new ArrayList<>()); 
        
        return ans;
    }
}