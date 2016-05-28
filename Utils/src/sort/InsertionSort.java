package sort;

public class InsertionSort implements Sort {

	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int j = 1; j < arr.length; j++) {
			int i = j - 1;
			int key = arr[j];
			while (i >= 0 && arr[i] > key) {
				arr[i + 1] = arr[i];
				--i;
			}
			arr[i + 1] = key;
		}
	}
}
