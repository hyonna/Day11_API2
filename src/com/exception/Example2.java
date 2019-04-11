package com.exception;

public class Example2 {

	public void ex2() {
		
		
		// 어린이집
		int num = 52;
		int num2 = 82;
		int result = num + num2;
		int result2 = num - num2;

		try {

			if (result > 99 || result2 < 0) {

				throw new MyException();
			}

		} catch (Exception e) {

			System.out.println("3자리 몰라요");

		}
	}

}
