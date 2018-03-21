package com.qip.a10500000.qip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {
    DatabaseHelper myDB;
    Spinner droplistItem;
    Spinner droplistSupplier;
    Button submit;
    TableLayout table,Table;
    TextView tableNamaItem,tableWrin,tableUtd,tableBerat,tableQty,lblqty,namaItem,tableQuantity,tableItemname,tableSuppliername;
    EditText itemName, WRIN, PO, namaSupplier, NegaraAsal,item, utd, berat, qty;
    private EditText Date;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    DatePicker simpleDatePicker;
    Button BtDatePicker,showItem,showSupplier,showDetailPenerimaan,submitItem;
    List<String> name;
    List<Integer> id;
    Integer halal;
    ArrayAdapter<Integer> adapter;
    AutoCompleteTextView komplit;
    LinearLayout showitem,showsupplier;
    ScrollView showdetailpenerimaan;
    boolean valid = false;

    //validasi
    public boolean validasi (){

        item = (EditText) findViewById(R.id.itemName);
        String itemname = item.getText().toString().trim();
        komplit = (AutoCompleteTextView) findViewById(R.id.PO);
        String nopo = komplit.getText().toString().trim();
        halal = null;

        if (itemname.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Item cannot be empty", Toast.LENGTH_LONG).show();
            valid = false;
            return valid;
        }
        else if (nopo.isEmpty()){

            Toast.makeText(getApplicationContext(), "PO# cannot be empty", Toast.LENGTH_LONG).show();
            valid = false;
            return valid;
        }
        else {
            return valid;
        }
    }

    //label Halal & CoAn
   /* public void LabelHalalRadioBtn(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.LabelHalaladasesuai:
                if (checked)
                    if (halal!=1){
                    halal = 1;
                        valid = true;
                    }
                break;
            case R.id.LabelHalaladatidaksesuai:
                if (checked)
                    if (halal!=2){
                        halal = 2;
                        valid = true;
                    }
                break;
            case R.id.LabelHalaltidakada:
                if (checked)
                    if (halal!=3){
                        halal = 3;
                        valid = true;
                    }
                break;
        }
    }*/

   /* public void CoARadioBtn(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.CoAadasesuai:
                if (checked)
                    valid = true;

                break;
            case R.id.CoAadatidaksesuai:
                if (checked)
                    valid = true;
                break;
            case R.id.CoAtidakada:
                if (checked)
                    valid = true;
                break;
        }
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new DatabaseHelper(this);
        droplistItem = (Spinner) findViewById(R.id.droplistItem);
        itemName = (EditText) findViewById(R.id.itemName);
        WRIN = (EditText) findViewById(R.id.WRIN);
        PO = (EditText) findViewById(R.id.PO);
        namaSupplier = (EditText) findViewById(R.id.namaSupplier);
        NegaraAsal = (EditText) findViewById(R.id.NegaraAsal);
        utd = (EditText) findViewById(R.id.utd);
        berat = (EditText) findViewById(R.id.berat);
        qty = (EditText) findViewById(R.id.qty);
        tableNamaItem = (TextView) findViewById(R.id.tableNamaItem);
        table = (TableLayout) findViewById(R.id.table);
        Table = (TableLayout) findViewById(R.id.Table);
        tableQuantity = (TextView) findViewById(R.id.tableQuantity);
        tableItemname = (TextView) findViewById(R.id.tableItemname);
        tableSuppliername = (TextView) findViewById(R.id.tableSuppliername);

        showitem = (LinearLayout) findViewById(R.id.showitem);
        showsupplier = (LinearLayout) findViewById(R.id.showsupplier);
        showdetailpenerimaan = (ScrollView) findViewById(R.id.showdetailpenerimaan);
        showItem = (Button) findViewById(R.id.showItem);
        showSupplier = (Button) findViewById(R.id.showSupplier);
        showDetailPenerimaan = (Button) findViewById(R.id.showDetailPenerimaan);

        showItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdetailpenerimaan.setVisibility(View.GONE);
                showsupplier.setVisibility(View.GONE);
                showitem.setVisibility(View.VISIBLE);
            }
        });

        showDetailPenerimaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdetailpenerimaan.setVisibility(View.VISIBLE);
                showsupplier.setVisibility(View.GONE);
                showitem.setVisibility(View.GONE);
            }
        });

        showSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsupplier.setVisibility(View.VISIBLE);
                showitem.setVisibility(View.GONE);
                showdetailpenerimaan.setVisibility(View.GONE);
            }
        });

        droplistSupplier = (Spinner) findViewById(R.id.droplistSupplier);
        droplistSupplier.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            String stringdroplistsupplier = droplistSupplier.getItemAtPosition(i).toString();
            Integer intdroplistsupplier =  Integer.parseInt(stringdroplistsupplier);

            showSupplierSetGet a = myDB.getsupplier(intdroplistsupplier);
            Integer qtyitem = a.getQuantity();
            tableQuantity.setText(String.valueOf(qtyitem));
            tableItemname.setText(a.getItemName());
            tableSuppliername.setText(a.getSupplierName());
            Table.setVisibility(View.VISIBLE);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


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
        List<Integer> supplier = new ArrayList<Integer>();

        List<SupplierSetGet> allsupplierdata = myDB.getAllSupplierData();
        //loopingan buat mengambil semua datanya

        for (SupplierSetGet ssg : allsupplierdata) {
            //syntax buat masukin data ke penampung yang kita tadi buat untuk memasukan data ke adapter
            supplier.add(ssg.getSuplierId());
        }
        ArrayAdapter<Integer> adaptersupplier = new ArrayAdapter<Integer>(this, android.R.layout.simple_spinner_item, supplier);

        droplistSupplier.setAdapter(adaptersupplier);
        //start date
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);

        Date = (EditText) findViewById(R.id.date);
        BtDatePicker = (Button) findViewById(R.id.bt_datepicker);
        BtDatePicker.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });
}
    @RequiresApi(api = Build.VERSION_CODES.N)
    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        fromDatePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker datePicker, int year, int  monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                Date.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        fromDatePickerDialog.show();
    }
    //end date

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        String list = droplistItem.getItemAtPosition(i).toString();
        Integer lists = Integer.parseInt(list);

        ItemSetGet isg = myDB.getItemData(lists);
        tableNamaItem.setText(isg.getItemName());
        tableWrin.setText(isg.getWRIN());
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
   public void addData() {


        submit = (Button)

                findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                boolean masuk = myDB.insertDataItem(
                        itemName.getText().toString(),
                        WRIN.getText().toString(),
                        Integer.parseInt(qty.getText().toString()),
                        utd.getText().toString(),
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
    }
    public void addDataSupplier(final Integer lists) {


        submit = (Button)

                findViewById(R.id.Submit);
        submit.setOnClickListener(new View.OnClickListener()

        {
            @Override
            public void onClick(View view) {
                boolean masukSupplier = myDB.insertDataSupplier(
                        namaSupplier.getText().toString(),
                        NegaraAsal.getText().toString(),
                        lists


                );

                if (masukSupplier == true) {
                    Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_LONG).show();


                } else {
                    Toast.makeText(MainActivity.this, "data is not inserted", Toast.LENGTH_LONG).show();

                }
            }
        });
    }


}

