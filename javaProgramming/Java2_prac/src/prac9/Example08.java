package prac9;

import java.util.Random;

class SharedObjB {
	int sum = 0;

	synchronized void add(int i) {
		sum = sum + i;
	}
	
	synchronized void sub(int i) {
		sum = sum - i;
	}
}

class ThreadA extends Thread {
	String name;
	int count;
	SharedObjB sharedObj;
	Random random;

	public ThreadA(String name, int count, SharedObjB sharedObj) {
		this.name = name;
		this.count = count;
		this.sharedObj = sharedObj;
		this.random = new Random();
	}

	@Override
	public void run() {
		System.out.printf("%s: started\n", name);
		try {
			for (int i = 1; i <= count; ++i) {
				sharedObj.add(i);
				int mili_second = random.nextInt(10);
				sleep(mili_second);
			}
		} catch (InterruptedException e) {
			System.out.printf("%s: interrupted\n", name);
		}
		System.out.printf("%s: stoped\n", name);
		System.out.printf("%s: %d\n", name, sharedObj.sum);
	}
}

class ThreadB extends Thread {
	String name;
	int count;
	SharedObjB sharedObj;
	Random random;

	public ThreadB(String name, int count, SharedObjB sharedObj) {
		this.name = name;
		this.count = count;
		this.sharedObj = sharedObj;
		this.random = new Random();
	}

	@Override
	public void run() {
		System.out.printf("%s: started\n", name);
		try {
			for (int i = 1; i <= count; ++i) {
				sharedObj.sub(i);
				int mili_second = random.nextInt(10);
				sleep(mili_second);
			}
		} catch (InterruptedException e) {
			System.out.printf("%s: interrupted\n", name);
		}
		System.out.printf("%s: stoped\n", name);
		System.out.printf("%s: %d\n", name, sharedObj.sum);
	}
}

public class Example08 {
	public static void main(String args[]) {
		SharedObjB sharedObj = new SharedObjB();
		ThreadA threadOne = new ThreadA("one", 100, sharedObj);
		ThreadB threadTwo = new ThreadB("two", 100, sharedObj);
		
		threadOne.start();
		threadTwo.start();
		
	}
}
