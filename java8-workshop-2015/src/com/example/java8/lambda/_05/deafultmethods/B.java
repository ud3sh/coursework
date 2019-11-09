package com.example.java8.lambda._05.deafultmethods;

public interface B {
	default void doSomething()
	{
		System.out.println("B");
	}
}
