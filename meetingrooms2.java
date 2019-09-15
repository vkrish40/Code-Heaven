/**
* Definition for an interval.
* public class Interval{
*	int start;
*	int end;
*	Interval(){ start=0; end=0;}
*	Interval(int s, int) { start = s; end =e; }
* }
*/

Class Solution {
	public int minMeetingRooms(Interval[] intervals) {

		if(intervals==null || intervals.length==0)
			return 0;

		Arrays.sort(intervals, (a, b) -> a.start - b.start); // **look the comment below
		Queue<Interval> queue=new PriorityQueue<>((a, b) -> a.end - b.end);
		queue.offer(intervals[0]);
		for(int i=1;i<intervals.length;i++)
		{
			Interval comp=queue.poll();
			if(intervals[i].start>=comp.end)
				comp.end=intervals[i].end;
			else
				queue.offer(intervals[i]);
			queue.offer(comp);
		}

		return queue.size();	
	}
}

** Reason why we sort by start time and not by end time, Try this example: (1,3),(5,10),(3,9),(13,14),(9,12),(10,14), you will understand.(start time, end time).Both will 
   yield different answers, sorting by start time will yield the least rooms required, hence that approach is correct and also makes sense.	