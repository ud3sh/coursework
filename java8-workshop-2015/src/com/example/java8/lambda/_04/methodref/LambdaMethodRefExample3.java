package com.example.java8.lambda._04.methodref;

import java.util.function.Consumer;
import java.util.function.Function;

public class LambdaMethodRefExample3 {
	public static void doSomething(Integer i) 
	{
		System.out.println(i);
	}
	
	public static void main(String[] args) {
		//the following two are equivalent
		Function<String, Integer> mapper1= x -> new Integer(x);
		System.out.println(mapper1.apply("10"));
		
		Function<String, Integer> mapper2= Integer::new;
		System.out.println(mapper2.apply("11"));

	}

}
