package functionalprogramming;

import java.util.Comparator;
import java.util.List;

public class FP04Functional {

	public static void main(String[] args) {

		List<String> names = List.of("Xande", "Bel", "Gabi", "Giu");
		orderNamesASCInListFunctional(names);
		orderNamesDESCInListFunctional(names);
	}

	private static void orderNamesASCInListFunctional(List<String> names) {
		System.out.println("ASC NAMES:");
		names.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
	}

	private static void orderNamesDESCInListFunctional(List<String> names) {
		System.out.println("DESC NAMES:");
		names.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
	}
}
