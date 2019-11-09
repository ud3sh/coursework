package com.example.java8.lambda._05.deafultmethods;

public interface C extends A {
	default void other()
	{
		System.out.println("C");
	}
}
