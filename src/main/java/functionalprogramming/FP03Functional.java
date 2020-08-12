package functionalprogramming;

import java.util.List;

public class FP03Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		distinctNumbersInListFunctional(numbers);
		sortedNumbersInListFunctional(numbers);
		distinctAndSortedNumbersInListFunctional(numbers);
		
	}
	private static void distinctNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("DISTINCT NUMBERS:");
		numbers.stream().distinct().forEach(System.out::println);
	}

	private static void sortedNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("SORTED NUMBERS:");
		numbers.stream().sorted().forEach(System.out::println);
	}
	
	private static void distinctAndSortedNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("DISTINCT AND SORTED NUMBERS:");
		numbers.stream().distinct().sorted().forEach(System.out::println);
	}

}
