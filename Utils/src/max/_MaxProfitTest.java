package max;

import java.util.ArrayList;
import java.util.List;

import util.Util;

public class _MaxProfitTest {

	public static void main(String[] args) {
		int arrLength = 1000;
		int[] arr = Util.createRandomArr(arrLength, 1000000000);
		List<Max> list = new ArrayList<Max>();
		list.add(new MaxProfitI());
		list.add(new MaxProfitII());
		list.add(new MaxProfitIII());

		int previousMaxProfit = 0;
		int errorAmount = 0;
		for (int i = 0; i < list.size(); i++) {
			Max max = list.get(i);
			int currMaxProfit = max.max(arr);
			if (i > 0 && currMaxProfit != previousMaxProfit) {
				System.err.println(list.get(i - 1).getClass()
						+ " is not equal to " + max.getClass() + ".");
				++errorAmount;
			}
			previousMaxProfit = currMaxProfit;
		}
		if (errorAmount == 0) {
			System.out.println(list.size() + " MaxProfit tests may be right.");
		}
	}
}
