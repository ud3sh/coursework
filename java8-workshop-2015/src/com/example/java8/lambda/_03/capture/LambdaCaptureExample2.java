package com.example.java8.lambda._03.capture;

import java.util.Arrays;
import java.util.List;

public class LambdaCaptureExample2 {
	public static void main(String[] args) {

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

		int var = 1;
		integers.forEach(x -> {

			//compile error var++; 
			System.out.println(x);
		});
	}
}
