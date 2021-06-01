package net.adneom.hr.partition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;

public class PartitionServiceOptimizationImpl implements PartitionService {

	@Override
	public List<List<Integer>> partition(List<Integer> inputList, Integer subListSize) {

		List<List<Integer>> result = new ArrayList<>();

		if (inputList != null && subListSize > inputList.size())
			return Arrays.asList(inputList);

		else if (CollectionUtils.isNotEmpty(inputList) && subListSize > 0) {

			for (int i = 0; i < inputList.size(); i += subListSize) {

				result.add(inputList.subList(i, i + subListSize - 1));
			}
		}

		return result;
	}

}
