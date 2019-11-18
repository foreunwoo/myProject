import java.io.*;

public class CopyEx {
	public static void main(String[] args) {
		File src = new File("c:\\Temp\\a.jpg");
		File dest = new File("c:\\Temp\\b.jpg");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			FileOutputStream fos = new FileOutputStream(dest);
			
			System.out.println(src.getName()+"을 "+dest.getName()+"로 복사합니다.");
			System.out.println("10%마다 *를 출력합니다.");
			
			int c;
			int count=0;
			int per = (int)src.length()/10; //10퍼센트
			int total = per; //10, 20, 30,... 100퍼센트를 저장할 변수
			
			while((c=fis.read()) != -1) {
				fos.write(c);
				count++;
				if(count==total) {
					System.out.print("*"); //10퍼센트마다 *을 출력
					total += per;
				}
			}
			fis.close();
			fos.close();
			System.out.println("완료.");
			
		}catch(FileNotFoundException e) {
			System.out.print("파일 찾기 실패");
		}catch(IOException e) {
			System.out.print("파일 복사 실패");
		}
	}
}
