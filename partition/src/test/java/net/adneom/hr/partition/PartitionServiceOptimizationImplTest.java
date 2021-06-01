package net.adneom.hr.partition;

import java.util.List;

import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("Testing partition functionality from PartitionServiceOptimizationImpl")
public class PartitionServiceOptimizationImplTest extends AbstractPartitionTest {

	PartitionServiceOptimizationImplTest() {
		super(new PartitionServiceOptimizationImpl());
	}

	@Override
	@DisplayName("Testing partition with null and empty inputList")
	@ParameterizedTest
	@MethodSource
	public void partition_whenNullOrEnptyInputList(List<Integer> inputList, Integer subListSize) {

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.empty());

	}

	@Override
	@DisplayName("Testing partition with null subListSize")
	@ParameterizedTest
	@MethodSource
	public void partition_whenNullSubListSize(List<Integer> inputList, Integer subListSize) {

		MatcherAssert.assertThat(service.partition(inputList, subListSize), Matchers.empty());

	}
}
