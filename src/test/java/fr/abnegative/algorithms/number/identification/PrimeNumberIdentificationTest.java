package fr.abnegative.algorithms.number.identification;

import java.time.Duration;
import java.util.concurrent.TimeoutException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PrimeNumberIdentificationTest {

	private PrimeNumberIdentification primeNumberIdentification;

	PrimeNumberIdentificationTest() {
		primeNumberIdentification = new PrimeNumberIdentification();
	}

	@DisplayName("Successfull identification of prime number")
	@ParameterizedTest
	@ValueSource(ints = { 2, 3, 5, 7, 97 })
	void isPrime_isPrime(int number) {
		Assertions.assertTrue(primeNumberIdentification.isPrime(number));
	}

	@DisplayName("Test for non prime number")
	@ParameterizedTest
	@ValueSource(ints = { 0, 4, -5, 51 })
	void isPrime_isNotPrime(int number) {
		Assertions.assertFalse(primeNumberIdentification.isPrime(number));
	}


	@DisplayName("Test performance - isPrimeNew")
	@ParameterizedTest
	@ValueSource(ints = { 100010017, 999988903 })
	void isPrime_largeNumber_Perf_new(int number) throws TimeoutException {

		Assertions.assertTimeout(Duration.ofMillis(5),
				() -> primeNumberIdentification.isPrimeReverseCondition(number));
	}
	
	@DisplayName("Test performance - isPrime")
	@ParameterizedTest
	@ValueSource(ints = { 100010017, 999988903 })
	void isPrime_largeNumber_Perf(int number) throws TimeoutException {

		Assertions.assertTimeout(Duration.ofMillis(5),
				() -> primeNumberIdentification.isPrime(number));
	}
}
