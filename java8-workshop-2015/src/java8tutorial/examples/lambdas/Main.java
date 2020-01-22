package java8tutorial.examples.lambdas;

import static java.lang.Math.abs;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Main {
	
	static void abs(Integer str){
		
	}
	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1, -2, 3, 4);
		Consumer<Integer> c = Math::abs;
		list.forEach(c);
	}

}
