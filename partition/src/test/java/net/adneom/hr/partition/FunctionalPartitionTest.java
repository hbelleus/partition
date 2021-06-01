package net.adneom.hr.partition;

import java.util.List;

public interface FunctionalPartitionTest {

	void partition_whenNullOrEnptyInputList(List<Integer> inputList, Integer subListSize);

	void partition_whenNullSubListSize(List<Integer> inputList, Integer subListSize);

	void partition_for1value_shouldReturn1SubList(List<Integer> inputList, Integer subListSize);

	void partition_for5values_shouldReturn5SubList(List<Integer> inputList, Integer subListSize);

	void partition_for3values_shouldReturn2SubLists(List<Integer> inputList, Integer subListSize);

	void partition_for5values_shouldReturn3SubLists(List<Integer> inputList, Integer subListSize);

	void partition_forsizeOf2_shouldReturn1000Lists(List<Integer> inputList, Integer subListSize);

	void partition_forsizeOf3_shouldReturn667Lists(List<Integer> inputList, Integer subListSize);
	
	void partition_forsizeOf3_shouldReturn333334Lists(List<Integer> inputList, Integer subListSize);

}
