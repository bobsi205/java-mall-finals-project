package employee.employee_types;

import employee.Employee;

public class Cashier extends Employee {
	private int transaction_count;

	public Cashier(long employee_id, String first_name, double appointment_percentage, double base_salary) {
		super(employee_id, first_name, appointment_percentage, base_salary);
		this.transaction_count = 0;
	}

	@Override
	public double calculate_salary() {
		double sal = (this.baseSalary + this.transaction_count) * this.appointmentPercentage;
		return sal;
	}

	public void addTransaction() {
		this.transaction_count += 1;
	}

	@Override
	public String toString() {
		return super.toString() + "Cashier [transaction_count=" + transaction_count + "]";
	}

}
