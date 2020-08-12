package functionalprogramming;

import java.util.List;
import java.util.stream.Collectors;

public class FP05Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		doubleList(numbers);
				
	}
	private static void doubleList(List<Integer> numbers) {
		System.out.println("DOUBLE LIST OF NUMBERS:");
		List<Integer> result = numbers.stream().map( number -> number*number).collect(Collectors.toList());
		System.out.println(result);
	}

	
}
