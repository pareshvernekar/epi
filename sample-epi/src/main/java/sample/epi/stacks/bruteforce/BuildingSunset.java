package sample.epi.stacks.bruteforce;

import java.util.*;

//9.6
public class BuildingSunset {


	public BuildingNode[] sunsetView( BuildingNode[] data) {
		Deque<BuildingNode> buildingStack = new LinkedList();
		if (data == null || data.length==0) {
			throw new IllegalArgumentException("Invalid data");
		}

		int len = data.length;
		int currMax = data[len-1].height;
		buildingStack.addFirst(data[len-1]);
		for (int i=len-2;i>=0;i--) {
			if (data[i].height < currMax) {
				buildingStack.addFirst(data[i]);
			} else {
				currMax = data[i].height;
				while (!buildingStack.isEmpty() && 
					buildingStack.peekFirst().height <= currMax) {
					buildingStack.removeFirst();
				}
				buildingStack.addFirst(data[i]);
			}
		}
		BuildingNode[] result = new BuildingNode[buildingStack.size()];
		for (int i=0;i<result.length;i++) {
			result[i]=buildingStack.removeFirst();
		}
		return result;
	}
	
	public BuildingNode[] init(String[] names, int[] height) {

		if ((names == null || height==null) || 
			(names.length != height.length))
			throw new IllegalArgumentException("Invalid paramter values");

		BuildingNode[] arr = new BuildingNode[names.length];
		for (int i = 0;i<names.length;i++) {
			arr[i]=new BuildingNode(names[i],height[i]);
		}
		return arr;
	}

	public static void main(String[] argv) {
		BuildingSunset bs = new BuildingSunset();
		String[] names = new String[]{"A","B","C","D","E"};
		int[] height = new int[]{50,40,30,20,10};
		BuildingNode[] data = bs.init(names, height);
		BuildingNode[] result = bs.sunsetView(data);
			if (result != null) {
				for (int i=0;i<result.length;i++) {
					System.out.println(" Bldg:"+result[i].name);
				}
			}

			names = new String[]{"A","B","C","D","E"};
			height = new int[]{25,40,30,20,10};
			data = bs.init(names, height);
			result = bs.sunsetView(data);
			if (result != null) {
				for (int i=0;i<result.length;i++) {
					System.out.println(" Bldg:"+result[i].name);
				}
			}

			names = new String[]{"A","B","C","D","E"};
			height = new int[]{25,40,45,20,10};
			data = bs.init(names, height);
			result = bs.sunsetView(data);
			if (result != null) {
				for (int i=0;i<result.length;i++) {
					System.out.println(" Bldg:"+result[i].name);
				}
			}
		}

}

class BuildingNode {
	String name;
	int height;

	public BuildingNode(String name, int height) {
		this.name = name;
		this.height = height;
	}

}