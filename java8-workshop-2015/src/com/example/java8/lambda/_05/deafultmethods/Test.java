package com.example.java8.lambda._05.deafultmethods;

public interface Test {
	default void doSomething() 
	{
		System.out.println("Test");
	}

}
