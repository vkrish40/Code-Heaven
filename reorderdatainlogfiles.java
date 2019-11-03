class Solution {
    public String[] reorderLogFiles(String[] logs) {
        
        List<String> list = new ArrayList<>(); 
        List<String> numb = new ArrayList<>(); 
                
        for(int i=0;i<logs.length;i++)
        {
            int index = logs[i].indexOf(' ');
            int val = logs[i].charAt(index+1);
            if(val>=97)
            {
                list.add(logs[i]);
            }
            else
                numb.add(logs[i]);
        }
        
        Collections.sort(list, new Comparator<String>()
                         {
                             public int compare(String a, String b)
                             {
                                 int index1 = a.indexOf(' ');
                                 int index2 = b.indexOf(' ');
                                 int val = a.substring(index1+1).compareTo(b.substring(index2+1));
                                 if(val==0)
                                     return a.compareTo(b);
                                 else 
                                     return val;                                 
                             }
                         });
        
        String[] ans = new String[logs.length];
        for(int i=0;i<list.size();i++)
            ans[i] = list.get(i);
        int flag = 0;
        for(int i=list.size();i<ans.length;i++)
        {
            ans[i] = numb.get(flag);
            flag++;
        }
        return ans;
        
    }
}