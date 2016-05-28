package sort;

public class SelectionSort implements Sort {

	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			int minPos = i;
			int minVal = arr[i];
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < minVal) {
					minVal = arr[j];
					minPos = j;
				}
			}
			int tmpVal = arr[i];
			arr[i] = arr[minPos];
			arr[minPos] = tmpVal;
		}
	}
}
