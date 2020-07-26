package employee.employee_type;

import java.util.Arrays;

public class Senior extends Junior {
	private double[] cancelled_transactions;

	public Senior(long employee_id, String first_name, double appointment_percentage, double base_salary) {
		super(employee_id, first_name, appointment_percentage, base_salary);
		this.cancelled_transactions = null;
	}

	@Override
	public double calculate_salary() {
		int count = 0;
		double sum = 0, avg = 0;
		if (this.transactions != null) {
			for (double transaction : transactions) {
				if (transaction != 0.0) {
					count++;
					sum += transaction;
				}
			}
			avg = count != 0 ? sum / count : 0;
		}
		double sal = ((this.baseSalary + avg + count) * this.appointmentPercentage) * 1.5;
		return sal;
	}

	public void addCancledTransaction(double value) {
		int i = 0;
		double[] tempCT = null;
		if (cancelled_transactions == null) {
			tempCT = new double[1];
			tempCT[0] = value;
		} else {
			tempCT = new double[this.cancelled_transactions.length + 1];
			for (; i < this.cancelled_transactions.length; i++) {
				tempCT[i] = this.cancelled_transactions[i];
			}
			tempCT[i] = value;
		}
		this.cancelled_transactions = tempCT;
	}

	@Override
	public String toString() {
		return super.toString() + "Senior [cancelled_transactions=" + Arrays.toString(cancelled_transactions) + "]";
	}

	public double[] getCancelled_transactions() {
		return cancelled_transactions;
	}
}
