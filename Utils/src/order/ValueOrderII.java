package order;

import sort.QuickSort;

public class ValueOrderII implements Order {

	@Override
	public int order(int[] arr, int order) {
		if (arr == null || arr.length == 0 || order < 1 || order > arr.length) {
			return 0;
		}
		new QuickSort().sort(arr);
		return arr[order - 1];
	}

}
