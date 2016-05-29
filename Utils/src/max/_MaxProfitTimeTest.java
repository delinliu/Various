package max;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class _MaxProfitTimeTest {

	public static void main(String[] args) {
		int arrLength = 100000000;
		int[] arr = Util.createRandomArr(arrLength, 1000000000);
		List<Max> list = new ArrayList<Max>();
		list.add(new MaxProfitI());
		list.add(new MaxProfitII());
		list.add(new MaxProfitIII());

		for (Max max : list) {
			long begin = System.currentTimeMillis();
			max.max(arr);
			long end = System.currentTimeMillis();
			System.out.println(max.getClass() + " costs " + (end - begin)
					+ "ms for " + Util.formatInteger(arrLength)
					+ " length array.");
		}
	}
}
