package com.qip.a10500000.qip;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper myDB;
    Spinner droplistItem;
    Button submit;
    TableLayout table;
    TextView tableNamaItem,tableJenisItem,tableUtd,tableBerat,tableQty,lblqty,jnsItem,namaItem;
    EditText itemName, jenisItem, qty, utd, berat
            ,itemId;
    List<String> name;
    List<Integer> id;
    ArrayAdapter<Integer> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        droplistItem = (Spinner) findViewById(R.id.droplistItem);
        itemName = (EditText) findViewById(R.id.itemName);
        jenisItem = (EditText) findViewById(R.id.jenisItem);
        qty = (EditText) findViewById(R.id.qty);
        utd = (EditText) findViewById(R.id.utd);
        berat = (EditText) findViewById(R.id.berat);
        tableNamaItem = (TextView) findViewById(R.id.tableNamaItem);
        tableJenisItem = (TextView) findViewById(R.id.tableJenisItem);
        tableUtd = (TextView) findViewById(R.id.tableUtd);
        tableBerat = (TextView) findViewById(R.id.tableBerat);
        tableQty = (TextView) findViewById(R.id.tableQty);
        table = (TableLayout) findViewById(R.id.table);
        lblqty = (TextView) findViewById(R.id.lblqty);
        namaItem = (TextView) findViewById(R.id.namaItem);
        jnsItem = (TextView) findViewById(R.id.jnsItem);
        lblqty = (TextView) findViewById(R.id.lblqty);



        Log.d("Get Tags", "Getting All Tags");
        //buat 1 penampung buat menampung data yang mau di masukin ke adapter

        id = new ArrayList<Integer>();
        //data yang mau di ambil
        List<ItemSetGet> allitemdataname = myDB.getAllItemData();
        //loopingan buat mengambil semua datanya

        for (ItemSetGet isg : allitemdataname) {
            //syntax buat masukin data ke penampung yang kita tadi buat untuk memasukan data ke adapter
            id.add(isg.getItemId());
        }
        //bikin adapter buat droplistnya
        adapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, id);
        //ngeset droplistnya ngambil data dari adapternya
        droplistItem.setAdapter(adapter);
        droplistItem.setOnItemSelectedListener(this);
        List<String> supplier = new ArrayList<String>();

        List<SupplierSetGet> allsupplierdata = myDB.getAllSupplierData();
        //loopingan buat mengambil semua datanya

        for (SupplierSetGet ssg : allsupplierdata) {
            //syntax buat masukin data ke penampung yang kita tadi buat untuk memasukan data ke adapter
           supplier.add(ssg.getSuplierName());
           supplier.add(ssg.getLocationItem());
           Integer itmid = ssg.getIdItem();
           supplier.add(String.valueOf(itmid));
        }
}
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String list = droplistItem.getItemAtPosition(i).toString();
        Integer lists = Integer.parseInt(list);

        ItemSetGet isg = myDB.getItemData(lists);
        tableNamaItem.setText(isg.getItemName());
        tableUtd.setText(isg.getUTD());
        Integer qty = isg.getQuantity();
        tableQty.setText(String.valueOf(qty));
        Integer brt = isg.getBerat();
        tableBerat.setText(String.valueOf(brt));
        table.setVisibility(View.VISIBLE);
        addDataSupplier(lists);



    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
   /* public void addData() {


        submit = (Button)

                findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                boolean masuk = myDB.insertDataItem(
                        itemName.getText().toString(),
                        jenisItem.getText().toString(),
                        Integer.parseInt(qty.getText().toString()),
                        Integer.parseInt(utd.getText().toString()),
                        Integer.parseInt(berat.getText().toString())
                );

                if (masuk == true) {
                    Toast.makeText(MainActivity.this, "Data Inserted", Toast.LENGTH_LONG).show();
                    id = new ArrayList<Integer>();
                    //data yang mau di ambil
                    List<ItemSetGet> allitemdataname = myDB.getAllItemData();
                    //loopingan buat mengambil semua datanya

                    for (ItemSetGet isg : allitemdataname) {
                        //syntax buat masukin data ke penampung yang kita tadi buat untuk memasukan data ke adapter
                        id.add(isg.getItemId());
                    }
                    adapter = new ArrayAdapter<Integer>(MainActivity.this, android.R.layout.simple_spinner_item, id);
                    droplistItem.setAdapter(adapter);


                } else {
                    Toast.makeText(MainActivity.this, "Data not Inserted", Toast.LENGTH_LONG).show();

                }
            }
        });
    }*/
    public void addDataSupplier(final Integer lists) {


        submit = (Button)

                findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                boolean masukSupplier = myDB.insertDataSupplier(
                        itemName.getText().toString(),
                        jenisItem.getText().toString(),
                        lists


                );

                if (masukSupplier == true) {
                    Toast.makeText(MainActivity.this, "Bisa", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(MainActivity.this, lists.toString(), Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}

