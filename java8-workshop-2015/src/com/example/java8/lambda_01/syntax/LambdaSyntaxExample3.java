package com.example.java8.lambda_01.syntax;

import java.util.Arrays;
import java.util.List;

public class LambdaSyntaxExample3 {
	
	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
		integers.forEach((x) -> {
			int y = x/2;
			System.out.println(y);
		});
	}

}
