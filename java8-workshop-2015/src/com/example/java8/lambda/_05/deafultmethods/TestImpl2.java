package com.example.java8.lambda._05.deafultmethods;

public class TestImpl2 implements Test{
	
	@Override
	public void doSomething() { 
		System.out.println("TestImpl2");
	}

	public static void main(String[] args) {
		TestImpl2 testImpl = new TestImpl2();
		testImpl.doSomething(); 
	}
}
