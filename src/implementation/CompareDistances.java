/*
 * Programmed by Shephalika Shekhar
 * Comparing one object to another
 */
package implementation;
public class CompareDistances implements Comparable{
	double data;
	String str;
	
	
	public CompareDistances(double d,String s){
		this.data=d;
		this.str=s;
		
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		double compd=((CompareDistances)obj).data;
		
		if(this.data<compd)
			return -1;
		if(this.data>compd)
			return 1;
			
		return 0;
	}
	

}
