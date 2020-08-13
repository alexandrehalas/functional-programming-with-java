package functionalprogramming;

import java.util.List;

public class FP03BehaviourParametrization {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		numbers.stream()
		.filter(number -> number%2 == 0)
	    .forEach( System.out::println);
		
		numbers.stream()
		.filter(number -> number%2 != 0)
	    .forEach( System.out::println);		

	}
	
}