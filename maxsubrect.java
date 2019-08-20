/*Maximum sum rectangle in a 2D matrix - Kadane's algorithm applications

I am assuming that the two functions that I have created namely kadane(int[] arr) and maxSubRect(int[][]arr) are within some random class. Then, I have created two separate helper classes

namely rectangle and kadaneclass. 

To better understand this solution, I'd highly recommend watching this video: https://www.youtube.com/watch?v=-FgseNO-6Gk&t=57s

This solution is almost cubic in time complexity (I am giving the upper bound: O(columns squared times rows). But better than brute force which is almost O(rows squared times columns squared).

I am also assuming that if the matrix has all negative numbers (or partly/fully zeroes), then the max sum to be 0 since we can return an empty sub matrix signified by all the left, right, top and bottom 

positions to be -1;

*/



class rectangle
{
	int high;
	int left=-1;
	int right=-1;
	int top=-1;
	int bottom=-1;
}



class kadaneclass
{
	int high;
	int start;
	int end;
	public kadaneclass(int high, int start, int end)
	{
		this.high=high;
		this.start=start;
		this.end=end;
	}
}



public kadaneclass kadane(int[] arr)
{
	int sum=0;
	int high=-1;
	int start=0;
	int end=0;
	int fin_start=0;
	
	for(int i=0;i<arr.length;i++)
	{
		sum+=arr[i];
		if(sum<0)
		{
			sum=0;
			start=i+1;
		}
		if(sum>high)
		{
			fin_start=start;
			end=i;
			high=sum;
		}
	}
	
	return new kadaneclass(high,start,end);
} 
			
		
		

public rectangle maxSubRect(int[][] arr)
{
	int[] running_sum=new int[arr.length];
	
	rectangle rect=new rectangle();
	
	for(int i=0;i<arr[0].length;i++)
	{
		for(int j=i;j<arr[0].length;j++)
		{
			for(int k=0;k<running_sum.length;k++)
			{
				running_sum[k]+=arr[k][j];
			}

			kadaneclass obj=kadane(running_sum);
			
			if(obj.high>rectangle.high)
			{
				rect.left=i;
				rect.right=i;
				rect.top=obj.start;
				rect.bottom=obj.end;
				rect.high=obj.high
			}
		}
		for(int k=0;k<running_sum.length;k++)
		{
			running_sum[k]=0;
		}
	}

	return rect;
			
}