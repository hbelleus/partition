package net.adneom.hr.partition;

import java.util.List;

public interface PartitionService {

	/**
	 * This method allows you to get a list of sub lists from the incoming list of
	 * Integers {@code inputList}, containing a count of Integer elements
	 * corresponding to the {@code subListSize} given as an input.
	 * 
	 * For example, for the list {@code [1,2,3,4,5] } and a sublist size of
	 * {@code 2}, the result of this method would be the list of sublists
	 * {@code [[1,2],[3,4],[5]] }, where each element contains no more than the
	 * required sublist size.
	 * 
	 * 
	 * @param inputList   incoming list of integers
	 * @param subListSize the size of the target sublist elements
	 * @return the list of partitioned sub lists with size of {@code subListSize}
	 */
	List<List<Integer>> partition(List<Integer> inputList, Integer subListSize);
}
