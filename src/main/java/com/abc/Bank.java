package com.abc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bank {
	private List<Customer> customers;

	public Bank() {
		customers = new ArrayList<Customer>();
	}

	public void addCustomer(Customer customer) {
		customers.add(customer);
	}

	public String customerSummary() {
		StringBuilder summary = new StringBuilder("Customer Summary");
		for (Customer c : customers)
			summary.append("\n - " + c.getName() + " (" + format(c.getNumberOfAccounts(), "account") + ")");
		return summary.toString();
	}

	// Make sure correct plural of word is created based on the number passed
	// in:
	// If number passed in is 1 just return the word otherwise add an 's' at the
	// end
	private String format(int number, String word) {
		return number + " " + (number == 1 ? word : word + "s");
	}

	/**
	 * @deprecated
	 * <p> Use totalInterestPaid(Date start, Date end)
	 * @return
	 */
	public double totalInterestPaid() {
		double total = 0;
		for (Customer c : customers)
			total += c.totalInterestEarned();
		return total;
	}
	
	/**
	 * Total interest paid out
	 * @param start
	 * @param end
	 * @return
	 */
	public double totalInterestPaid(Date start, Date end) {
		double total = 0;
		for (Customer c : customers)
			total += c.totalInterestEarned(start, end);
		return total;
	}


	/*
	public String getFirstCustomer() {
		try {
			customers = null;
			return customers.get(0).getName();
		} catch (Exception e) {
			e.printStackTrace();
			return "Error";
		}
	}
	*/
}