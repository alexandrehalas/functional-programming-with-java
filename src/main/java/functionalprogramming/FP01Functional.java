package functionalprogramming;

import java.util.List;

public class FP01Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		printAllNumbersInListFunctional(numbers);
		printEvenNumbersInListFunctional(numbers);
		
	}

	private static void printAllNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("ALL NUMBERS:");
		numbers.stream().forEach(System.out::println);
	}

	private static void printEvenNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("EVEN NUMBERS:");
		numbers.stream()
			.filter(FP01Functional::isEven)
			.forEach(System.out::println);
	}
	
	private static boolean isEven(int number) {
		return number%2 == 0;
	}
	
}
