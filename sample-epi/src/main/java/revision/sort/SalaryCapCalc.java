package revision.sort;

import java.util.*;

public class SalaryCapCalc {
	
	public static void main(String[] argv) {

			double[] d = {90,30,100,40,20};
			double payroll = 210;
			double unadjSal = 0.0;
			Arrays.sort(d);
			for (int i=0;i<d.length;i++) {
				double adjSal = d[i]*(d.length-i);
				if (unadjSal+adjSal >= payroll ) {
					System.out.println("Cap:"+((payroll-unadjSal)/(d.length-i)));
					break;
				}
				unadjSal+=d[i];
			}
	}
}