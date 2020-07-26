package employee.employee_types;

import java.util.Arrays;

public class Senior extends Junior {
	private double[] cancelledTransactions;

	public Senior(long employee_id, String first_name, double appointment_percentage, double base_salary) {
		super(employee_id, first_name, appointment_percentage, base_salary);
		this.cancelledTransactions = null;
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
		if (cancelledTransactions == null) {
			tempCT = new double[1];
			tempCT[0] = value;
		} else {
			tempCT = new double[this.cancelledTransactions.length + 1];
			for (; i < this.cancelledTransactions.length; i++) {
				tempCT[i] = this.cancelledTransactions[i];
			}
			tempCT[i] = value;
		}
		this.cancelledTransactions = tempCT;
	}

	@Override
	public String toString() {
		return super.toString() + "Senior [cancelled_transactions=" + Arrays.toString(cancelledTransactions) + "]";
	}

	public double[] getCancelled_transactions() {
		return cancelledTransactions;
	}
}
