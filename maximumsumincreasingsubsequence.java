import java.io.*;

public class maximumsumincreasingsubsequence 
{
	public static void main(String[] args)throws IOException
	{
		int[] arr={4,6,1,3,8,4,6};

		int[] sum=new int[arr.length];

		int[] track=new int[arr.length];

		int high=0;
		int index=0;

		for(int i=0;i<arr.length;i++)
		{
			sum[i]=arr[i];
			track[i]=i;
		}

		for(int i=1;i<arr.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(arr[i]>arr[j])
				{
					if((sum[j]+arr[i])>sum[i])
					{
						sum[i]=sum[j]+arr[i];
						track[i]=j;
					}
				}
			}

		}


		for(int i=0;i<arr.length;i++)
		{
			if(high<sum[i])
			{
				high=sum[i];
				index=i;
			}
		}

		System.out.println("Maximum Sum of increasing subsequence is: " + high);

		while(index!=track[index])
		{
			System.out.println("Numbers Contributing to the maximum sum increasing subsequence: " + arr[index]);
			index=track[index];
		}

		System.out.println("Numbers Contributing to the maximum sum increasing subsequence: " + arr[index]);
	}
}