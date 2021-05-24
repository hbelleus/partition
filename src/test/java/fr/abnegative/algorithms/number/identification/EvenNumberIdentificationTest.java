package fr.abnegative.algorithms.number.identification;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EvenNumberIdentificationTest {

	private EvenNumberIdentification evenNumberIdentification;

	public EvenNumberIdentificationTest() {
		evenNumberIdentification = new EvenNumberIdentification();
	}

	@ParameterizedTest
	@ValueSource(ints = { 0, 2, 166, -254 })
	void isEven(int number) {
		Assertions.assertTrue(evenNumberIdentification.isEven(number));
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, 1, 55 })
	void isEven_isOdd(int number) {
		Assertions.assertFalse(evenNumberIdentification.isEven(number));
	}
}
