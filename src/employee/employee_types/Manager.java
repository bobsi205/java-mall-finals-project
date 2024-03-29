package employee.employee_types;

public class Manager extends Junior {
	private int rank;

	public Manager(long employee_id, String first_name, double appointment_percentage, double base_salary) {
		super(employee_id, first_name, appointment_percentage, base_salary);
		this.transactions = null;
		this.rank = 1;
	}

	@Override
	public double calculate_salary() {
		double sal = this.baseSalary * this.rank * this.appointmentPercentage;
		return sal;
	}

	@Override
	public String toString() {
		return super.toString() + "Manager [rank=" + rank + "]";
	}

}
