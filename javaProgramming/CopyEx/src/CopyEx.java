import java.io.*;

public class CopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\a.jpg");
		File dest = new File("c:\\Temp\\b.jpg");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dest);
			
			System.out.println(src.getName()+"�� "+dest.getName()+"�� �����մϴ�.");
			System.out.println("10%���� *�� ����մϴ�.");
			
			int c;
			int count=0;
			int per = (int)src.length()/10; //10�ۼ�Ʈ
			int total = per; //10, 20, 30,... 100�ۼ�Ʈ�� ������ ����
			
			while((c=fis.read()) != -1) {
				fos.write(c);
				count++;
				if(count==total) {
					System.out.print("*"); //10�ۼ�Ʈ���� *�� ���
					total += per;
				}
			}
			fis.close();
			fos.close();
			System.out.println("�Ϸ�.");
			
		}catch(FileNotFoundException e) {
			System.out.print("���� ã�� ����");
		}catch(IOException e) {
			System.out.print("���� ���� ����");
		}
	}
}
