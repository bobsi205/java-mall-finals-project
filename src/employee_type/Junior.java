package employee_type;

import java.util.Arrays;

import employee.Employee;

public class Junior extends Employee {
	protected double[] transactions;

	public Junior(long employee_id, String first_name, double appointment_percentage, double base_salary) {
		super(employee_id, first_name, appointment_percentage, base_salary);
		this.transactions = null;
	}

	public double[] getTransactions() {
		return transactions;
	}

	public void addTransaction(double value) {
		double[] tempTransactions = null;

		if (this.transactions == null) {
			tempTransactions = new double[1];
			tempTransactions[0] = value;
		} else {
			tempTransactions = new double[this.transactions.length + 1];
			for (int i = 0; i < this.transactions.length; i++) {
				tempTransactions[i] = this.transactions[i];
			}
			tempTransactions[this.transactions.length] = value;
		}
		this.transactions = tempTransactions;
	}

	@Override
	public double calculate_salary() {
		int count = 0;
		double sum = 0, avg = 0, sal = 0;
		if (this.transactions != null) {
			for (double transaction : transactions) {

				if (transaction != 0.0) {
					count++;
					sum += transaction;
				}
			}
			avg = count != 0 ? sum / count : 0;
		}
		sal = (this.baseSalary + avg + count) * this.appointmentPercentage;
		return sal;
	}

	@Override
	public String toString() {
		return super.toString() + "Junior [transactions=" + Arrays.toString(transactions) + "]";
	}

}
