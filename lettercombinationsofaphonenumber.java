class Solution {
    
    List<String> list=new ArrayList<>();
    Map<Character,String> map=new HashMap<>();

    public void add(String total, String digit)
    {
        if(digit.length()==0)
        {
            list.add(total);
        }
        else
        {
            String temp=map.get(digit.charAt(0));
            for(int i=0;i<temp.length();i++)
            {
                add(total+temp.charAt(i),digit.substring(1));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        
        if(digits.length()==0)
            return list;
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        add("",digits);        
        return list;           
    }
}