package fr.abnegative.algorithms.number.identification;

public class PrimeNumberIdentification {

	private EvenNumberIdentification evenNumberIdentification = new EvenNumberIdentification();

	/**
	 * Identify if a number is prime or not.
	 * 
	 * @param number
	 * @return @link{<code>true</code>), if tested number is
	 *         even. @link{<code>false</code>) otherwise.
	 */
	public boolean isPrime(int number) {

		/*
		 * If a number is prime, it can be divide only by 1 or itself.
		 * 
		 * As a matter of fact, a prime number have exactly 2 divisors.
		 * 
		 * As a consequence, 1 is not a prime number. 2 is the first prime number.
		 * 
		 */

		if (number == 2) {
			return true;

		} else if (number > 2 && !evenNumberIdentification.isEven(number)) {

			for (int i = 3; i <= Math.sqrt(number); i += 2) {
				if (number % i == 0) {
					return false;
				}
			}
			return true;

		} else
			return false;

	}

	
	public boolean isPrimeReverseCondition(int number) {

		if (number < 2) {

			return false;

		} else if (number == 2) {
			
			return true;

		} else if (evenNumberIdentification.isEven(number)) {

			return false;

		} else {

			for (var i = 3; i <= Math.sqrt(number); i += 2) {
				if (number % i == 0) {
					return false;
				}
			}
		}

		return true;
	}

}
