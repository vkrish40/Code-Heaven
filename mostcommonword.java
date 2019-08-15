class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        
        int high=0;
        paragraph.trim();
        paragraph = paragraph + ".";
        List<String> list=Arrays.asList(banned);
        String temp="", best="";
        Map<String,Integer> map=new HashMap<>();
        
        /*for(int i=0;i<paragraph.length();i++)
        {
            if(paragraph.charAt(i)!='!' || paragraph.charAt(i)!='?' || paragraph.charAt(i)!='\'' || paragraph.charAt(i)!=',' || paragraph.charAt(i)!=';' || paragraph.charAt(i)!='.')
               {
                   start=i;
                   break;
               }
        }*/
        for(int i=0;i<paragraph.length();i++)
        {
            if(paragraph.charAt(i)=='!' || paragraph.charAt(i)=='?' || paragraph.charAt(i)=='\'' || paragraph.charAt(i)==',' || paragraph.charAt(i)==';' || paragraph.charAt(i)=='.' || paragraph.charAt(i)==' ')
            {
                if(temp.length()!=0)
                {
                    temp=temp.toLowerCase();
                    if(map.containsKey(temp))
                    {
                        map.put(new String(temp),map.get(temp)+1);
                    }
                    else
                    {
                        map.put(temp,1);
                    }
                    if(!list.contains(temp))
                    {
                        best=map.get(temp)>high?temp:best;
                        high=map.get(temp)>high?map.get(temp):high;
                    }                      
                    temp="";
                }
                continue;
            }
            temp=temp+paragraph.charAt(i);
        }
        return best;
        
    }
}