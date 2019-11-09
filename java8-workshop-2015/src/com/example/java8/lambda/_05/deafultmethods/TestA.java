package com.example.java8.lambda._05.deafultmethods;

public interface TestA {
	
	public default void doSomething() {
		System.out.println("Test A");
	}

}
