class Oval implements Shape { //Shape �������̽��� ����� �߻� �޼ҵ� ����
	private int width; //����
	private int height; //����
	public Oval(int width, int height) { this.width=width; this.height=height; } //Oval Ŭ���� ������
	
	public void redraw() { //����Ʈ �޼ҵ�
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw();
}
	@Override
	public void draw() { //������ �׸��� �޼ҵ�
		System.out.println(width+"x"+height+"�� �����ϴ� Ÿ���Դϴ�.");
		
	}
	@Override
	public double getArea() { //������ ������ �����ϴ� �޼ҵ�
		return width*height*PI; 
	}
}
