package functionalprogramming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FP03FunctionalInterfaces {

	public static void main(String[] args) {
		List<Integer> numbers = List.of(12,9,13,4,6,2,4,12,15);
		Predicate<Integer> isEvenNumber = number -> number%2 == 0;
		Function<Integer, Integer> squareFunction = number -> number * number;
		Consumer<Integer> sysoutConsumer = System.out::println;
		numbers.stream()
		.filter(isEvenNumber)
		.map(squareFunction)
	//	.reduce(0, Integer::sum);
	    .forEach(sysoutConsumer);		
	}
	
}
