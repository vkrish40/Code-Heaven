class Solution {
    public List<String> add(String sub)
    {
        List<String> list=new ArrayList<>();
        list.add(sub);
        return list;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        char arr[];
        String elem;
        List<String> templist;
        List<List<String>> res=new ArrayList<>();
        Map<String,List<String>> map=new HashMap<>(strs.length);
        for(int i=0;i<strs.length;i++)
        {
            arr=strs[i].toCharArray();
            Arrays.sort(arr);
            elem=Arrays.toString(arr);
            if(map.containsKey(elem))
            {
                templist=map.get(elem);
                templist.add(strs[i]);
            }
            else
                map.put(elem,add(strs[i]));
        }
        res.addAll(map.values());
        return res;        
    }
}