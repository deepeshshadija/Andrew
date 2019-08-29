import java.util.ArrayList;
import java.util.List;

import bean.CustomerTransaction;

public class CustomerRewards {
	public static void main(String args[]) {
		CustomerTransaction ct = new CustomerTransaction();
		populateData(ct);
		calculate(ct);
	}

	private static void calculate(CustomerTransaction ct) {
		if (null != ct) {
			List<Integer> month1 = ct.getMonth1();
			List<Integer> month2 = ct.getMonth2();
			List<Integer> month3 = ct.getMonth3();
			int grandTotal = 0;
			int monthlyTotal = 0;
			if (null != month1 & !month1.isEmpty()) {
				System.out.println("******Month1******");
				monthlyTotal = detailedCalculation(month1);
				System.out.println("Month 1 : Total " + monthlyTotal);
				grandTotal = grandTotal + monthlyTotal;
			}
			if (null != month2 & !month2.isEmpty()) {
				System.out.println("******Month2******");
				monthlyTotal = detailedCalculation(month2);
				System.out.println("Month 2 : Total " + monthlyTotal);
				grandTotal = grandTotal + monthlyTotal;
			}
			if (null != month3 & !month3.isEmpty()) {
				System.out.println("******Month3******");
				monthlyTotal = detailedCalculation(month3);
				System.out.println("Month 3 : Total " + monthlyTotal);
				grandTotal = grandTotal + monthlyTotal;
			}
			System.out.println("========================");
			System.out.println("Grand Total : " + grandTotal);
		}
	}

	private static int detailedCalculation(List<Integer> month) {
		int monthlyTotal = 0;
		int hundredCount = 0;
		int fiftyCount = 0;
		int difference = 0;
		for (Integer a : month) {
			// System.out.println("**Number***" + a);
			if (a >= 100) {
				hundredCount = Math.abs(a / 100);
				// System.out.println("hundred count" + hundredCount);
				if (1 == hundredCount) {
					difference = a - 100;
				} else {
					difference = a - ((hundredCount - 1) * 100);
				}
				monthlyTotal = monthlyTotal + (difference * 2);
				fiftyCount = Math.abs(a / 50);
				// System.out.println(" fiftycount : " + fiftyCount);
				monthlyTotal = monthlyTotal + ((fiftyCount - 1) * 50);
			}
		}
		return monthlyTotal;

	}

	private static void populateData(CustomerTransaction ct) {
		List<Integer> month1 = new ArrayList<Integer>();
		List<Integer> month2 = new ArrayList<Integer>();
		List<Integer> month3 = new ArrayList<Integer>();
		month1.add(140);
		month1.add(120);
		month2.add(50);
		month2.add(200);
		month3.add(10);
		month3.add(99);
		ct.setMonth1(month1);
		ct.setMonth2(month2);
		ct.setMonth3(month3);

	}
}
