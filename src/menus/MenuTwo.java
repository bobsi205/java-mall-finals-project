package menus;

import java.util.Scanner;

import center.Chain;
import center.Mall;
import center.Store;

public abstract class MenuTwo extends Menu {

    public static Mall[] addCenter(Mall[] malls, Scanner sc) {
        // check id and address unique,address max 20 chars
        String address;
        Long ID;
        Mall m = null;

        ID = scanLong("ID", "mall", sc);
        // check if entered value is valid
        if (ID == null || ID < 0) {
            System.out.println("Input ERROR");
            return malls;
        }

        if (Mall.findMallById(malls, ID) != null) {
            System.out.println("Not unique ERROR");
            return malls;
        }

        address = scanString("address", "mall", sc);

        // checks address length under 20 and only letters
        if (address == null || address.length() > 20 || !address.matches("[a-zA-Z]+")) {
            System.out.println("input ERROR");
            return malls;
        }

        // checks address is unique
        if (malls != null) {
            for (int i = 0; i < malls.length; i++) {
                if (malls[i].getAddress().equalsIgnoreCase(address)) {
                    System.out.println("not unique ERROR");
                    return malls;
                }
            }
        }
        m = new Mall(ID, address);
        malls = Mall.addMallToArray(malls, m);
        successMessage("add center");
        return malls;
    }

    /////////////////////////////////////////////////////////////////

    public static void addStore(Mall[] malls, Chain[] chains, Scanner sc) {
        String chainName;
        Chain chainPointer = null;
        Mall mallPointer = null;
        Long ID, mallID;
        Store s = null;

        // get store id
        ID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (ID == null || ID < 0) {
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

        // checks if store id is unique
        if (chainPointer.findStoreById(ID) != null) {
            System.out.println("Not unique ERROR");
            return;
        }

        // get mall
        mallID = scanLong("ID", "mall", sc);
        // check if entered value is valid
        if (mallID == null || mallID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        mallPointer = Mall.findMallById(malls, mallID);
        if (mallPointer == null) {
            System.out.println("Input Error");
            return;
        }

        s = new Store(ID, chainName);
        chainPointer.addStoreToChain(s);
        mallPointer.addStore(s);
        successMessage("add store");
    }

    ///////////////////////////////////////////////////////////
    public static void getSumShopping(Mall[] malls, Scanner sc) {
        Mall mallPointer = null;
        Long mallID;

        // get mall
        mallID = scanLong("ID", "mall", sc);
        // check if entered value is valid
        if (mallID == null || mallID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        mallPointer = Mall.findMallById(malls, mallID);
        if (mallPointer == null) {
            System.out.println("Input Error");
            return;
        }

        // print total revenew of mall
        System.out.println("\n\n\n\n\n\n\n\n\nThe mall has made a total of: " + mallPointer.getSumShopping() + "$");
    }

    /////////////////////////////////////////////////////////

    public static void shiftStore(Mall[] malls, Chain[] chains, Scanner sc) {
        Mall originalMallPointer = null, newMallPointer = null;
        String chainName;
        Chain chainPointer = null;
        Long storeID, originalMallID, newMallID;
        Boolean flag = false;
        Store storePoiner = null;

        // get store id
        storeID = scanLong("ID", "store", sc);
        // check if entered value is valid
        if (storeID == null || storeID < 0) {
            System.out.println("Input ERROR");
            return;
        }

        // get original mall
        originalMallID = scanLong("ID", "original mall", sc);
        // check if entered value is valid
        if (originalMallID == null || originalMallID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        originalMallPointer = Mall.findMallById(malls, originalMallID);
        if (originalMallPointer == null) {
            System.out.println("Input Error");
            return;
        }

        // get store pointer
        storePoiner = Store.findStoreByID(originalMallPointer.getStores(), storeID);

        // get new mall
        newMallID = scanLong("ID", "new mall", sc);
        // check if entered value is valid
        if (newMallID == null || newMallID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        newMallPointer = Mall.findMallById(malls, newMallID);
        if (newMallPointer == null) {
            System.out.println("Input Error");
            return;
        }

        // get chain
        chainName = scanString("name", "chain", sc);
        if (chainName == null || !chainName.matches("[a-zA-Z]+")) {
            System.out.println("Input ERROR");
            return;
        }

        chainPointer = Chain.findChainByName(chains, chainName);
        if (chainPointer == null || !chainName.equals(storePoiner.getChain())) {
            System.out.println("Input ERROR");
            return;
        }

        // return if new mall has no stores
        if (newMallPointer.getStores() == null) {
            System.out.println("Input ERROR");
            return;
        }

        for (Store s : newMallPointer.getStores()) {
            if (s.getChain().equalsIgnoreCase(chainName)) {
                flag = true;
                break;
            }
        }
        // no store with same chain name return
        if (!flag) {
            System.out.println("Input ERROR");
            return;
        }

        newMallPointer.addStore(storePoiner);
        originalMallPointer.removeStore(storePoiner);
        successMessage("shift store");
    }

    public static void print(Mall[] malls, Scanner sc) {
        Mall mallPointer = null;
        Long mallID;

        // get mall
        mallID = scanLong("ID", "mall", sc);
        // check if entered value is valid
        if (mallID == null || mallID < 0) {
            System.out.println("Input ERROR");
            return;
        }
        mallPointer = Mall.findMallById(malls, mallID);
        if (mallPointer == null) {
            System.out.println("Input Error");
            return;
        }

        System.out.println(mallPointer);
    }

}