package com.abc;

import java.util.Date;

import com.abc.DateProvider;

public class Transaction {
	public final double amount;
	public final Date transactionDate;

	public Transaction(double amount) {
		this.amount = amount;
		this.transactionDate = DateProvider.getInstance().now();
	}
}