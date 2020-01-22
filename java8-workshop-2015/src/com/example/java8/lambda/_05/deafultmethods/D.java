package com.example.java8.lambda._05.deafultmethods;

public interface D extends A {
	@Override
	public default void doSomething() 
	{
		System.out.println("D");
	}
}
