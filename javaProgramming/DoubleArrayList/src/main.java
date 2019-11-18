public class main {
	public static void main(String[] args) {
		DoubleArrayList<Double> b = new DoubleArrayList<Double>();
		b.insertLast(1.0);	b.print(); 	b.insertLast(2.0); b.print();
		b.insertLast(3.0);	b.print(); 	b.insertLast(4.0);   b.print();
		b.insertLast(5.0);	b.print();
		
		b.delete(4); b.print();	b.delete(3); b.print();
}
}
