package com.qip.a10500000.qip;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10.500.000 on 15/03/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String LOG = "DatabaseHelper";

    public static final String DATABASE_NAME = "QIPDatabase";
    //table Item
    public static final String TABLE_ITEM = "t_item";
    public static final String COL_ITEM1 = "itemId";
    public static final String COL_ITEM2 = "itemName";
    public static final String COL_ITEM3 = "WRIN";
    public static final String COL_ITEM4 = "Quantity";
    public static final String COL_ITEM5 = "UTD";
    public static final String COL_ITEM6 = "Berat";
    //end of table item

    //table suplier
    public static final String TABLE_SUPLIER = "t_suplier";
    public static final String COL_SUPLIER1 = "suplierId";
    public static final String COL_SUPLIER2 = "suplierName";
    public static final String COL_SUPLIER3 = "locationItem";
    public static final String COL_SUPLIER4 = "IdItem";
    //end of table suplier

    //table truck info
    public static final String TABLE_INFO_TRUCK = "t_info_truck";
    public static final String COL_TRUCK_INFO1 = "truckId";
    public static final String COL_TRUCK_INFO2 = "Idtruckcondition";
    public static final String COL_TRUCK_INFO3 = "Idsuhutruck";
    public static final String COL_TRUCK_INFO4 = "Idjenistruck";
    //end of table truck info

    //teble jenis truck
    public static final String TABLE_JENIS_TRUCK = "t_jenis_truck";
    public static final String COL_JENIS_TRUCK1 = "jenistruckId";
    public static final String COL_JENIS_TRUCK2 = "reefercontainer";
    public static final String COL_JENIS_TRUCK3 = "drycontainer";
    //end of table jenis truck

    //table suhu truck
    public static final String TABLE_SUHU_TRUCK = "t_suhu_truck";
    public static final String COL_SUHU_TRUCK1 = "suhutruckId";
    public static final String COL_SUHU_TRUCK2 = "setting";
    public static final String COL_SUHU_TRUCK3 = "display";
    public static final String COL_SUHU_TRUCK4 = "actualphyrometer";
    //end of table suhu truck

    //table truck condition
    public static final String TABLE_TRUCK_CONDITION = "t_truck_condition";
    public static final String COL_TRUCK_CONDITION1 = "truckconditionId";
    public static final String COL_TRUCK_CONDITION2= "baguslayak";
    public static final String COL_TRUCK_CONDITION3 = "berbautajam";
    public static final String COL_TRUCK_CONDITION4 = "segelutuhsesuai";
    public static final String COL_TRUCK_CONDITION5= "infestasihama";
    public static final String COL_TRUCK_CONDITION6 = "kotorberdebu";
    //end of table truck condition

    //tabel data
    public static final String TABLE_DATA = "t_data";
    public static final String COL_DATA1 = "sealId";
    public static final String COL_DATA2 = "Idpo";
    //end of table data

    //tabel label halal
    public static final String TABLE_LABEL = "t_label";
    public static final String COL_LABEL1 = "labelId";
    public static final String COL_LABEL2 = "adasesuai";
    public static final String COL_LABEL3 = "adatidaksesuai";
    public static final String COL_LABEL4 = "tidakada";
    //end of table label halal

    //table coa
    public static final String TABLE_COA = "t_coa";
    public static final String COL_coa1 = "coaId";
    public static final String COL_coa2 = "adasesuai";
    public static final String COL_coa3 = "adatidaksesuai";
    public static final String COL_coa4 = "tidakada";
    //end of table coa

    //table Qip criteria
    public static final String TABLE_QIPCRITERIA = "t_qipcriteria";
    public static final String COL_QIPCRITERIA1 =  "criteriaId";
    public static final String COL_QIPCRITERIA2 =  "Idjenisitem";
    public static final String COL_QIPCRITERIA3 =  "criteriadesc";
    public static final String COL_QIPCRITERIA4 =  "standatreceive";
    public static final String COL_QIPCRITERIA5 =  "cs1_utd";
    public static final String COL_QIPCRITERIA6=  "cs2_utd";
    public static final String COL_QIPCRITERIA7 =  "cs3_utd";
    public static final String COL_QIPCRITERIA8 =  "cs4_utd";
    public static final String COL_QIPCRITERIA9 =  "cs5_utd";
    public static final String COL_QIPCRITERIA10 =  "cs1_sampling";
    public static final String COL_QIPCRITERIA11 =  "cs2_sampling";
    public static final String COL_QIPCRITERIA12 =  "cs3_sampling";
    public static final String COL_QIPCRITERIA13 =  "cs4_sampling";
    public static final String COL_QIPCRITERIA14 =  "cs5_sampling";
    //end of table Qip criteria

    //table jenis item
    public static final String TABLE_JENIS_ITEM = "t_jenisitem";
    public static final String COL_JENIS_ITEM1 =  "jenisitemId";
    public static final String COL_JENIS_ITEM2 =  "jenisitem";
    //end of table jenis item

    //table po_rn_inv
    public static final String TABLE_PO_RN_INV = "t_po_rn_inv";
    public static final String COL_PO_RN_INV1 =  "recvtype";
    public static final String COL_PO_RN_INV2 =  "statusrn";
    public static final String COL_PO_RN_INV3 =  "statuspo";
    public static final String COL_PO_RN_INV4 =  "tlno";
    public static final String COL_PO_RN_INV5 =  "statustally";
    public static final String COL_PO_RN_INV6 =  "pouom";
    public static final String COL_PO_RN_INV7 =  "rnno";
    public static final String COL_PO_RN_INV8 =  "parterdnno";
    public static final String COL_PO_RN_INV9 =  "rndate";
    public static final String COL_PO_RN_INV10 =  "createdate";
    public static final String COL_PO_RN_INV11=  "gendate";
    public static final String COL_PO_RN_INV12 =  "deliverydate";
    public static final String COL_PO_RN_INV13 =  "podate";
    public static final String COL_PO_RN_INV14 =  "buId";
    public static final String COL_PO_RN_INV15 =  "IdItem";
    public static final String COL_PO_RN_INV16 =  "orderqty";
    public static final String COL_PO_RN_INV17 =  "shippedqty";
    public static final String COL_PO_RN_INV18 =  "costprice";
    public static final String COL_PO_RN_INV19 =  "costamount";
    //end of table po_rn_inv

    //table qip
    public static final String TABLE_QIP = "t_qip";
    public static final String COl_QIP1 = "qipId";
    public static final String COl_QIP2 = "Idsupplier";
    public static final String COl_QIP3 = "Idtruck";
    public static final String COl_QIP4 = "Idseal";
    public static final String COl_QIP5 = "Idlabel";
    public static final String COl_QIP6 = "Idcoa";
    public static final String COl_QIP7 = "qipdate";
    //end of table qip


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }
    SQLiteDatabase db = this.getWritableDatabase();

    @Override
    public void onCreate(SQLiteDatabase db) {
        //database
        db.execSQL("create table " + TABLE_ITEM + " (itemId INTEGER PRIMARY KEY AUTOINCREMENT,itemName TEXT," +
                "WRIN TEXT, Quantity INTEGER,UTD TEXT,Berat INTEGER)");

        db.execSQL("create table " + TABLE_JENIS_ITEM + " (jenisitemId INTEGER PRIMARY KEY NOT NULL,Idcriteria INTEGER," +
                "jenisitem TEXT,FOREIGN KEY (Idcriteria) REFERENCES t_qipcriteria(criteriaId) )");

        db.execSQL("create table " + TABLE_SUPLIER + " (suplierId INTEGER PRIMARY KEY AUTOINCREMENT,suplierName TEXT," +
                "locationItem TEXT,IdItem INTEGER,FOREIGN KEY (IdItem) REFERENCES t_item (itemId))");

        db.execSQL("create table " + TABLE_LABEL + " (labelId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "adasesuai TEXT,adatidaksesuai TEXT,tidakada TEXT )");

        db.execSQL("create table " + TABLE_COA + " (coaId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "adasesuai TEXT,adatidaksesuai TEXT,tidakada TEXT )");

        db.execSQL("create table " + TABLE_INFO_TRUCK + " (truckId INTEGER PRIMARY KEY AUTOINCREMENT,Idtruckcondition INTEGER," +
                "Idsuhutruck INTEGER,Idjenistruck INTEGER,Idseal INTEGER,FOREIGN KEY (Idjenistruck) REFERENCES t_jenis_truck(jenistruckId)," +
                "FOREIGN KEY (Idsuhutruck) REFERENCES t_suhu_truck(suhutruckId)," +
                "FOREIGN KEY (Idtruckcondition)REFERENCES t_truck_condition(truckconditionId))");

        db.execSQL("create table " + TABLE_JENIS_TRUCK + " (jenistruckId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "reefercontainer TEXT,drycontainer TEXT)");

        db.execSQL("create table " + TABLE_SUHU_TRUCK + " (suhutruckId INTEGER PRIMARY KEY AUTOINCREMENT,setting INTEGER," +
                "display INTEGER,actualphyrometer INTEGER)");

        db.execSQL("create table " + TABLE_TRUCK_CONDITION + " (truckconditonId INTEGER PRIMARY KEY AUTOINCREMENT,baguslayak TEXT," +
                "berbautajam TEXT,segelutuhsesuai TEXT,infestasihama TEXT,kotorberdebu TEXT)");

        db.execSQL("create table " + TABLE_DATA + " (sealId INTEGER PRIMARY KEY AUTOINCREMENT," +
                "poId TEXT)");

        db.execSQL("create table " + TABLE_QIPCRITERIA + " (criteriaId INTEGER PRIMARY KEY, Idjenisitem INTEGER," +
                "criteriadesc TEXT,standatreceive TEXT,cs1_utd TEXT,cs2_utd TEXT,cs3_utd TEXT,cs4_utd TEXT,cs5_utd TEXT," +
                "cs1_sampling TEXT, cs2_samplingTEXT, cs3_sampling TEXT, cs4_sampling TEXT,cs5_sampling TEXT)");

        db.execSQL("create table " + TABLE_PO_RN_INV + " (buId INTEGER PRIMARY KEY AUTOINCREMENT,Iditem INTEGER," +
                "recvtype TEXT, statusrn TEXT, statuspo TEXT, tlno TEXT, statustally TEXT, pouom TEXT, rnno INTEGER, parterdnno INTEGER," +
                "orderqty INTEGER, shippedqty INTEGER, costprice INTEGER, costamount INTEGER," +
                " rndate TEXT, createdate TEXT, gendate TEXT, deliverydate TEXT, podate TEXT," +
                " FOREIGN KEY (Iditem) REFERENCES TABLE_ITEM (itemId))");

        db.execSQL("create table " + TABLE_QIP + " (qipId INTEGER PRIMARY KEY AUTOINCREMENT,Idsupplier INTEGER," +
                "Idtruck INTEGER,Idseal INTEGER,Idlabel INTEGER,Idcoa INTEGER,qipdate TEXT,FOREIGN KEY (Idsupplier)REFERENCES t_supplier(supplierId)," +
                "FOREIGN KEY (Idtruck) REFERENCES t_info_truck(truckId),FOREIGN KEY (Idseal) REFERENCES t_data(sealId)," +
                "FOREIGN KEY(Idlabel)REFERENCES t_label(labelId),FOREIGN KEY(Idcoa)REFERENCES t_coa(coaId))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_SUPLIER);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_INFO_TRUCK);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_JENIS_ITEM);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_LABEL);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_QIP);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PO_RN_INV);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QIPCRITERIA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_DATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRUCK_CONDITION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUHU_TRUCK);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_JENIS_TRUCK);

        onCreate(db);
    }
    // insertData(variable yang mau dimasukin)
    public boolean insertDataItem(String itemName,String WRIN,Integer qty,String utd,Integer berat) {
        //ngebuka database
        SQLiteDatabase db = this.getWritableDatabase();
        //bikin contentvalues "content values untuk menampung data biar dimasukin ke database"
        ContentValues contentValues = new ContentValues();
        //contentValues.put(nama kolom table,nama variable yang mau dimasukin);
        contentValues.put(COL_ITEM2,itemName);
        contentValues.put(COL_ITEM3,WRIN);
        contentValues.put(COL_ITEM4,qty);
        contentValues.put(COL_ITEM5,utd);
        contentValues.put(COL_ITEM6,berat);
        //long "untuk membuat 1 array untuk menampung semua data yang mau dimasukin"
        long result = db.insert(TABLE_ITEM,null ,contentValues);
        //ngecek kalo data udah masuk
        return result != -1;
        //nge return booleannya jadi true ke mainActivity.java
    }
    //ItemSetGet "nama java class yang mengandung seter geter" (variable yang mau di cek)
    public ItemSetGet getItemData(Integer itemId) {
        //ngebuka database
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectQuery = SELECT *"semua data" FROM namatable WHERE kolomyangmaudicek = variableyangmaudicek
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM + " WHERE "
                + COL_ITEM1 + " = " + itemId;

        Log.e(LOG, selectQuery);
        //cursor untuk mengambil data RAW"belum di proses"
        Cursor c = db.rawQuery(selectQuery, null);
        //bila ()
        if (c != null)
            //maju ke rowpertama
            c.moveToFirst();
        //ngebuat ItemSetGet baru untuk memasukan namanya
        ItemSetGet ist = new ItemSetGet();
        //setItemName didapat dari setergeterclassnya  , getclolumnindex buat ngambil kolom yang mana
        ist.setItemName(c.getString(c.getColumnIndex(COL_ITEM2)));
        ist.setWRIN(c.getString(c.getColumnIndex(COL_ITEM3)));
        ist.setQuantity(c.getInt(c.getColumnIndex(COL_ITEM4)));
        ist.setUTD(c.getString(c.getColumnIndex(COL_ITEM5)));
        ist.setBerat(c.getInt(c.getColumnIndex(COL_ITEM6)));


        //return data yang udah dibaca buat dilempar ke MainActivity.java
        return ist;
    }


    public boolean insertDataSupplier(String suplierName,String locationItem,Integer IdItem) {
        //ngebuka database
        String query = "select * from t_item where itemid ="+ IdItem;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        //bikin contentvalues "content values untuk menampung data biar dimasukin ke database"
        ContentValues contentValues = new ContentValues();
        //contentValues.put(nama kolom table,nama variable yang mau dimasukin);
        contentValues.put(COL_SUPLIER2,suplierName);
        contentValues.put(COL_SUPLIER3,locationItem);
        contentValues.put(COL_SUPLIER4,IdItem);
        //long "untuk membuat 1 array untuk menampung semua data yang mau dimasukin"
        long result = db.insert(TABLE_SUPLIER,null ,contentValues);
        //ngecek kalo data udah masuk
        return result != -1;
        //nge return booleannya jadi true ke mainActivity.java
    }

    public List<ItemSetGet> getAllItemData() {
        List<ItemSetGet> itemsetget = new ArrayList<ItemSetGet>();
        String selectQuery = "SELECT  * FROM " + TABLE_ITEM;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (!selectQuery.isEmpty()) {
            if (c.moveToFirst()) {
                do {
                    ItemSetGet ist = new ItemSetGet();
                    ist.setItemName(c.getString(c.getColumnIndex(COL_ITEM2)));
                    ist.setItemId(c.getInt(c.getColumnIndex(COL_ITEM1)));


                    // adding to item
                    itemsetget.add(ist);
                } while (c.moveToNext());
            }

            return itemsetget;
        }else {
            return null;
        }
    }

    public List<SupplierSetGet> getAllSupplierData() {
        List<SupplierSetGet> supplierSetGets = new ArrayList<SupplierSetGet>();
        String selectQuery = "SELECT  * FROM " + TABLE_SUPLIER;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (!selectQuery.isEmpty()) {
            if (c.moveToFirst()) {
                do {
                    SupplierSetGet sst = new SupplierSetGet();
                    sst.setSuplierId(c.getInt(c.getColumnIndex(COL_SUPLIER1)));


                    // adding to item
                    supplierSetGets.add(sst);
                } while (c.moveToNext());
            }

            return supplierSetGets;
        }else {
            return null;
        }
    }

    public showSupplierSetGet getsupplier(Integer supId) {
        SQLiteDatabase db = this.getReadableDatabase();
        //String selectQuery = SELECT *"semua data" FROM namatable WHERE kolomyangmaudicek = variableyangmaudicek
        String selectQuery = "SELECT  * FROM t_item i INNER JOIN t_suplier s ON i.itemId=s.IdItem WHERE s.suplierId=? ";


        Log.e(LOG, selectQuery);
        //cursor untuk mengambil data RAW"belum di proses"
        Cursor c = db.rawQuery(selectQuery, new String[]{String.valueOf(supId)});
        //bila ()
        if (c != null)
            //maju ke rowpertama
            c.moveToFirst();
        //ngebuat ItemSetGet baru untuk memasukan namanya
        showSupplierSetGet ist = new showSupplierSetGet();
        //setItemName didapat dari setergeterclassnya  , getclolumnindex buat ngambil kolom yang mana
        ist.setItemName(c.getString(c.getColumnIndex(COL_ITEM2)));
        ist.setQuantity(c.getInt(c.getColumnIndex(COL_ITEM4)));
        ist.setSupplierName(c.getString(c.getColumnIndex(COL_SUPLIER2)));

        //return data yang udah dibaca buat dilempar ke MainActivity.java
        return ist;
    }



}
