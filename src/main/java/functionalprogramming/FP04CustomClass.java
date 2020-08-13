package functionalprogramming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
	private String name;
	private String category;
	private int reviewScore;
	private int noOfStudents;

	public Course(String name, String category, int reviewScore, int noOfStudents) {
		super();
		this.name = name;
		this.category = category;
		this.reviewScore = reviewScore;
		this.noOfStudents = noOfStudents;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getReviewScore() {
		return reviewScore;
	}

	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}

	public int getNoOfStudents() {
		return noOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		this.noOfStudents = noOfStudents;
	}

	@Override
	public String toString() {
		return "Course [name=" + name + ", category=" + category + ", reviewScore=" + reviewScore + ", noOfStudents="
				+ noOfStudents + "]";
	}

}

public class FP04CustomClass {

	public static void main(String[] args) {
		List<Course> courses = 
		List.of(
				new Course("Spring", "Framework", 98, 20000),
				new Course("Spring Boot", "Framework", 95, 18000),
				new Course("API", "Microservices", 97, 22000),
				new Course("Microservices", "Microservices", 96, 25000),
				new Course("FullStack", "FullStack", 91, 14000),
				new Course("AWS", "Cloud", 92, 21000),
				new Course("Azure", "Cloud", 98, 21000),
				new Course("Docker", "Cloud", 92, 20000),
				new Course("Kubernetes", "Cloud", 91, 20000)
				
		);
		
		//allMatch, noneMatch, anyMatch
		Predicate<? super Course> reviewScore = course -> course.getReviewScore() > 95;
		Predicate<? super Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;
		//System.out.println(courses.stream().allMatch(reviewScore));
		//System.out.println(courses.stream().noneMatch(reviewScore));
		//System.out.println(courses.stream().anyMatch(reviewScore));

		Comparator<Course> comparingByNNoOfReviews = Comparator.comparing(Course::getReviewScore).reversed(); 
		Comparator<Course> comparingByNoOfStudentsIncreasing = Comparator.comparing(Course::getNoOfStudents); 
		Comparator<Course> comparingByNoOfStudentsDecreasing = Comparator.comparing(Course::getNoOfStudents).reversed(); 
		//sort
		//System.out.println(courses.stream().sorted(comparingByNoOfStudentsIncreasing).collect(Collectors.toList()));
		//System.out.println(courses.stream().sorted(comparingByNoOfStudentsDecreasing).collect(Collectors.toList()));
		
		Comparator<Course> comparingByNoOfStudentsASndNoOfReviews = Comparator.comparing(Course::getNoOfStudents)
				.thenComparing(Course::getReviewScore).reversed();

		//System.out.println(courses.stream().sorted(comparingByNoOfStudentsASndNoOfReviews).collect(Collectors.toList()));
		
		
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsASndNoOfReviews)
				.limit(3)
				.collect(Collectors.toList()));
		
		System.out.println(courses.stream()
				.sorted(comparingByNoOfStudentsASndNoOfReviews)
				.skip(11)
				.collect(Collectors.toList()));
		System.out.println(courses);
		
		System.out.println(
		courses.stream().takeWhile(course -> course.getReviewScore() >= 95).collect(Collectors.toList()));
		
		//[Course [name=FullStack, category=FullStack, reviewScore=91, noOfStudents=14000], Course [name=AWS, category=Cloud, reviewScore=92, noOfStudents=21000], Course [name=Azure, category=Cloud, reviewScore=98, noOfStudents=21000], Course [name=Docker, category=Cloud, reviewScore=92, noOfStudents=20000], Course [name=Kubernetes, category=Cloud, reviewScore=91, noOfStudents=20000]]

		System.out.println(
			courses.stream()
			.sorted(comparingByNNoOfReviews)
			.dropWhile(course -> course.getReviewScore() >= 97).collect(Collectors.toList()));		
		System.out.println(courses.stream().max(comparingByNoOfStudentsASndNoOfReviews));
		System.out.println(courses.stream()
				.filter(reviewScoreLessThan90Predicate)
				.min(comparingByNoOfStudentsASndNoOfReviews)
				.orElse(new Course("Kubernetes", "Cloud", 91, 20000)));
		System.out.println(courses.stream()
				.filter(reviewScore)
				.findFirst());
		
		System.out.println(courses.stream()
				.filter(reviewScore)
				.findAny());
		

		System.out.println(courses.stream()
				.filter(reviewScore)
				.mapToInt(Course::getNoOfStudents)
				.sum());
		System.out.println(courses.stream()
				.filter(reviewScore)
				.mapToInt(Course::getNoOfStudents)
				.average());
		
		System.out.println(courses.stream()
				.filter(reviewScore)
				.mapToInt(Course::getNoOfStudents)
				.count());
		
		System.out.println(courses.stream()
				.filter(reviewScore)
				.mapToInt(Course::getNoOfStudents)
				.max());
		
		System.out.println(courses.stream()
				.filter(reviewScore)
				.mapToInt(Course::getNoOfStudents)
				.max());
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory)));
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory, Collectors.counting())));
		

		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.maxBy(Comparator.comparing(Course::getReviewScore)))));
		
		System.out.println(courses.stream().collect(Collectors.groupingBy(Course::getCategory,
				Collectors.mapping(Course::getName, Collectors.toList()))));
	}

}
