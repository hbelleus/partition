package net.adneom.hr.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.provider.Arguments;

@TestInstance(Lifecycle.PER_CLASS)
public interface FunctionalPartitionCase {

	static List<Integer> inputList = new ArrayList<Integer>(2000);

	@BeforeAll
	static void setup() {

		for (int i = 0; i < 2000; i++) {
			inputList.add(i);
		}
	}

	static Stream<Arguments> partition_whenNullOrEnptyInputList() {
		return Stream.of(Collections.emptyList(), null).map(list -> Arguments.of(list, 0));
	}

	static Stream<Arguments> partition_whenNullSubListSize() {
		return Stream.of(0).map(size -> Arguments.of(Arrays.asList(1), size));
	}

	static Stream<Arguments> partition_for1value_shouldReturn1SubList() {
		return Stream.of(Arguments.of(Arrays.asList(1), 2));
	}

	static Stream<Arguments> partition_for5values_shouldReturn5SubList() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 1));
	}

	static Stream<Arguments> partition_for3values_shouldReturn2SubLists() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3), 2));
	}

	static Stream<Arguments> partition_for5values_shouldReturn3SubLists() {
		return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4, 5), 2));
	}

	static Stream<Arguments> partition_forsizeOf2_shouldReturn1000Lists() {
		return Stream.of(Arguments.of(inputList, 2));
	}

	static Stream<Arguments> partition_forsizeOf3_shouldReturn667Lists() {
		return Stream.of(Arguments.of(inputList, 3));
	}
}
