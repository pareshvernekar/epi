package revision.stacks;

import java.util.*;

public class SunsetView {


	public Deque<Building> 	hasView(List<Building> buildingList) {

		if (buildingList == null || buildingList.isEmpty())
			return null;
		Deque<Building> stack = new LinkedList<>();
		for (Building b:buildingList) {
			if (stack.isEmpty()) {
				stack.addFirst(b);
			} else {
				if (b.height >= stack.peekFirst().height) {
					while (!stack.isEmpty() && b.height >= stack.peekFirst().height) {
						stack.removeFirst();
					}
				}
				stack.addFirst(b);
 			}
		}
		return stack;
	}

	public static void main(String[] argv) {
		int[] height = {100,20,30,80,40,50,60,90,20};
		SunsetView sv = new SunsetView();
		List<Building> buildingList = createBuildingList(height);
		Deque<Building> views = sv.hasView(buildingList);
		for (Building b:views) {
			System.out.print(b.name+"::"+b.height);
			System.out.print("\t");
		}
		System.out.println();

	}
	private static List<Building> createBuildingList(int[] height) {
		List<Building> buildingList = new LinkedList<>();
		for (int i=0;i<height.length;i++) {
			buildingList.add(new Building("b"+i,height[i]));
		}
		return buildingList;
	}
}

class Building {

	String name;
	int height;
	public Building(String name, int height) {
		this.name = name;
		this.height = height;
	}
	public boolean equals(Object o) {
		if (o == null || !(o instanceof Building))
			return Boolean.FALSE;
		Building b1 = (Building)o;
		return this.name.equals(b1.name);
	}

	public int hashCode() {
		return name.hashCode();
	}
}