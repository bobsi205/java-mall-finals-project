package menus;

import java.util.Scanner;

import center.Chain;
import center.Store;
import center.chain_types.Book_chain;
import center.chain_types.Clothing_chain;
import center.chain_types.Fast_food_chain;
import center.chain_types.Food_chain;
import employee.Employee;
import employee.employee_types.Cashier;
import employee.employee_types.Junior;
import employee.employee_types.Manager;
import employee.employee_types.Senior;

public abstract class MenuOne extends Menu {

    public static Chain[] addChain(Chain[] chains, Scanner sc) {
        Integer type = null;
        String name;
        Chain newChain = null;

        type = scanInt("type", "chain", sc);
        // checks chain type correct

        if (type == null || type > 4 || type < 1) {
            System.out.println("Input ERROR");
            return chains;
        }

        name = scanString("name", "chain", sc);

        // checks name length under 20 and only letters
        if (name == null || name.length() > 20 || !name.matches("[a-zA-Z]+")) {
            System.out.println("input ERROR");
            return chains;
        }

        // checks name is unique
        if (chains != null) {
            for (int i = 0; i < chains.length; i++) {
                if (chains[i].getName().equalsIgnoreCase(name)) {
                    System.out.println("not unique ERROR");
                    return chains;
                }
            }
        }

        switch (type) {
            case 1:
                // clothing
                String importer = scanString("name", "importer", sc);
                // importer name length under 20
                if (importer == null || importer.length() > 20 || !importer.matches("[a-zA-Z]+")) {
                    System.out.println("input ERROR");
                    return chains;
                }
                newChain = new Clothing_chain(name, importer);

                break;
            case 2, 3:
                // food & fast food
                Integer suppliers = scanInt("suppliers", "number of", sc);
                if (suppliers == null || suppliers < 0) {
                    System.out.println("input ERROR");
                    return chains;
                }

                if (type == 2) {
                    // creates food chain
                    newChain = new Food_chain(name, suppliers);
                } else {
                    // creates fast food chain
                    Double bmPrice = scanDouble("price", "business meal", sc);
                    Float studentDiscount = null;
                    if (bmPrice == null || bmPrice < 0) {
                        System.out.println("input ERROR");
                        return chains;
                    }

                    studentDiscount = scanFloat("percentage", "student discount", sc);
                    if (studentDiscount == null || studentDiscount < 0 || studentDiscount > 100) {
                        System.out.println("input ERROR");
                        return chains;
                    }

                    newChain = new Fast_food_chain(name, suppliers, bmPrice, studentDiscount);
                }
                break;

            case 4:
                String bestSeller = scanString("of the week", "best selling auther", sc);
                // checks best seller length
                if (bestSeller == null || bestSeller.length() > 30 || !bestSeller.matches("[a-zA-Z]+")) {
                    System.out.println("input ERROR");
                    return chains;
                }
                newChain = new Book_chain(name, bestSeller);
                break;

        }
        chains = addChainToArray(chains, newChain);
        successMessage("Add chain");
        return chains;

    }

    //////////////////////////////////////////////////////////////////////////////
    public static void addEmployee(Chain[] chains, Scanner sc) {
        String name, tempName, type;
        Long ID, tempID;
        Chain chainPointer = null;
        Store storePointer = null;
        Employee newEmployee = null;
        Double baseSalary, appointmentPercentage;

        name = scanString("name", "employee", sc);
        // name validation
        if (name == null || name.length() > 20 || !name.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        ID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (ID == null || ID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get chain
        tempName = scanString("name", "chain", sc);
        if (tempName == null || !tempName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, tempName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // check id unique

        if (chainPointer.findEmployeeByID(ID) != null) {
            System.out.println("Not unique ERROR");
            return;
        }

        // get store
        tempID = scanLong("ID", "store", sc);
        if (tempID == null || tempID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        storePointer = Store.findStoreByID(chainPointer.getStores(), tempID);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        // get appointment percentage
        appointmentPercentage = scanDouble("percentage", "appointment", sc);
        if (appointmentPercentage == null || appointmentPercentage < 0 || appointmentPercentage > 100) {
            System.out.println("Input ERROR");
            return;
        }
        appointmentPercentage /= 100;

        // get salary
        baseSalary = scanDouble("base salary", "employee", sc);
        if (baseSalary == null || baseSalary < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get type
        type = scanString("type", "employee", sc);
        if (type == null) {
            System.out.println("Input ERROR");
            return;
        }
        switch (type) {
            case "A":
                // manager
                newEmployee = new Manager(ID, name, appointmentPercentage, baseSalary);
                break;
            case "B", "C":
                // junior and senior
                if (type.equals("B")) {
                    // senior
                    newEmployee = new Senior(ID, name, appointmentPercentage, baseSalary);
                } else {
                    // junior
                    newEmployee = new Junior(ID, name, appointmentPercentage, baseSalary);
                }
                break;
            case "D":
                // cashier
                newEmployee = new Cashier(ID, name, appointmentPercentage, baseSalary);
                break;
            default:
                System.out.println("Input ERROR");
                return;
        }

        storePointer.addEmployee(newEmployee);
        chainPointer.addEmployee(newEmployee);
        successMessage("Add employee");
    }

    //////////////////////////////////////////////////////////////

    public static void removeEmployee(Chain[] chains, Scanner sc) {
        Long ID;
        String tempName;
        Chain chainPointer = null;
        Employee e = null;
        Store storePointer = null;

        ID = scanLong("ID", "employee", sc);
        // check if entered value is valid
        if (ID == null || ID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        tempName = scanString("name", "chain", sc);
        // checks if name is valid
        if (tempName == null || !tempName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        // finds chain and return pointer
        chainPointer = Chain.findChainByName(chains, tempName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }
        // find employee in chain if not found returns null
        e = chainPointer.findEmployeeByID(ID);
        if (e == null || e instanceof Senior) {
            System.out.println("Input ERROR");
            return;
        }
        // find store of employee
        storePointer = chainPointer.findStoreOfEmployee(e);
        if (storePointer == null) {
            System.out.println("Input ERROR");
            return;
        }
        if (e instanceof Senior) {
            System.out.println("Input ERROR");
            return;
        }
        // remove employee from chain and store
        chainPointer.removeEmployee(e);
        storePointer.removeEmployee(e);
        successMessage("Remove employee");

    }

    public static void getSumShopping(Chain[] chains, Scanner sc) {
        String tempName;
        Chain chainPointer = null;

        tempName = scanString("name", "chain", sc);
        // checks if name is valid
        if (tempName == null || !tempName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }
        // finds chain and return pointer
        chainPointer = Chain.findChainByName(chains, tempName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }
        System.out.println(
                "\n\n\n\n\n\n\n\n\n" + tempName + " has made a total of: " + chainPointer.getSumShopping() + "$");
    }

    public static void getSumSalaries(Chain[] chains, Scanner sc) {
        String tempName;
        Chain chainPointer = null;

        tempName = scanString("name", "chain", sc);
        // checks if name is valid
        if (tempName == null || !tempName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }
        // finds chain and return pointer
        chainPointer = Chain.findChainByName(chains, tempName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }
        System.out
                .println("\n\n\n\n\n\n\n\n\n" + tempName + " salary total is: " + chainPointer.getSumSalaries() + "$");
    }

    public static void print(Chain[] chains, Scanner sc) {
        String tempName;
        Chain chainPointer = null;

        tempName = scanString("name", "chain", sc);
        // checks if name is valid
        if (tempName == null || !tempName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        // finds chain and return pointer
        chainPointer = Chain.findChainByName(chains, tempName);
        if (chainPointer == null) {
            System.out.println("Input ERROR");
            return;
        }

        System.out.println(chainPointer);
    }

}
