class Rect implements Shape { //Shape �������̽��� ����� �߻� �޼ҵ� ������
	private int width; //����
	private int height; //����
 	public Rect(int width, int height) { this.width=width; this.height=height; } //Rect Ŭ���� ������
	
	public void redraw() { //����Ʈ �޼ҵ�
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw();
}
	@Override
	public void draw() { //������ �׸��� �޼ҵ�
		System.out.println(width+"x"+height+"ũ���� �簢�� �Դϴ�."); 
		
	}
	@Override
	public double getArea() { //������ ������ �����ϴ� �޼ҵ�
		return width*height;
	}
}
