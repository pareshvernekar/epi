package revision.primitives;

public class RectangleOverlap {


	
	public static boolean doOverlap(Coordinates l1, Coordinates r1, Coordinates l2, Coordinates r2){
		// If one rectangle is on left side of other
	    if ((l1.x > r2.x) || (l2.x > r1.x))
	        return false;
	 
	    // If one rectangle is above other
	    if ((l1.y < r2.y )|| (l2.y < r1.y))
	        return false;
	 
	    return true;
	
		
	}

	public static void main(String[] argv) {

		System.out.println(doOverlap(new Coordinates(1,3), new Coordinates(5,1), new Coordinates(3,4), new Coordinates(7,4)));
	}
	
}

class Coordinates{
		int x,y;
		
		Coordinates(int x, int y){
			this.x =x;
			this.y =y;
		}
}