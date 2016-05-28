package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _SortTest {

	public static void main(String[] args) throws Exception {
		int amount = 10000;
		int[] arr = createRandomArr(amount);
		int[] arrSorted = arr.clone();
		Arrays.sort(arrSorted);

		List<Sort> list = new ArrayList<Sort>();
		list.add(new InsertionSort());
		list.add(new SelectionSort());
		list.add(new BubbleSort());
		list.add(new MergeSort());
		list.add(new MergeNoRecursionSort());

		for (Sort sort : list) {
			int[] arrCopy = arr.clone();
			sort.sort(arrCopy);
			if (isEquals(arrSorted, arrCopy)) {
				System.out.println(sort.getClass() + " is right.");
			} else {
				System.err.println(sort.getClass() + " is WRONG.");
			}
		}
	}

	public static int[] createRandomArr(int amount) {
		if (amount < 0) {
			return null;
		}
		int[] arr = new int[amount];
		for (int i = 0; i < amount; i++) {
			arr[i] = (int) (Math.random() * 100000);
		}
		return arr;
	}

	public static boolean isEquals(int[] arr1, int[] arr2) {
		if (arr1 == null) {
			return arr2 == null;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
