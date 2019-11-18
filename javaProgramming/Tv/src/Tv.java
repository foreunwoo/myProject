class Tv {
int size;
public Tv(int size) { this.size=size; }
protected int getSize() { return size; }

	public static void main(String[] args) {
		ColorTv myTv=new ColorTv(32, 1024);
myTv.printProperty();
	}

}
