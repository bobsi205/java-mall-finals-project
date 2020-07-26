package center;

import java.util.Arrays;

import employee.Employee;
import employee_type.Cashier;
import employee_type.Senior;

public class Store {
    private long ID; // need to check unique
    private String chain; // needs to point to a chain
    private Employee[] employees;// sort by employee id
    private double[] transactions;

    // constructor
    public Store(long ID, String chain) {
        this.ID = ID;
        this.chain = chain;
        this.employees = null;
        this.transactions = null;
    }

    // getters

    public double getSumShopping() {
        double sum = 0;
        if (this.transactions != null) {

            for (double price : this.transactions) {
                sum += price;
            }
            for (int i = 0; i < this.employees.length; i++) {
                if (this.employees[i] instanceof Senior) {
                    Senior tempSenior = (Senior) this.employees[i];
                    double[] tempCancel = tempSenior.getCancelled_transactions();

                    if (tempCancel != null) {
                        for (int j = 0; j < tempCancel.length; i++) {
                            sum -= tempCancel[j];
                        }
                    }
                }
            }
        }
        return sum;
    }

    public void addTransaction(double value) {
        int i = 0;
        double[] tempTransactions;
        if (this.transactions == null) {
            tempTransactions = new double[1];
            tempTransactions[0] = value;
        } else {
            tempTransactions = new double[this.transactions.length + 1];
            for (; i < this.transactions.length; i++) {
                tempTransactions[i] = this.transactions[i];
            }
            tempTransactions[i] = value;
        }
        this.transactions = tempTransactions;
    }

    public Boolean returningItem(double transaction_value, long employee_id) {
        if (this.employees != null) {
            for (Employee e : this.employees) {
                if (e.getID() == employee_id) {
                    if (e instanceof Senior) {
                        Senior s = (Senior) e;
                        s.addCancledTransaction(transaction_value);
                        return true;
                    }
                }
            }
        }
        return false;
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

    // find store cashier
    public Cashier findStoreCashier() {
        if (this.employees == null) {
            return null;
        }
        // find cashier
        for (Employee employee : this.employees) {
            if (employee instanceof Cashier) {
                return (Cashier) employee;
            }
        }
        return null;
    }

    // add employee to store employees arr
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

    // removes employee from store employees arr
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

    public static Store findStoreByID(Store[] stores, Long ID) {
        int i = 0;
        if (stores == null) {
            return null;
        }
        for (; i < stores.length; i++) {
            if (stores[i].ID == ID) {
                return stores[i];
            }
        }
        return null;
    }

    public static Boolean checkUniqueStoreId(Store[] stores, long id) {
        if (stores == null) {
            return true;
        }
        for (int i = 0; i < stores.length; i++) {
            if (stores[i].ID == id) {
                return false;
            }
        }
        return true;
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

    @Override
    public String toString() {
        return "Store [chain=" + chain + ", employees=" + Arrays.toString(employees) + ", id=" + ID + ", transactions="
                + Arrays.toString(transactions) + "]";
    }

    public String getChain() {
        return chain;
    }

    public long getID() {
        return ID;
    }

    public Employee[] getEmployees() {
        return employees;
    }

}
