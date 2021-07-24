package org.ron.m3.changes;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Features_Streams {

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 8: Streams");
		Java8Features_Streams j8 = new Java8Features_Streams();
		j8.quickIntroToStreams();
		j8.whyDoWeNeedStreams();
		j8.misc();
	}

	private void quickIntroToStreams() {
		Utils.newMethod("quickIntroToStreams");

		final int MAX = 950;
		List<Integer> myList = Utils.getRandomList(100, 500, 1000);

		// get a sequential stream
		Stream<Integer> stream = myList.stream();

		// filter the stream (using a lambda)
		Stream<Integer> filteredStream = stream.filter(p -> p > MAX);

		// sort the stream
		Stream<Integer> sortedStream = filteredStream.sorted();

		// print out the values (using a lambda)
		sortedStream.forEach(p -> Utils.print("High Numbers A: sequential =", p));
		Utils.print();

		// all in one line
		myList.stream().filter(p -> p > MAX).sorted().forEach(p -> Utils.print("High Numbers B: sequential =", p));
		Utils.print();
	}

	private void whyDoWeNeedStreams() {
		Utils.newMethod("whyDoWeNeedStreams");
		List<Integer> myList = Utils.getRandomList(1000, -500, 500);

		// Solve this problem: get the sum of all positive values in a list

		// prior to Java 8
		int sum = 0;
		for (Integer i : myList) {
			if (i > 0) {
				sum += i;
			}
		}
		Utils.print("(loop) sum =", sum);

		// The Java 8+ way:
		int streamSum = myList.stream().filter(p -> p > 0).mapToInt(i -> i).sum();
		Utils.print("streamSum =", streamSum);

		int parallelStreamSum = myList.parallelStream().filter(p -> p > 0).mapToInt(i -> i).sum();
		Utils.print("parallelStreamSum =", parallelStreamSum);
	}

	private void misc() {
		Utils.newMethod("misc");
		List<Integer> myList = Utils.getRandomList(1000, -500, 500);

		boolean b = myList.stream().filter(p -> p > 0).limit(3).anyMatch(x -> x % 2 == 0);
		System.out.println("1 of the 1st 3 positive numbers is even: " + b);

		int val0 = IntStream.iterate(0, i -> i + 1).limit(25).sum();
		int val1 = IntStream.iterate(0, i -> i < 25, i -> i + 1).sum();
		int val2 = IntStream.generate(() -> new Random().nextInt()).limit(999).sum();
		System.out.printf("val0=%d, val1=%d, val2=%d%n", val0, val1, val2);

		String s = "123";
		int sum = s.chars().sum();
		System.out.println("sum=" + sum);
		s.chars().forEach(c -> System.out.println((char) c));
	}
}
