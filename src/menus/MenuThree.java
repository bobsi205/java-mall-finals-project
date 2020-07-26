package menus;

import java.util.Scanner;

import center.Chain;
import center.Store;
import employee.Employee;
import employee.employee_type.Cashier;
import employee.employee_type.Junior;
import employee.employee_type.Manager;
import employee.employee_type.Senior;

public abstract class MenuThree extends Menu {

    public static void getSumSalaries(Chain[] chains, Scanner sc) {
        String chainName;
        Long storeID;
        Store storePointer = null;
        Chain chainPointer = null;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        storePointer = chainPointer.findStoreById(storeID);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        System.out.println("\n\n\n\n\n\n\n\n\n store salary total is: " + storePointer.getSumSalaries() + "$");

    }

    public static void getSumShopping(Chain[] chains, Scanner sc) {
        String chainName;
        Long storeID;
        Store storePointer = null;
        Chain chainPointer = null;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        storePointer = chainPointer.findStoreById(storeID);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        System.out.println("\n\n\n\n\n\n\n\n\n store total revenew is: " + storePointer.getSumShopping() + "$");

    }

    public static void shopping(Chain[] chains, Scanner sc) {
        Long storeID, employeeID;
        Store storePointer = null;
        String chainName;
        Chain chainPointer = null;
        Cashier cashierPointer = null;
        Double transactionValue;
        Employee employeePointer = null;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get store pointer
        storePointer = chainPointer.findStoreById(storeID);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get employee
        employeeID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (employeeID == null || employeeID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        employeePointer = storePointer.findEmployeeByID(employeeID);

        if (employeePointer == null || employeePointer instanceof Manager || employeePointer instanceof Cashier) {
            System.out.println("Input ERROR");
            return;
        }

        // get transaction value
        transactionValue = scanDouble("value", "transaction", sc);
        if (transactionValue == null || transactionValue < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get store cashier
        cashierPointer = storePointer.findStoreCashier();
        if (cashierPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        storePointer.addTransaction(transactionValue);
        cashierPointer.addTransaction();
        ((Junior) employeePointer).addTransaction(transactionValue);
        successMessage("shooping");
    }

    ////////////////////////////////////////////////////////////// .

    public static void returningItemp(Chain[] chains, Scanner sc) {
        Long storeID, employeeID;
        Chain chainPointer = null;
        Store storePointer = null;
        Employee employeePointer = null;
        Double transactionValue;
        String chainName;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get store pointer
        storePointer = chainPointer.findStoreById(storeID);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get employee
        employeeID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (employeeID == null || employeeID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        employeePointer = storePointer.findEmployeeByID(employeeID);
        // check if employee is senior
        if (employeePointer == null || !(employeePointer instanceof Senior)) {
            System.out.println("Input ERROR");
            return;
        }

        if (!(storePointer.getChain().equalsIgnoreCase(chainName))) {
            System.out.println("Input ERROR");
            return;
        }

        // get transaction value
        transactionValue = scanDouble("value", "transaction", sc);
        if (transactionValue == null || transactionValue < 0) {
            System.out.println("Input ERROR");
            return;
        }

        ((Senior) employeePointer).addCancledTransaction(transactionValue);
        successMessage("returning  item");

    }

    public static void shiftEmployee(Chain[] chains, Scanner sc) {
        Long originalStoreID, employeeID, newStoreID;
        Chain chainPointer = null;
        Store originalStorePointer = null, newStorePointer = null;
        Employee employeePointer = null;
        String chainName;

        // get original store id
        originalStoreID = scanLong("ID", "original store", sc);
        // check if entered value is valid
        if (originalStoreID == null || originalStoreID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get new store id
        newStoreID = scanLong("ID", "original store", sc);
        // check if entered value is valid
        if (newStoreID == null || newStoreID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get both store pointers
        originalStorePointer = chainPointer.findStoreById(originalStoreID);
        newStorePointer = chainPointer.findStoreById(newStoreID);
        if (originalStorePointer == null || newStorePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get employee
        employeeID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (employeeID == null || employeeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        employeePointer = originalStorePointer.findEmployeeByID(employeeID);
        // check if employee is senior
        if (employeePointer == null || employeePointer instanceof Senior) {
            System.out.println("Input ERROR");
            return;
        }

        // checks that both stores are from the same chain
        if (!(originalStorePointer.getChain().equalsIgnoreCase(chainName)
                || !(newStorePointer.getChain().equalsIgnoreCase(chainName)))) {
            System.out.println("Input ERROR");
            return;
        }

        newStorePointer.addEmployee(employeePointer);
        originalStorePointer.removeEmployee(employeePointer);

        successMessage("shift employee");

    }

    public static void print(Chain[] chains, Scanner sc) {
        Long storeID;
        Store storePointer = null;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        for (Chain chain : chains) {
            storePointer = chain.findStoreById(storeID);
            if (storePointer != null) {
                break;
            }
        }
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        System.out.println(storePointer);
    }

    public static void printEmployee(Chain[] chains, Scanner sc) {
        Long employeeID;
        String chainName;
        Employee employeePointer = null;
        Chain chainPointer = null;

        // get employee
        employeeID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (employeeID == null || employeeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        employeePointer = chainPointer.findEmployeeByID(employeeID);
        if (employeePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        System.out.println(employeePointer);
    }
}