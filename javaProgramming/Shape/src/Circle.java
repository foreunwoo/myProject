class Circle implements Shape { //Shape �������̽��� ����� �߻� �޼ҵ� ����
	private int radius;
	public Circle(int radius) { this.radius=radius; } //circle Ŭ���� ������
	
	public void redraw() { //����Ʈ �޼ҵ�
		System.out.print("--- �ٽ� �׸��ϴ�. ");
		draw(); }

	@Override
	public void draw() { //������ �׸��� �޼ҵ�
		System.out.println("�������� "+radius+"�� ���Դϴ�.");
	}

	@Override
	public double getArea() 
		{ return radius*radius*PI; } //������ ������ �����ϴ� �޼ҵ�
}
