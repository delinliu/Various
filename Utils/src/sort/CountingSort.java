package sort;

import util.Util;

public class CountingSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}
		int maxVal = Util.max(arr);
		int[] counting = new int[maxVal + 1];
		for (int val : arr) {
			++counting[val];
		}

		int pos = 0;
		for (int i = 0; i < counting.length; i++) {
			int amount = counting[i];
			while (amount-- > 0) {
				arr[pos++] = i;
			}
		}
	}


}
