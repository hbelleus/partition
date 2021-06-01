package net.adneom.hr.partition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PartitionServiceImpl implements PartitionService {

	@Override
	public List<List<Integer>> partition(List<Integer> inputList, Integer subListSize) {

		final Integer outputListSize = this.calculateOutputListSize(inputList, subListSize);

		// We initialize the outputList with its size (calculated above)
		List<List<Integer>> outputList = new ArrayList<>(outputListSize);

		// We populate the output list with the required sub lists
		return this.populateOutputList(outputList, outputListSize, inputList, subListSize);
	}

	/**
	 * This method calculate the output list size from the input list of integers
	 * and the required sub list size.
	 * 
	 * The output list size depends on the remainder of the division of the input
	 * list size by the required sublist size. If the remainder is greater than 0,
	 * the result size is the quotient of the division plus 1.
	 * 
	 * @param inputList   the incoming list to partition
	 * @param subListSize the sub lists size
	 * @return the output list size
	 * @throws IllegalArgumentException if the element size and the entry list are null or
	 *                            empty
	 */
	private Integer calculateOutputListSize(List<Integer> inputList, Integer subListSize) {

		if (this.inputsAreNonNull(inputList, subListSize)) {

			final Integer outputListSize;

			/*
			 * We determine the size of the output list by dividing the inputList size by
			 * the elementSize
			 */
			if (inputList.size() % subListSize > 0) {
				/*
				 * If the remainder of the division is greater than 0, that means that the
				 * output list size is the quotient + 1
				 */
				outputListSize = inputList.size() / subListSize + 1;
			} else {
				// Otherwise the output list size equals to the quotient
				outputListSize = inputList.size() / subListSize;
			}

			return outputListSize;
		} else
			throw new IllegalArgumentException("The inputs are required non null.");
	}

	/**
	 * Check if the inputs are null or empty.
	 * 
	 * @param inputList   that cannot be null
	 * @param subListSize that should be non null and greater than 0
	 * @return {@code true} if the inputs are non null, {@code false} otherwise
	 * 
	 */
	private boolean inputsAreNonNull(List<Integer> inputList, Integer subListSize) {
		return Objects.nonNull(inputList) && Objects.nonNull(subListSize) && subListSize > 0;
	}

	/**
	 * This method populate the output list previously generated. Each element has a
	 * size that equals to the {@value subListSize}.
	 * 
	 * @param outputList  the list with the required sublists to populates
	 * @param inputList   the incoming list of Integers to partition
	 * @param subListSize the size of each element of the output list
	 * @return outputList with the target subList elements
	 * 
	 * 
	 * @see List#subList(Integer, Integer)
	 */
	private List<List<Integer>> populateOutputList(List<List<Integer>> outputList, Integer outputListSize,
			List<Integer> inputList, Integer subListSize) {

		// We iterate for each multiple of the element size
		for (int i = 0; i < outputListSize; i++) {

			List<Integer> subList;

			// the value of fromIndex is inclusive
			final Integer fromIndex = i * subListSize;
			// the value of toIndex is exclusive
			final Integer toIndex = (i + 1) * subListSize;

			if (toIndex <= inputList.size()) {
				subList = inputList.subList(fromIndex, toIndex);
			} else {
				/*
				 * If the toIndex value is greater than the size of the inputList, we generate
				 * the sub list with the last index of the list that equals the inputList.size()
				 * - 1 (the index inputList.size() is exclusive)
				 */
				subList = inputList.subList(fromIndex, inputList.size());
			}

			outputList.add(subList);
		}

		return outputList;
	}
}
