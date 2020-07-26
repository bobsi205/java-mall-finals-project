package employee;

public abstract class Employee {
	protected long ID;
	protected String firstName;
	protected double appointmentPercentage;
	protected double baseSalary;

	public abstract double calculate_salary();

	public Employee(long ID, String firstName, double appointmentPercentage, double baseSalary) {
		this.ID = ID;
		this.firstName = firstName;
		this.appointmentPercentage = appointmentPercentage;
		this.baseSalary = baseSalary;
	}

	public static String printAllEmployeeID(Employee[] arr) {
		if (arr == null) {
			return ", No emplpyees ";
		}
		String s = "Employees IDs:  ";
		for (int i = 0; i < arr.length; i++) {
			s += arr[i].ID;
			if (i < arr.length - 1)
				s += ", ";
		}
		return s;
	}

	@Override
	public String toString() {
		return "[ID=" + ID + ", baseSalary=" + baseSalary + ", firstName=" + firstName
				+ ", Employee appointmentPercentage=" + appointmentPercentage + "%]";
	}

	public long getID() {
		return this.ID;
	}

}
