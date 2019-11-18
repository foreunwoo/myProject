class ColorPoint extends Point{
private String color;

public ColorPoint() {
   this(0, 0);
   this.setColor("BLACK");
}

public ColorPoint(int x, int y) {
	super(x,y);
	
}

public void setXY(int x, int y) {
	move(x,y);
	
}

public void setColor(String color) {
	this.color=color;
	 
}

public String toString() {
	return color+"색의 ("+getX()+","+getY()+")의 점";
}

public static void main(String[] args) {
	ColorPoint zeroPoint = new ColorPoint();
	System.out.println(zeroPoint.toString()+"입니다. ");
	
	ColorPoint cp = new ColorPoint(10,10);
	cp.setXY(5,5);
	cp.setColor("RED");
	System.out.println(cp.toString()+"입니다. ");
}


}
