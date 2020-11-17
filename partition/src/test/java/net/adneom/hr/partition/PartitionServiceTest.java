package net.adneom.hr.partition;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.hamcrest.MatcherAssert;
import org.junit.Test;

import net.adneom.hr.partition.PartitionService;
import net.adneom.hr.partition.PartitionServiceImpl;

/**
 * This class tests the PartitionService with the partition method.
 * 
 * @author Hattmann.Belleus
 *
 */
public class PartitionServiceTest {

	final private PartitionService service = new PartitionServiceImpl();
	private List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5);
	private Integer subListSize;

	/**
	 * This test checks that a subList size of 1 with the incoming list
	 * {@code inputList} return a list containing 5 elements with size less than or
	 * equals to the specified subList size.
	 * 
	 */
	@Test
	public void partitionTest_case1() {

		subListSize = 1;

		List<List<Integer>> outputList = service.partition(inputList, subListSize);

		MatcherAssert.assertThat(outputList, hasItem(Collections.singletonList(1)));
		MatcherAssert.assertThat(outputList, hasItem(Collections.singletonList(3)));
		MatcherAssert.assertThat(outputList, hasItem(Collections.singletonList(5)));
		MatcherAssert.assertThat(outputList, hasSize(5));
		MatcherAssert.assertThat(outputList, hasItems(hasSize(lessThanOrEqualTo(subListSize))));
	}

	/**
	 * This test checks that a subList size of 2 with the incoming list
	 * {@code inputList} return a list containing 3 elements with size less than or
	 * equals to the specified subList size.
	 * 
	 */
	@Test
	public void partitionTest_case2() {

		subListSize = 2;

		List<List<Integer>> outputList = service.partition(inputList, subListSize);

		MatcherAssert.assertThat(outputList, hasItem(Arrays.asList(1, 2)));
		MatcherAssert.assertThat(outputList, hasItem(Arrays.asList(3, 4)));
		MatcherAssert.assertThat(outputList, hasItem(Collections.singletonList(5)));
		MatcherAssert.assertThat(outputList, hasSize(3));
		MatcherAssert.assertThat(outputList, hasItems(hasSize(lessThanOrEqualTo(subListSize))));
	}

	/**
	 * This test checks that a subList size of 3 with the incoming list
	 * {@code inputList} return a list containing 2 elements with size less than or
	 * equals to the specified subList size.
	 * 
	 */
	@Test
	public void partitionTest_case3() {

		subListSize = 3;

		List<List<Integer>> outputList = service.partition(inputList, subListSize);

		MatcherAssert.assertThat(outputList, hasItem(Arrays.asList(1, 2, 3)));
		MatcherAssert.assertThat(outputList, hasItem(Arrays.asList(4, 5)));
		MatcherAssert.assertThat(outputList, hasSize(2));
		MatcherAssert.assertThat(outputList, hasItems(hasSize(lessThanOrEqualTo(subListSize))));
	}

	/**
	 * This case verifies that an incoming empty list returns an empty list.
	 */
	@Test
	public void partitionTest_emptyInputList() {
		subListSize = 1;

		List<List<Integer>> outputList = service.partition(Collections.emptyList(), subListSize);

		MatcherAssert.assertThat(outputList, empty());
	}

	/**
	 * This case verifies that a null incoming sublist size throws an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void partitionTest_nullSubListSize() {
		subListSize = null;

		service.partition(inputList, subListSize);
	}

	/**
	 * This case verifies that an incoming sublist size of 0 throws an exception.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void partitionTest_subListSizeEqualsToZero() {
		subListSize = 0;

		service.partition(inputList, subListSize);
	}
}
