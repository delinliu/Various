package sort;

public class HeapSort implements Sort {

	@Override
	public void sort(int[] arr) {
		if (arr == null) {
			return;
		}

		new Heap(arr);
	}

	private static class Heap {

		private int arr[];
		private int size = 0;

		public Heap(int arr[]) {
			this.arr = arr;
			while (size < arr.length) {
				insert();
			}
			while (size > 0) {
				pop();
			}
		}

		private void insert() {
			shuffleToTop(size);
			++size;
		}

		private int pop() {
			int val = arr[0];
			--size;
			if (size >= 0) {
				arr[0] = arr[size];
				shuffleToBottom();
			}
			arr[size] = val;
			return val;
		}

		private void shuffleToBottom() {
			int val = arr[0];
			int pos = 0;
			while (pos < size) {
				int left = pos * 2 + 1;
				int right = left + 1;
				if (left >= size) {
					break;
				}
				if (right >= size) {
					if (arr[left] > val) {
						arr[pos] = arr[left];
						pos = left;
					}
					break;
				}
				if (arr[left] >= arr[right] && arr[left] > val) {
					arr[pos] = arr[left];
					pos = left;
				} else if (arr[right] >= arr[left] && arr[right] > val) {
					arr[pos] = arr[right];
					pos = right;
				} else {
					break;
				}
			}
			arr[pos] = val;
		}

		private void shuffleToTop(int pos) {
			int val = arr[pos];
			int parent = 0;
			while (pos > 0 && arr[(parent = (pos - 1) / 2)] < val) {
				arr[pos] = arr[parent];
				pos = parent;
			}
			arr[pos] = val;
		}
	}
}
