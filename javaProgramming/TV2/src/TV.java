public class TV {
private int size;
private String manufacturer;
public TV() {
	size = 32;
	manufacturer = "LG";
	System.out.println(size+"인치 "+manufacturer);
}
public TV(String manufacturer) {
	size=32;
	this.manufacturer=manufacturer;
	System.out.println(size+"인치 "+manufacturer);
}
public TV(int size, String manufacturer) {
	this(manufacturer);
	this.size=size;
	System.out.println(size+"인치 "+manufacturer);}

public static void main(String []args) {
	TV tv= new TV();
	TV tv1= new TV(65, "삼성");
}
}
