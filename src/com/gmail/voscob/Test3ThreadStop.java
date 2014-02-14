package com.gmail.voscob;


public class Test3ThreadStop implements Runnable{
	Thread t;
	boolean suspendFlag;
	Test3ThreadStop() throws InterruptedException {
		t = Thread.currentThread();
		suspendFlag = false;
	}

	@Override
	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
				synchronized (this) {
					while(suspendFlag) {
						
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	synchronized void mysuspend() {
		suspendFlag = true;
	}
	
	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
	
	final void stop() {
		return;
	}
}
