package functionalprogramming;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		sumAllNumbersInListFunctional(numbers);
		findMaxNumberInListFunctional(numbers);
		findMinNumberInListFunctional(numbers);
		sumOfSquareNumberInListFunctional(numbers);  
		sumOfEvenSquareNumberInListFunctional(numbers);
		
	}
	private static void sumAllNumbersInListFunctional(List<Integer> numbers) {
		System.out.println("SUM ALL NUMBERS:");
		int sum = numbers.stream().reduce(0, (x,y) -> x+y);
		System.out.println(sum);
	}

	private static void findMaxNumberInListFunctional(List<Integer> numbers) {
		System.out.println("MAX NUMBER:");
		int max = numbers.stream().reduce(Integer.MIN_VALUE, (x,y) -> x>y ? x: y);
		System.out.println(max);
	}	
	private static void findMinNumberInListFunctional(List<Integer> numbers) {
		System.out.println("MIN NUMBER:");
		int min = numbers.stream().reduce(Integer.MAX_VALUE, (x,y) -> x<y ? x: y);
		System.out.println(min);
	}	
	private static void sumOfSquareNumberInListFunctional(List<Integer> numbers) {
		System.out.println("SUM OF SQUARE NUMBER:");
		int sumOfSquare = numbers.stream()
				.map(number -> number*number)
				.reduce(0, Integer::sum);
		System.out.println(sumOfSquare);
	}
	
	private static void sumOfEvenSquareNumberInListFunctional(List<Integer> numbers) {
		System.out.println("SUM OF EVEN SQUARE NUMBER:");
		int sumOfEvenSquare = numbers.stream()
				.filter(number -> number%2 == 0)
				.map(number -> number*number)
				.reduce(0, Integer::sum);
		System.out.println(sumOfEvenSquare);
	}
	
}
