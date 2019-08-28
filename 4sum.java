/*O(n to the power 3) time complexity, passes all the test cases*/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        
        Arrays.sort(nums);
        
        int left,right,sum;
        
        for(int i=0;i<nums.length-3;i++)
        {
            for(int j=i+1;j<nums.length-2;j++)
            {
                left=j+1;
                right=nums.length-1;
                while(left<right)
                {
                    sum=nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target)
                    {
                        if(!ans.contains(Arrays.asList(nums[i],nums[j],nums[left],nums[right])))
                            ans.add(Arrays.asList(nums[i],nums[j],nums[left],nums[right]));
                        left++;
                        right--;
                    }
                    else if(sum<target)
                    {
                        left++;
                    }
                    else
                    {
                        right--;
                    }
                }
            }
        }
        
        return ans;
        
    }
}


/* Alternate solution
	passes 281/282 test cases, gives runtime error for the 282nd test case 


class Solution {
    
    public void find_combinations(int[] nums, int target,int currsum, int index, List<Integer> current, List<List<Integer>> ans, int count)
    {
        if(currsum==target && count==4)
        {
            ans.add(new ArrayList<>(current));
            return;
        }
        else if(count==4)
        {
            return;
        }
        for(int i=index;i<nums.length;i++)
        {
            if((i==index || nums[i]!=nums[i-1]) && (4-count)<=nums.length-i)
            {
                current.add(nums[i]);
                find_combinations(nums, target, currsum+nums[i], i+1, current, ans, count+1);
                current.remove(current.size()-1);
            }
        }
    }
    
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        find_combinations(nums, target, 0, 0, new ArrayList<>(), ans, 0);
        
        return ans;
    }
}

*/
