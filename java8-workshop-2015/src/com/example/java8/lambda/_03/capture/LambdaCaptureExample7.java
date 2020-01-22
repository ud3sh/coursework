package com.example.java8.lambda._03.capture;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class LambdaCaptureExample7 {
	private static final LambdaCaptureExample7 INSTANCE = new LambdaCaptureExample7();
	private int instanceVar = 1; 
	private List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

	private void doSomething() {
		integers.forEach(x -> {
			System.out.println(x + this.instanceVar);
			if (this == INSTANCE){
				System.out.println("Within the lambda body this refers to the this of the enclosing object");
			}
			});
		
		integers.forEach(new Consumer<Integer>() {
			private int state = 10;

			@Override
			public void accept(Integer x) {
				int y = this.state + LambdaCaptureExample7.this.instanceVar + x; 
				System.out.println("Anonymous class " + y);				
			}
		});
	}

	public static void main(String[] args) {
		INSTANCE.doSomething();
	}
}
