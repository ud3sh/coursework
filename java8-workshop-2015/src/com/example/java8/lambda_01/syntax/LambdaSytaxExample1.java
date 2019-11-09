package com.example.java8.lambda_01.syntax;
import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;


public class LambdaSytaxExample1 {
	
	public static void main(String[] args) {
		List<Integer> integers = asList(1, 2, 3, 4, 5);
		integers.forEach(item -> System.out.print(item));
	}
}
