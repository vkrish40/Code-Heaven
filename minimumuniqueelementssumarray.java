import java.util.*;
public class uniqueminsum
{
    public static void main(String[] args)
    {
        int[] arr={10,5,5,3,2,10};
        
        Arrays.sort(arr);
        
        int num = arr[0];
        int sum = arr[0];
        
        for(int i=1;i<arr.length;i++)
        {
            if(arr[i]==arr[i-1])
            {
                if(num<=arr[i])
                    num=arr[i]+1;
                
                for(int j=i+1;j<arr.length;j++)
                {
                    if(arr[j]!=num)
                        continue;
                    num++;
                }
                sum+=num;
                num++;
            }
            else
                sum+=arr[i];
        }
        
        System.out.println("Total Unique Sum = " + sum);
    }
}