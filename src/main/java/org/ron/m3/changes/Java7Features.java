package org.ron.m3.changes;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Java7Features {

	private static final Logger logger = Logger.getLogger(Java7Features.class.getName());

	// underscores in numeric literals
	public static final int MILLION = 1000000;               // prior to Java 7
	public static final int BILLION = 1_000_000_000;         // Java 7
	public static final long TRILLION = 1_000_000_000_000L;  // Java 7


	// Binary Literals
	private int b0 = 0b100001;
	private byte b1 = 0b0001_0011;
	private int b2 = 0b0011_0100_0101_0110;
	private int b3 = 0b0111_1000__1001_1010__1011_1100;


	// Type Inference for Generic Instance Creation
	private Set<Float> java6Set = new TreeSet<Float>();
	private Set<Float> java7Set = new TreeSet<>();

	private List<Boolean> java6List = new ArrayList<Boolean>();
	private List<Boolean> java7List = new ArrayList<>();

	private Map<String, List<Double>> java6Map = new HashMap<String, List<Double>>();
	private Map<String, List<Double>> java7Map = new HashMap<>();


	public static final String ROOT = ".\\src\\main\\java\\org\\ron\\m3\\changes\\";
	public static final String IN_FILE = ROOT + "hello.txt";
	public static final String OUT_FILE = ROOT + "out.txt";

	public static void main(String[] args) {
		Utils.print("Features Introduced in Java 7");
		Java7Features j7 = new Java7Features();
		j7.tryWithResources();
		j7.stringsInSwitch("abc");
		try {
			j7.multipleExceptionHandling();
		} catch (IOException | InterruptedException e) {
			logger.log(Level.SEVERE, "Failed in multipleExceptionHandling()", e);
		}
	}

	public void tryWithResources() {
		Utils.newMethod("tryWithResources");

		// prior to Java 7
		try {
			BufferedReader reader = new BufferedReader(new FileReader(IN_FILE));
			try {
				String firstLine = reader.readLine();
				logger.info(firstLine);
			} finally {
				reader.close();
			}
		} catch (IOException e) {
			logger.severe("resource problem: " + e.getMessage());
		}


		// Java 7
		try (BufferedReader reader = new BufferedReader(new FileReader(IN_FILE))) {
			String firstLine = reader.readLine();
			logger.info(firstLine);
		} catch (IOException e) {
			logger.severe("resource problem: " + e.getMessage());
		}


		// Java 7
		try (
				Reader reader = new BufferedReader(new FileReader(IN_FILE));
				Writer writer = new BufferedWriter(new FileWriter(OUT_FILE));
				InputStream in = new FileInputStream(IN_FILE);
				OutputStream out = new FileOutputStream(OUT_FILE);
		) {
			// use the reader, writer, streams, etc
		} catch (IOException e) {
			logger.severe("resource problem: " + e.getMessage());
		}
	}


	private void stringsInSwitch(String s) {
		Utils.newMethod("stringsInSwitch");

		// prior to Java 7
		if ("abc".equals(s)) {
			doSomething(1, 2, 3);
		}
		if ("abc".equals(s) || "def".equals(s)) {
			doSomething(4, 5, 6);
		}
		if ("abc".equals(s) || "def".equals(s) || "foo".equals(s) || "bar".equals(s) || "janfu".equals(s)) {
			doSomething(10, 20, 30, 40, 50);
		} else if ("ijk".equals(s)) {
			doSomething(7, 8, 9);
		} else {
			doSomething(0);
		}


		// Java 7
		switch (s) {
			case "abc":
				doSomething(1, 2, 3);
			case "def":
				doSomething(4, 5, 6);
			case "foo":
			case "bar":
			case "janfu":
				doSomething(10, 20, 30, 40, 50);
				break;
			case "ijk":
				doSomething(7, 8, 9);
				break;
			default:
				doSomething(0);
		}
	}

	private void multipleExceptionHandling() throws IOException, InterruptedException {
		Utils.newMethod("multipleExceptionHandling");

		// prior to Java 7
		try {
			exceptionalMethod();
		} catch (NullPointerException e) {
			// logging, stack trace, etc
			// do some processing, recovery, cleaning up, etc
			// rethrow exception
			throw e;
		} catch (IOException e) {
			// logging, stack trace, etc
			// do some processing, recovery, cleaning up, etc
			// rethrow exception
			throw e;
		} catch (InterruptedException e) {
			// logging, stack trace, etc
			// do some processing, recovery, cleaning up, etc
			// rethrow exception
			throw e;
		}

		// Java 7
		try (BufferedReader reader = new BufferedReader(new FileReader(IN_FILE))) {
			logger.info(reader.readLine());
			exceptionalMethod();
		} catch (NullPointerException | IOException | InterruptedException e) {
			// logging, stack trace, etc
			// do some processing, recovery, cleaning up, etc
			// rethrow exception
			throw e;
		}
	}


	@SafeVarargs
	private void doSomething(List<Integer>... numLists) {
		// do something
	}

	@SuppressWarnings({"unchecked", "varargs"})  // prior to Java 7
	private void doSomething(int... numLists) {
		// do something
	}

	private void exceptionalMethod() throws
			FileNotFoundException, ObjectStreamException, IOException, // the first 2 are subclasses of IOException
			NullPointerException, ClassCastException, IllegalArgumentException, // all 3 are runtime exceptions
			InterruptedException, SecurityException, IllegalThreadStateException // threading exceptions
	{
		//
	}
}
