package sort;

import util.Util;

public class BucketSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		bucketSort(arr, arr.length);
	}

	private void bucketSort(int[] arr, int size) {
		int bucketAmount = 8;
		int minVal = Util.min(arr, size);
		int maxVal = Util.max(arr, size);
		if (minVal == maxVal) {
			return;
		}
		int bucketArr[][] = new int[bucketAmount][size];
		int bucketSize[] = new int[bucketAmount];
		for (int i = 0; i < size; i++) {
			int val = arr[i];
			int pos = (val - minVal) * bucketAmount / (maxVal - minVal + 1);
			bucketArr[pos][bucketSize[pos]] = val;
			bucketSize[pos]++;
		}

		int seq = 0;
		for (int i = 0; i < bucketAmount; i++) {
			if (bucketSize[i] > 1) {
				bucketSort(bucketArr[i], bucketSize[i]);
			}
			for (int j = 0; j < bucketSize[i]; j++) {
				arr[seq++] = bucketArr[i][j];
			}
		}
	}

}
