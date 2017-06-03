package sample.epi.bruteforce;

import java.util.*;

public class RectangleIntersect {
	
	static void checkIntersect(Rectangle[] rectangles) {

		int size = rectangles.length;
		for(int i=0;i<size-1;i++) {
			for (int j=i+1;j<size;j++) {
				System.out.println(" Do Intersect :"+rectangles[i].toString()
					+" and "+rectangles[j].toString()+" "
					+doIntersect(rectangles[i],rectangles[j]));
			}
		}
	}

	static boolean doIntersect(Rectangle rect1, Rectangle rect2) {
		if (rect1 == null || rect2 == null)
			throw new IllegalArgumentException();
		if ( (rect2.x >= rect1.x && rect2.x <= rect1.x+rect1.width
			&& rect2.y >= rect1.y && rect2.y <= rect1.y+rect1.height) ||
			(rect1.x >= rect2.x && rect1.x <= rect2.x+rect2.width
			&& rect1.y >= rect2.y && rect1.y <= rect2.y+rect2.height)
			)
			return true;
		else
			return false;
	}
	public static void main(String[] argv) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();		//number of rectangles
		Rectangle[] rectangles = new Rectangle[N];
		int count = 0;
		int xcoord = 0;
		int ycoord = 0;
		int height = 0;
		int width = 0;
		Rectangle rectangle = null;
		while (count < N) {

			xcoord = scanner.nextInt();
			ycoord = scanner.nextInt();
			height = scanner.nextInt();
			width = scanner.nextInt();
			rectangle = new Rectangle(xcoord,ycoord,height,width);
			rectangles[count++] = rectangle;
		}
		checkIntersect(rectangles);
		scanner.close();
	}


}


class Rectangle {
	
	int x;
	int y;
	int height;
	int width;

	Rectangle(int x, int y, int height, int width) {
			this.x=x;
			this.y=y;
			this.height=height;
			this.width=width;
	}

	public String toString() {
		return "{"+ this.x+" "+this.y + " "+this.height+" "+this.width+"}";
	}


}