class ColorTv extends Tv {
	protected int color;
	

	public ColorTv(int size, int color) {
		super(size);
		this.color=color;
	}
	
	
	public void printProperty() {
		System.out.println(getSize()+"��ġ "+color+"�÷�");
	}
}
