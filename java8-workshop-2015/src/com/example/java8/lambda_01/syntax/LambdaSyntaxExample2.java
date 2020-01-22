package com.example.java8.lambda_01.syntax;

import java.util.Arrays;
import java.util.List;

public class LambdaSyntaxExample2 {

	
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		list.forEach(x -> {
			x = x + 10;
			System.out.println(x);
		});
	}

}
