package com.thread;

public class ThreadMusic implements Runnable{
	
	private int ticket = 10;
	
	@Override
	public void run() {
		
		this.music();
		
	}
	
	private void buyTicket() {
		
		ticket--;
		
		if(ticket < 1) {
			
			System.out.println("매진");
			
		} else {
			
			System.out.println(Thread.currentThread().getName() + " 님이 들어옴");
			System.out.println("Ticket : " + ticket);
			
		}
		
	}
	
	public void music() {
		
		for (int i = 0; i < 10; i++) {
			
			try {
				
				Thread.sleep(1000);
				
			} catch (InterruptedException e) {
				
				e.printStackTrace();
				
			}
			System.out.print(Thread.currentThread().getName());
			System.out.println(" : 비트 주세요");
			buyTicket();
			
		}
		
		
	}

}
