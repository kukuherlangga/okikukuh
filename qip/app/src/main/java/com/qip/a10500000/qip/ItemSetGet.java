package com.qip.a10500000.qip;

/**
 * Created by 10.500.000 on 15/03/2018.
 */

public class ItemSetGet {
    String itemName,UTD,WRIN;
    int itemId,Quantity,Berat;

    public String getItemName() { return itemName;}

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUTD() {return UTD;}

    public void setUTD(String UTD) {
        this.UTD = UTD;
    }

    public String getWRIN() {
        return WRIN;
    }

    public void setWRIN(String WRIN) {
        this.WRIN = WRIN;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getBerat() {
        return Berat;
    }

    public void setBerat(int berat) {
        Berat = berat;
    }
}
