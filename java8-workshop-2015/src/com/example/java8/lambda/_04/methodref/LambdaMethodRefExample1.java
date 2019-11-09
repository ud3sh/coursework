package com.example.java8.lambda._04.methodref;

import java.util.function.Consumer;

public class LambdaMethodRefExample1 {
	
	public static void doSomething(Integer i) 
	{
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		//the following two are equivalent
		
		Consumer<Integer>  conusmer1 = x -> doSomething(x); 
		conusmer1.accept(1);
		
		Consumer<Integer> conusmer2 = LambdaMethodRefExample1::doSomething; 
		conusmer2.accept(1);
	}

}
