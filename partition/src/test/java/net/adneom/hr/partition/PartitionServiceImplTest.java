package net.adneom.hr.partition;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * This class tests the PartitionService with the partition method.
 * 
 * @author Hattmann.Belleus
 *
 */
@DisplayName("Testing partition functionality from PartitionServiceImpl")
public class PartitionServiceImplTest extends AbstractPartitionTest {

	PartitionServiceImplTest() {
		super(new PartitionServiceImpl());
	}

	@Override
	@DisplayName("Testing partition with null and empty inputList throwing IllegalArgumentException")
	@ParameterizedTest()
	@MethodSource
	public void partition_whenNullOrEnptyInputList(List<Integer> inputList, Integer subListSize) {

		Assertions.assertThrows(IllegalArgumentException.class, () -> service.partition(inputList, subListSize));

	}

	@Override
	@DisplayName("Testing partition with null subListSize throwing IllegalArgumentException")
	@ParameterizedTest
	@MethodSource
	public void partition_whenNullSubListSize(List<Integer> inputList, Integer subListSize) {

		Assertions.assertThrows(IllegalArgumentException.class, () -> service.partition(inputList, subListSize));

	}
}
