package com.gmail.voscob;


public class Test3ThreadStop implements Runnable{
	Thread t;
	Test3ThreadStop() throws InterruptedException {
		t = Thread.currentThread();
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	final void stop() {
		t.interrupt();
	}
}
