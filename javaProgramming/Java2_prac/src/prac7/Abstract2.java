package prac7;

abstract class Parent {
	public static final double PI = 3.141592;

	public abstract void method1();

	public abstract void method2();
}

class ChildOne extends Parent {
	@Override
	public void method1() {
		System.out.println("ChildOne method1()");
	}

	@Override
	public void method2() {
		System.out.println("ChildOne method2()");
	}
}

class ChildTwo extends Parent {
	@Override
	public void method1() {
		System.out.println("ChildTwo method1()");
	}

	@Override
	public void method2() {
		System.out.println("ChildTwo method2()");
	}
}

public class Abstract2 {
	static void doSomething(Parent parent) {
		parent.method1();
		parent.method2();
	}

	public static void main(String[] args) {
		ChildOne obj1 = new ChildOne();
		ChildTwo obj2 = new ChildTwo();
		doSomething(obj1);
		doSomething(obj2);
	}
}