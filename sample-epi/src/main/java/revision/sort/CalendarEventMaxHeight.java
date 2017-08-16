package revision.sort;

import java.util.*;


public class CalendarEventMaxHeight {
	
	public int maxEventHeight(List<Event> events) {

		Collections.sort(events, new Comparator<Event>() {
				public int compare(Event e1,Event e2) {
					
					if (e1.startTime < e2.startTime)
						return -1;
					else if (e1.startTime > e2.startTime)
						return 1;	
					else {
						if (e1.endTime > e2.endTime)
							return -1;
						else if (e1.endTime==e2.endTime)
							return 0;
						else
							return 1;
					}
 
				}
		});

		int max = 0;
		Deque<Event> stack = new LinkedList<>();
		for (Event e:events) {
			if (stack.isEmpty()) {
				stack.addFirst(e);
				max = 1;
			} else {
				while (e.startTime >= stack.peek().endTime) {
					stack.removeFirst();
				}
				stack.addFirst(e);
				max=Math.max(stack.size(),max);
			}

		}
		return max;
	}

	public static void main(String[] argv) {
		CalendarEventMaxHeight cemh  = new CalendarEventMaxHeight();
		List<Event> events = new ArrayList<>();
		events.add(new Event(1,5));
		events.add(new Event(6,10));
		events.add(new Event(11,13));
		events.add(new Event(14,15));
		events.add(new Event(2,7));
		events.add(new Event(8,9));
		events.add(new Event(12,15));
		events.add(new Event(4,5));
		events.add(new Event(9,17));
		System.out.println(cemh.maxEventHeight(events));
	}
}

class Event {
	
	int startTime;
	int endTime;
	public Event(int startTime, int endTime) {
		this.startTime = startTime;
		this.endTime = endTime;
	}
}