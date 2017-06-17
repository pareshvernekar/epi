package sample.epi.bruteforce;

import java.util.*;
public class RectangleConstruct {

	public static boolean isRectangle(Point[] pointArr) {
		Arrays.sort(pointArr);
		if ((pointArr[0].x != pointArr[1].x)
			|| (pointArr[2].x != pointArr[2].x))
			return Boolean.FALSE;
		if ((pointArr[0].y != pointArr[2].y)
			|| (pointArr[1].y != pointArr[3].y))
			return Boolean.FALSE;
		if ((pointArr[0].x == pointArr[1].x && pointArr[2].x==pointArr[3].x
			&& pointArr[1].x==pointArr[2].x)
			||
			(pointArr[0].y == pointArr[1].y && pointArr[2].y==pointArr[3].y
			&& pointArr[1].y==pointArr[2].y)
			)
			return Boolean.FALSE;
		return Boolean.TRUE;
	}

	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N =4;
		Point[] pointArr = new Point[4];
		Point point = null;
		while (N > 0) {
			point = new Point(scanner.nextInt(), scanner.nextInt());
			N-=1;
			pointArr[N] = point;
		}
		System.out.println("Is Rectangle:"+isRectangle(pointArr));
	}
}

class Point implements Comparable{
	int x;
	int y;

	Point(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public int compareTo(Object other) {

		if (other==null || !(other instanceof Point))
			return -1;
		Point temp = (Point)other;
		if (this.x==temp.x && this.y==temp.y)
			return 0;

		if (this.x < temp.x)
			return -1;
		if (this.x==temp.x && this.y < temp.y)
			return -1;
		return 1;
	}
}