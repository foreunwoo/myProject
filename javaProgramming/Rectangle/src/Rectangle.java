 public class Rectangle {
int x, y, width, height; //int Ÿ���� ������� ����

public Rectangle(int x, int y, int width, int height) { //�Ű������� �޾� �ʵ带 �ʱ�ȭ �ϴ� ������
	this.x = x; 
    this.y = y; 
    this.width = width; 
    this.height = height; 
}

public int square() { //�簢�� ���� ����
	return width*height;
}

public void show() { //�簢���� ��ǥ�� ���̸� ȭ�鿡 ���
	System.out.println("("+ x + ","+ y +")"+"���� ũ�Ⱑ "+width+"x"+height+"�� �簢��");
}

public boolean contains(Rectangle r) { //�Ű������� ���� r�� ���ԵǸ� true �����Խ� false ����
	if((r.x>x && r.y>y)&&(r.width<width && r.height<height))
	{ 
		return true; 
  } 
return false; 

}
	
}
