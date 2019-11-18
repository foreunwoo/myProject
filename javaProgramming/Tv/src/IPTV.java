class IPTV extends ColorTv{
	private String ip;
	
	
	public IPTV(String ip, int size, int color) {
		
		super(size, color);
		this.ip=ip;
		
		
	}
	
	public void printProperty() {
		System.out.print(ip+"주소에 "+getSize()+"인치, "+color+"컬러");
	}

	public static void main(String[] args) {
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		
		iptv.printProperty();
	}

	}
