package net.adneom.hr.partition;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public abstract class AbstractPartitionTest implements FunctionalPartitionTest, FunctionalPartitionCase {

	protected PartitionService service;

	protected AbstractPartitionTest(PartitionService service) {
		this.service = service;
	}

	@Override
	@DisplayName("Testing partition with inputList with one element and greater subListSize")
	@ParameterizedTest
	@MethodSource
	public void partition_for1value_shouldReturn1SubList(List<Integer> inputList, Integer subListSize) {

		List<List<Integer>> result = service.partition(inputList, subListSize);

		Assertions.assertAll(() -> MatcherAssert.assertThat(result, Matchers.hasSize(1)),
				() -> MatcherAssert.assertThat(result, Matchers.contains(inputList)));

	}

	@Override
	@DisplayName("Testing partition with inputList with fives elements and subListSize of 1")
	@ParameterizedTest
	@MethodSource
	public void partition_for5values_shouldReturn5SubList(List<Integer> inputList, Integer subListSize) {

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(5));

	}

	@Override
	@DisplayName("Testing partition with inputList with three elements and subListSize of 2")
	@ParameterizedTest
	@MethodSource
	public void partition_for3values_shouldReturn2SubLists(List<Integer> inputList, Integer subListSize) {

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(2));

	}

	@Override
	@DisplayName("Testing partition with inputList with five elements and subListSize of 2")
	@ParameterizedTest
	@MethodSource
	public void partition_for5values_shouldReturn3SubLists(List<Integer> inputList, Integer subListSize) {

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(3));

	}

	@Override
	@DisplayName("Testing partition with inputList with 2000 elements and subListSize of 2")
	@ParameterizedTest
	@MethodSource
	public void partition_forsizeOf2_shouldReturn1000Lists(List<Integer> inputList, Integer subListSize) {

		Assumptions.assumeTrue(subListSize == 2);

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(1000));

	}

	@Override
	@DisplayName("Testing partition with inputList with 2000 elements and subListSize of 3")
	@ParameterizedTest
	@MethodSource
	public void partition_forsizeOf3_shouldReturn667Lists(List<Integer> inputList, Integer subListSize) {

		Assumptions.assumeTrue(subListSize == 3);

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(667));
	}
	
	@Override
	@DisplayName("Testing partition with inputList with 1000000 elements and subListSize of 3")
	@ParameterizedTest
	@MethodSource
	public void partition_forsizeOf3_shouldReturn333334Lists(List<Integer> inputList, Integer subListSize) {

		Assumptions.assumeTrue(subListSize == 3);

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.hasSize(333334));
	}

}
