package center;

import java.util.Arrays;

public class Mall {
    private long id;
    private Store[] stores;
    private String address;

    public Mall(long id, String address) {
        this.id = id;
        this.stores = null;
        this.address = address;
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

    public void addStore(Store s) {
        int i = 0, j = 0;
        Store[] tempStores = null;
        Boolean flag = false;
        if (this.stores == null) {
            tempStores = new Store[1];
            tempStores[0] = s;
        } else {
            tempStores = new Store[this.stores.length + 1];
            for (; i < tempStores.length; i++) {
                if (flag || j < this.stores.length && this.stores[j].getID() <= s.getID()) {
                    tempStores[i] = this.stores[j++];
                } else {
                    tempStores[i] = s;
                    flag = true;
                }
            }
        }
        this.stores = tempStores;
    }

    public void removeStore(Store s) {
        int i = 0, j = 0;
        if (this.stores.length == 1) {
            this.stores = null;
            return;
        }
        Store[] tempStores = new Store[this.stores.length - 1];
        for (; i < this.stores.length; i++) {
            if (this.stores[i] != s) {
                tempStores[j++] = this.stores[i];
            }
        }
        this.stores = tempStores;
    }

    public static Mall findMallById(Mall[] malls, Long ID) {
        if (malls == null) {
            return null;
        }

        for (int i = 0; i < malls.length; i++) {
            if (malls[i].id == ID)
                return malls[i];
        }

        return null;
    }

    public static Mall[] addMallToArray(Mall[] malls, Mall m) {
        Mall[] tempMalls = null;
        int i = 0, j = 0;
        Boolean flag = false;
        if (malls == null) {
            tempMalls = new Mall[1];
            tempMalls[0] = m;
        } else {
            tempMalls = new Mall[malls.length + 1];
            for (; i < tempMalls.length; i++) {
                if (flag || j < malls.length && malls[j].id < m.id) {
                    tempMalls[i] = malls[j++];
                } else {
                    tempMalls[i] = m;
                    flag = true;
                }
            }
        }
        return tempMalls;
    }

    @Override
    public String toString() {
        return "Mall [address=" + address + ", id=" + id + ", stores=" + Arrays.toString(stores) + "]";
    }

    public String getAddress() {
        return address;
    }

    public Store[] getStores() {
        return stores;
    }

}