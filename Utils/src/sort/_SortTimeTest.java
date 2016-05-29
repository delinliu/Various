package sort;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class _SortTimeTest {

	public static void main(String[] args) {

		int maxAmount = 10000000;
		List<Sort> list = new ArrayList<Sort>();
		list.add(new CountingSort());
		list.add(new RadixSort());
		list.add(new BucketSort());
		list.add(new QuickSort());
		list.add(new MergeSort());
		list.add(new MergeNoRecursionSort());
		list.add(new HeapSort());
		for (Sort sort : list) {
			sortTime(sort, maxAmount);
		}

		int maxAmount2 = 100000;
		List<Sort> list2 = new ArrayList<Sort>();
		list2.add(new InsertionSort());
		list2.add(new SelectionSort());
		list2.add(new BubbleSort());
		for (Sort sort : list2) {
			sortTime(sort, maxAmount2);
		}

	}

	public static void sortTime(Sort s, long maxTime, int maxAmount) {

		int amount = 10000;
		long time = 0;

		while (amount < maxAmount && time < maxTime) {
			time = sortTime(s, amount);
			amount *= 10;
		}
		System.out.println(s.getClass() + " costs " + (time)
				+ "ms for sorting " + Util.formatInteger(amount / 10)
				+ " numbers.");
	}

	private static long sortTime(Sort s, int amount) {
		long time;
		int[] arr = Util.createRandomArr(amount);
		int[] arrCopy = arr.clone();
		long begin = System.currentTimeMillis();
		s.sort(arrCopy);
		long end = System.currentTimeMillis();
		time = end - begin;
		System.out.println(s.getClass() + " costs " + (time)
				+ "ms for sorting " + Util.formatInteger(amount) + " numbers.");
		return time;
	}
}
