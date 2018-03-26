package com.qip.a10500000.qip;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {
    DatabaseHelper myDB;
    private EditText Date;
    private DatePickerDialog fromDatePickerDialog;
    private SimpleDateFormat dateFormatter;
    Spinner droplistItem,droplistSupplier;
    TableLayout table,Table;
    TextView tableNamaItem,tableWrin,tableUtd,tableBerat,tableQty,lblqty,namaItem,tableQuantity,tableItemname,tableSuppliername;
    EditText itemName, WRIN, PO, namaSupplier, NegaraAsal,item, utd, berat, qty,itemId;
    DatePicker simpleDatePicker;
    Button BtDatePicker,showItem,showSupplier,showDetailPenerimaan,submitItem,submit,submitSupplier;
    List<String> name;
    List<Integer> id;
    Integer halal;
    ArrayAdapter<Integer> adapter;
    AutoCompleteTextView komplit;
    LinearLayout showitem,showsupplier;
    ScrollView showdetailpenerimaan;
    boolean valid = false;
    private String URLAddItem = "http://192.168.0.102/CodeIgniter-3.1.7/api/item/insert";
    private String URLAddSupplier = "http://192.168.0.102/CodeIgniter-3.1.7/api/supplier/insert";


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

        //ID supplier
        showSupplier = (Button) findViewById(R.id.showSupplier);
        showsupplier = (LinearLayout) findViewById(R.id.showsupplier);
        showSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showsupplier.setVisibility(View.VISIBLE);
                showitem.setVisibility(View.GONE);
                showdetailpenerimaan.setVisibility(View.GONE);
            }
        });
        tableSuppliername = (TextView) findViewById(R.id.tableSuppliername);
        /*droplistItem = (Spinner) findViewById(R.id.droplistItem);*/
        table = (TableLayout) findViewById(R.id.table);
        namaSupplier = (EditText) findViewById(R.id.namaSupplier);
        itemId = (EditText) findViewById(R.id.itemId) ;
        NegaraAsal = (EditText) findViewById(R.id.NegaraAsal);
        submitSupplier = (Button) findViewById(R.id.submitSupplier);
        submitSupplier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            new addDataSupplier().execute(URLAddSupplier);
            }
        });

        //ID item
        WRIN = (EditText) findViewById(R.id.WRIN);
        itemName = (EditText) findViewById(R.id.itemName);
        utd = (EditText) findViewById(R.id.utd);
        berat = (EditText) findViewById(R.id.berat);
        qty = (EditText) findViewById(R.id.qty);
        tableNamaItem = (TextView) findViewById(R.id.tableNamaItem);
        tableQuantity = (TextView) findViewById(R.id.tableQuantity);
        tableItemname = (TextView) findViewById(R.id.tableItemname);
        showItem = (Button) findViewById(R.id.showItem);
        showitem = (LinearLayout) findViewById(R.id.showitem);
        showItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdetailpenerimaan.setVisibility(View.GONE);
                showsupplier.setVisibility(View.GONE);
                showitem.setVisibility(View.VISIBLE);
            }
        });
        Table = (TableLayout) findViewById(R.id.Table);
        submitItem = (Button) findViewById(R.id.submitItem);
        submitItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*validasi();*/
                boolean validas = true;
                if (validas==true) {
                    new addDataItem().execute(URLAddItem);
                    Toast.makeText(MainActivity.this, "data inserted", Toast.LENGTH_LONG).show();
                    itemName.setText("");
                    WRIN.setText("");
                    qty.setText("");
                    utd.setText("");
                    berat.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "data is not inserted", Toast.LENGTH_LONG).show();
                    itemName.setText("");
                    WRIN.setText("");
                    qty.setText("");
                    utd.setText("");
                    berat.setText("");
                }
            }

        });

        //ID detail penerimaan
        PO = (EditText) findViewById(R.id.PO);
        showdetailpenerimaan = (ScrollView) findViewById(R.id.showdetailpenerimaan);
        showDetailPenerimaan = (Button) findViewById(R.id.showDetailPenerimaan);
        showDetailPenerimaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showdetailpenerimaan.setVisibility(View.VISIBLE);
                showsupplier.setVisibility(View.GONE);
                showitem.setVisibility(View.GONE);
            }
        });
       /* droplistSupplier = (Spinner) findViewById(R.id.droplistSupplier);
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
        });*/
       /* //buat 1 penampung buat menampung data yang mau di masukin ke adapter
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
*/
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

   /* @Override
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

    }*/
   private class addDataItem extends AsyncTask<String,Void,Void>{

       @Override
       protected Void doInBackground(String... urls) {
           try {
               URL url = new URL(urls[0]);
               JSONObject data = new JSONObject();
               data.put("itemName",itemName.getText().toString().trim());
               data.put("itemWRIN",WRIN.getText().toString().trim());
               data.put("itemQuantity",qty.getText().toString().trim());
               data.put("itemUTD",utd.getText().toString().trim());
               data.put("itemBerat",berat.getText().toString().trim());
//untuk tokoonlie
               String message = data.toString();

               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(message.getBytes().length);
                conn.setRequestProperty("Content-Type","application/json;charset=utf-8");
                conn.setRequestProperty("X-Requested-With","XMLHttpRequest");
                conn.connect();

               OutputStream os = new BufferedOutputStream(conn.getOutputStream());
               os.write(message.getBytes());
               os.flush();
               InputStream is = conn.getInputStream();

           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (JSONException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }

           return null;
       }
   }

   private class addDataSupplier extends AsyncTask<String,Void,Void>{


       @Override
       protected Void doInBackground(String... urls) {

           try {
               URL url = new URL(urls[0]);
               JSONObject data = new JSONObject();
               data.put("supplierName",namaSupplier.getText().toString().trim());
               data.put("negaraAsal",NegaraAsal.getText().toString().trim());
               data.put("itemId",itemId.getText().toString().trim());

               String message = data.toString();

               HttpURLConnection conn = (HttpURLConnection) url.openConnection();
               conn.setRequestMethod("POST");
               conn.setDoInput(true);
               conn.setDoOutput(true);
               conn.setFixedLengthStreamingMode(message.getBytes().length);
               conn.setRequestProperty("Content-Type","application/json;charset=utf-8");
               conn.setRequestProperty("X-Requested-With","XMLHttpRequest");
               conn.connect();

               OutputStream os = new BufferedOutputStream(conn.getOutputStream());
               os.write(message.getBytes());
               os.flush();
               InputStream is = conn.getInputStream();


           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (JSONException e) {
               e.printStackTrace();
           } catch (ProtocolException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           return null;
       }
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

