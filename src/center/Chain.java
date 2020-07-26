package center;

import java.util.Arrays;

import employee.Employee;

public abstract class Chain {
	protected String name;
	protected Employee[] employees;
	protected Store[] stores;

	public Chain(String name) {
		this.name = name;
		this.stores = null;
		this.employees = null;

	}

	public double getSumShopping() {
		double sum = 0;
		if (this.stores != null) {
			for (Store tempStore : this.stores) {
				sum += tempStore.getSumShopping();
			}
		}
		return sum;
	}

	public double getSumSalaries() {
		double sum = 0;
		if (this.employees != null) {
			for (int i = 0; i < this.employees.length; i++) {
				sum += this.employees[i].calculate_salary();
			}
		}
		return sum;
	}

	public Store findStoreById(Long id) {
		if (this.stores == null)
			return null;
		for (int i = 0; i < this.stores.length; i++) {
			if (this.stores[i].getID() == id) {
				return this.stores[i];
			}
		}
		return null;
	}

	public Store findStoreOfEmployee(Employee e) {
		if (this.stores == null) {
			return null;
		}
		for (Store tempStore : this.stores) {
			if (tempStore.getEmployees() != null) {
				if (tempStore.findEmployeeByID(e.getID()) != null) {
					return tempStore;
				}
			}
		}
		return null;
	}

	public Employee findEmployeeByID(long ID) {
		if (this.employees == null)
			return null;
		for (int i = 0; i < this.employees.length; i++) {
			if (this.employees[i].getID() == ID) {
				return this.employees[i];
			}
		}
		return null;
	}

	public void addStoreToChain(Store s) {
		Store[] tempS = null;
		int i = 0, j = 0;
		Boolean flag = false;

		// add store to stores array ordered by id
		if (this.stores == null) {
			tempS = new Store[1];
			tempS[0] = s;

		} else {

			tempS = new Store[this.stores.length + 1];
			for (; i < tempS.length; i++) {
				if (flag || j < this.stores.length && this.stores[j].getID() < s.getID()) {
					tempS[i] = this.stores[j++];
				} else {
					tempS[i] = s;
					flag = true;
				}
			}
		}
		this.stores = tempS;
	}

	// add employee to chain employees arr
	public void addEmployee(Employee e) {
		int i = 0, j = 0;
		Boolean flag = false;
		Employee[] tempEmp;
		if (this.employees == null) {
			tempEmp = new Employee[1];
			tempEmp[0] = e;
		} else {

			tempEmp = new Employee[this.employees.length + 1];
			for (; i < tempEmp.length; i++) {
				if (flag || j < this.employees.length && this.employees[j].getID() < e.getID()) {
					tempEmp[i] = this.employees[j++];
				} else {
					tempEmp[i] = e;
					flag = true;
				}
			}
		}
		this.employees = tempEmp;
	}

	// removes employee from cain employees arr
	public void removeEmployee(Employee e) {
		int i = 0, j = 0;
		if (this.employees.length == 1) {
			this.employees = null;
			return;
		}
		Employee[] tempEmp = new Employee[this.employees.length - 1];
		for (; i < this.employees.length; i++) {
			if (this.employees[i] != e) {
				tempEmp[j++] = this.employees[i];
			}
		}
		this.employees = tempEmp;
	}

	public static Chain findChainByName(Chain[] chains, String name) {
		int i = 0;
		if (chains == null) {
			return null;
		}
		for (; i < chains.length; i++) {
			if (chains[i].name.compareToIgnoreCase(name) == 0) {
				return chains[i];
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Chain name=" + name + ",\nstores=" + Arrays.toString(stores) + "\n"
				+ Employee.printAllEmployeeID(employees) + "]\n";
	}

	public String getName() {
		return name;
	}

	public Store[] getStores() {
		return stores;
	}

}
