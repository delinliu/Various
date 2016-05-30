package sort;

import util.Util;

public class QuickSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int min, int max) {
		if (min >= max) {
			return;
		}

		int mid = Util.partition(arr, min, max);
		quickSort(arr, min, mid - 1);
		quickSort(arr, mid + 1, max);
	}

}
