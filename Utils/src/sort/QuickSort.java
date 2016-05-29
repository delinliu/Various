package sort;

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

		int mid = partition(arr, min, max);
		quickSort(arr, min, mid - 1);
		quickSort(arr, mid + 1, max);
	}

	private int partition(int[] arr, int min, int max) {
		int randomPos = min + (int) (Math.random() * (max - min + 1));
		swap(arr, min, randomPos);
		int val = arr[min];
		int left = min + 1;
		int right = max;
		while (left <= right) {
			while (left <= right && arr[left] <= val) {
				++left;
			}
			while (left <= right && arr[right] > val) {
				--right;
			}
			if (left <= right) {
				swap(arr, left, right);
			}
		}
		swap(arr, min, left - 1);
		return left - 1;
	}

	private void swap(int[] arr, int i, int j) {
		int val = arr[i];
		arr[i] = arr[j];
		arr[j] = val;
	}
}
