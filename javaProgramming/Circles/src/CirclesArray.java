public class CirclesArray {

	public static void main(String[] args) {
	Circles [] c;
	c= new Circles [5];
	
	for(int i=0; i<c.length; i++)
		c[i]=new Circles(i);
	
	for(int i=0; i<c.length; i++)
		
		System.out.print((int)(c[i].getArea())+" ");
	
	}

}
