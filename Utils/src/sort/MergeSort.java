package sort;

public class MergeSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	private void mergeSort(int[] arr, int min, int max) {
		if (min >= max) {
			return;
		}

		int mid = (min + max) / 2;
		mergeSort(arr, min, mid);
		mergeSort(arr, mid + 1, max);
		merge(arr, min, mid, max);
	}

	public static void merge(int[] arr, int l, int m, int r) {

		int len1 = m - l + 1;
		int len2 = r - m;
		int arr1[] = new int[len1];
		int arr2[] = new int[len2];
		System.arraycopy(arr, l, arr1, 0, len1);
		System.arraycopy(arr, m + 1, arr2, 0, len2);
		int pos1 = 0;
		int pos2 = 0;
		int targetPos = l;
		while (pos1 < len1 && pos2 < len2) {
			if (arr1[pos1] < arr2[pos2]) {
				arr[targetPos++] = arr1[pos1++];
			} else {
				arr[targetPos++] = arr2[pos2++];
			}
		}
		while (pos1 < len1) {
			arr[targetPos++] = arr1[pos1++];
		}
		while (pos2 < len2) {
			arr[targetPos++] = arr2[pos2++];
		}
	}

}
