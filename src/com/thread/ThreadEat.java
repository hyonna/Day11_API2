package com.thread;

public class ThreadEat extends Thread {

	@Override
	public void run() {

		// 동시에 진행하고픈 코드
		eat();

	}

	private void eat() {

		for (int i = 0; i < 10; i++) {

			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			System.out.println("챱챱");
		}

	}

}
