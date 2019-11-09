package com.example.java8.lambda._02.interfaces;

import java.util.function.BiFunction;

public class FunctionalInterfaceExample2 {
	public static void doSomething (PasswordEncoder1 encoder){
		String salted  = encoder.encode("abc", "123");
		System.out.println(salted);
	}
	
	public static void doOther(BiFunction<String, String, String> encoder){ 
		String salted = encoder.apply("abc", "123)");
		System.out.println(salted);
	}
	
	public static void main(String[] args) {
		doSomething((password, salt) -> password.toUpperCase());
		doOther((password, salt) -> password.toUpperCase());
	}
}
