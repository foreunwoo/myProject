public class Circle {
	private int x;
	private int y;
	private int radius;
	
	public Circle(int x, int y, int radius) { //�����ڷ� 3���� ���ڸ� �޾� �ʵ� �ʱ�ȭ
		this.x=x;
		this.y=y;
		this.radius=radius;
	}
	
	public String toString() { //Circle ��ü�� ���ڿ��� �����ϴ� toString() �ۼ�
		return "Circle("+x+","+y+")������"+radius;}
	
	public boolean equals(Object obj) { //equals() �������̵� -> ��ĳ����
		Circle c = (Circle)obj; // ��ü obj�� Circle Ÿ������ �ٿ� ĳ����
		if(this.x==c.x && this.y==c.y) return true;
		else return false;
	 }

	public static void main(String[] args) {
		Circle a = new Circle(2,3,5); //�߽� (2,3)�� ������ 5�� ��
		Circle b = new Circle(2,3,30); //�߽� (2,3)�� ������ 30�� ��
		System.out.println("�� a : " +a); //toString �������̵�
		System.out.println("�� b : " +b); //toString �������̵�
		
		if(a.equals(b)) //true
			System.out.println("���� ��");
		else //false
			System.out.println("���� �ٸ� ��");

	}

}
