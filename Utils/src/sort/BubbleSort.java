package sort;

public class BubbleSort implements Sort {

	@Override
	public void sort(int[] arr) {

		if (arr == null) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j > i; j--) {
				if (arr[j] < arr[j - 1]) {
					swap(arr, j, j - 1);
				}
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int val = arr[i];
		arr[i] = arr[j];
		arr[j] = val;
	}
}
