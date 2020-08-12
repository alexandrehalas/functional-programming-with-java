package functionalprogramming;

import java.util.List;

public class FP02Functional {

	public static void main(String[] args) {
		
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		sumAllNumbersInListFunctional(numbers);
		findMaxNumberInListFunctional(numbers);
		findMinNumberInListFunctional(numbers);
		
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
}
