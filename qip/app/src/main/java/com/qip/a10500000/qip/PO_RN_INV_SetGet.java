package com.qip.a10500000.qip;

import java.util.Date;

/**
 * Created by 10.500.000 on 20/03/2018.
 */

public class PO_RN_INV_SetGet {
    String recvtype, statusrn, statuspo, tlno,
            statustally, pouom, rnno, parterdnno,rndate, createdate, gendate, deliverydate, podate;
    int buId,Idsupplier, IdItem, orderqty,shippedqty,costprice, costamount;

    public int getBuId() {
        return buId;
    }

    public void setBuId(int buId) {
        this.buId = buId;
    }

    public String getRecvtype() {
        return recvtype;
    }

    public void setRecvtype(String recvtype) {
        this.recvtype = recvtype;
    }

    public String getStatusrn() {
        return statusrn;
    }

    public void setStatusrn(String statusrn) {
        this.statusrn = statusrn;
    }

    public String getStatuspo() {
        return statuspo;
    }

    public void setStatuspo(String statuspo) {
        this.statuspo = statuspo;
    }

    public String getTlno() {
        return tlno;
    }

    public void setTlno(String tlno) {
        this.tlno = tlno;
    }

    public String getStatustally() {
        return statustally;
    }

    public void setStatustally(String statustally) {
        this.statustally = statustally;
    }

    public String getPouom() {
        return pouom;
    }

    public void setPouom(String pouom) {
        this.pouom = pouom;
    }

    public String getRnno() {
        return rnno;
    }

    public void setRnno(String rnno) {
        this.rnno = rnno;
    }

    public String getParterdnno() {
        return parterdnno;
    }

    public void setParterdnno(String parterdnno) {
        this.parterdnno = parterdnno;
    }

    public String getRndate() {
        return rndate;
    }

    public void setRndate(String rndate) {
        this.rndate = rndate;
    }

    public String getCreatedate() {
        return createdate;
    }

    public void setCreatedate(String createdate) {
        this.createdate = createdate;
    }

    public String getGendate() {
        return gendate;
    }

    public void setGendate(String gendate) {
        this.gendate = gendate;
    }

    public String getDeliverydate() {
        return deliverydate;
    }

    public void setDeliverydate(String deliverydate) {
        this.deliverydate = deliverydate;
    }

    public String getPodate() {
        return podate;
    }

    public void setPodate(String podate) {
        this.podate = podate;
    }

    public int getIdsupplier() {
        return Idsupplier;
    }

    public void setIdsupplier(int idsupplier) {
        Idsupplier = idsupplier;
    }

    public int getIdItem() {
        return IdItem;
    }

    public void setIdItem(int idItem) {
        IdItem = idItem;
    }

    public int getOrderqty() {
        return orderqty;
    }

    public void setOrderqty(int orderqty) {
        this.orderqty = orderqty;
    }

    public int getShippedqty() {
        return shippedqty;
    }

    public void setShippedqty(int shippedqty) {
        this.shippedqty = shippedqty;
    }

    public int getCostprice() {
        return costprice;
    }

    public void setCostprice(int costprice) {
        this.costprice = costprice;
    }

    public int getCostamount() {
        return costamount;
    }

    public void setCostamount(int costamount) {
        this.costamount = costamount;
    }
}
