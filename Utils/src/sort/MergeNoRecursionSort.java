package sort;

public class MergeNoRecursionSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		int minLen = 1;
		while (minLen < arr.length) {
			for (int i = 0; i < arr.length - minLen; i += 2 * minLen) {
				MergeSort.merge(arr, i, i + minLen - 1,
						Math.min(i + 2 * minLen - 1, arr.length - 1));
			}
			minLen *= 2;
		}
	}

}
