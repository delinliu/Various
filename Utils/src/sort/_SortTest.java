package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.Util;

public class _SortTest {

	public static void main(String[] args) throws Exception {
		int amount = 10000;
		int[] arr = Util.createRandomArr(amount);
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
			if (Util.isEquals(arrSorted, arrCopy)) {
				System.out.println(sort.getClass() + " is right.");
			} else {
				System.err.println(sort.getClass() + " is WRONG.");
			}
		}
	}
}
