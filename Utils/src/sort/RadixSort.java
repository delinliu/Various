package sort;

import util.Util;

public class RadixSort implements Sort {

	@Override
	public void sort(int[] arr) {

		if (arr == null) {
			return;
		}

		int maxVal = Util.max(arr);
		int bit = 3;
		int radix = (int) Math.pow(2.0, bit);
		int mask = radix - 1;
		int divide = 0;
		int radixArr[][] = new int[radix][arr.length];
		int radixSize[] = new int[radix];
		while (maxVal > 0) {
			resetArr(radixSize);
			for (int val : arr) {
				int pos = (val >> divide) & mask;
				radixArr[pos][radixSize[pos]] = val;
				radixSize[pos]++;
			}
			int seq = 0;
			for (int i = 0; i < radix; i++) {
				for (int j = 0; j < radixSize[i]; j++) {
					arr[seq++] = radixArr[i][j];
				}
			}
			divide += bit;
			maxVal >>= bit;
		}
	}

	private void resetArr(int arr[]) {
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
	}

}
