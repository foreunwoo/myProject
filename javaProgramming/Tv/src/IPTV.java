class IPTV extends ColorTv{
	private String ip;
	
	
	public IPTV(String ip, int size, int color) {
		
		super(size, color);
		this.ip=ip;
		
		
	}
	
	public void printProperty() {
		System.out.print(ip+"�ּҿ� "+getSize()+"��ġ, "+color+"�÷�");
	}

	public static void main(String[] args) {
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		
		iptv.printProperty();
	}

	}
