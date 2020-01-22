package com.example.java8.lambda_01.syntax;

import java.util.Arrays;
import java.util.List;

public class LambdaSyntaxExample4 {

	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
		integers.forEach((Integer x) -> {
			System.out.println(x);
		});
		// You can specify the types of lambda expression variables (Integer x). The
		// Java 8 compiler uses type inference to figure out that x is an Integer
		// this is why (Integer x) can be written as just x.
	}

}
