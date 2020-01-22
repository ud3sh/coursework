package com.example.java8.lambda._03.capture;

import java.util.Arrays;
import java.util.List;

public class LambdaCaptureExample6 {
	private static final LambdaCaptureExample6 INSTANCE = new LambdaCaptureExample6();
	private int instanceVar = 1; 
	private List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

	private void doSomething() {
		integers.forEach(x -> {
			System.out.println(x + this.instanceVar);
			if (this == INSTANCE){
				System.out.println("Within the lambda body this refers to the this of the enclosing object");
			}
			});
	}

	public static void main(String[] args) {
		INSTANCE.doSomething();
	}
}
