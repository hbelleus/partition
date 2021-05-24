package fr.abnegative.algorithms.number.identification;

import java.util.Arrays;
import java.util.List;

public class EvenNumberIdentification {

	private static final List<String> EVEN_SUFFIX_LIST = Arrays.asList("0", "2", "4", "6", "8");

	/**
	 * Identifying if a number is even or not.
	 * 
	 * @param number
	 * @return @link{<code>true</code>), if tested number is
	 *         even. @link{<code>false</code>) otherwise.
	 */
	public boolean isEven(int number) {
		return number % 2 == 0;
	}

	public boolean isEvenAsString(int number) {
		return EVEN_SUFFIX_LIST.stream().anyMatch(String.valueOf(number)::endsWith);
	}
}
