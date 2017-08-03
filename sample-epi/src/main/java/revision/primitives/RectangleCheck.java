package revision.primitives;

import java.util.*;

public class RectangleCheck {
	

public boolean isRectangle(List<Point> rectPoints) {
	if (rectPoints == null || rectPoints.isEmpty())
		return Boolean.FALSE;
	Set<Point> rectSet = new TreeSet<>(rectPoints);
	if (rectSet.size() < 4)
		return Boolean.FALSE;
	rectPoints.clear();
	rectPoints.addAll(rectSet);

	System.out.println(rectPoints.get(0).x +"::"+ rectPoints.get(0).y);
	System.out.println(rectPoints.get(1).x +"::"+ rectPoints.get(1).y);

	System.out.println(rectPoints.get(2).x +"::"+ rectPoints.get(2).y);
	System.out.println(rectPoints.get(3).x +"::"+ rectPoints.get(3).y);

	if (rectPoints.get(0).x != rectPoints.get(1).x || rectPoints.get(2).x != rectPoints.get(3).x) {
	
		return Boolean.FALSE;
	}
	if (rectPoints.get(0).y != rectPoints.get(2).y || rectPoints.get(1).y != rectPoints.get(3).y) {
		System.out.println("Y is not equal");
		return Boolean.FALSE;
	}

	return Boolean.TRUE;

}

public static void main(String[] argv) {

	List<Point> rect1 = new  ArrayList<>();
	rect1.add(new Point (1,1));
	rect1.add(new Point (1,6));
	rect1.add(new Point (5,1));
	rect1.add(new Point (5,6));
	
	RectangleCheck rc = new RectangleCheck();
	System.out.println("Is Rectangle::"+rc.isRectangle(rect1));
	rect1 = new  ArrayList<>();
	rect1.add(new Point (1,1));
	rect1.add(new Point (1,1));
	rect1.add(new Point (1,1));
	rect1.add(new Point (1,1));

	System.out.println("Is Rectangle::"+rc.isRectangle(rect1));
}


}

class Point implements Comparable<Point>{
	

	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int compareTo(Point p) {

		if (this.x != p.x) {
			return Integer.compare(this.x, p.x);
		} else {
			return Integer.compare(this.y,p.y);
		}
	}


	public boolean equals(Object o) {
		if (o == null || !(o instanceof Point))
			return Boolean.FALSE;

		Point p = (Point)o;
		return this.x==p.x && this.y==p.y;
	}

	public int hashcode() {

		return Objects.hash(this.x,this.y);
	}
}