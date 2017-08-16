package revision.sort;

import java.util.*;

public class IntervalMerge {
	

	public List<Interval> merge(List<Interval> intervalList,Interval interval) {
		if (intervalList==null || intervalList.isEmpty() || interval==null)
			return intervalList;

		List<Interval> results = new ArrayList<>();
		int i = 0;
		int len = intervalList.size();
		while (i < len && interval.left > intervalList.get(i).right) {
			results.add(intervalList.get(i++));
		}

		while (i < len && 
						 	interval.right >= intervalList.get(i).left) {
			interval=new Interval(Math.min(interval.left, intervalList.get(i).left),
				Math.max(interval.right,intervalList.get(i).right));
			i++;
		}
		results.add(interval);
		while (i < len) {
			results.add(intervalList.get(i++));
		}

		return results;
	}

	public static void main(String[] argv) {

		List<Interval> input = new ArrayList<>();
		input.add(new Interval(-4,-1));
		input.add(new Interval(0,2));
		input.add(new Interval(3,6));
		input.add(new Interval(7,9));
		input.add(new Interval(11,12));
		input.add(new Interval(14,17));
		IntervalMerge im = new IntervalMerge();
		List<Interval> results = im.merge(input,new Interval(1,8));
		for (Interval i:results) {
			System.out.println(i.left+"::"+i.right);
		}

	}
}

class Interval {
	int left;
	int right;
	public Interval(int start, int end) {
		this.left=start;
		this.right = end;
	}
}