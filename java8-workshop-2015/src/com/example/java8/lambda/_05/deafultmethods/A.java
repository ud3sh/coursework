package com.example.java8.lambda._05.deafultmethods;

public interface A {
	default void doSomething()
	{
		System.out.println("A");
	}
}
