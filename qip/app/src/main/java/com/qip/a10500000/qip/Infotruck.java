package com.qip.a10500000.qip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

/**
 * Created by 10.500.000 on 21/03/2018.
 */

public class Infotruck extends AppCompatActivity {
    Button Submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_truck );
        Submit = (Button) findViewById(R.id.Submit);
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void JenisTruckRadioBtn(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.ReeferContainer:
                if (checked)

                    break;
            case R.id.DryContainer:
                if (checked)

                    break;
        }
    }


    public void BagusLayakRadioBtn(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.YBagusLayak:
                if (checked)

                    break;
            case R.id.NBagusLayak:
                if (checked)

                    break;
        }
    }


    public void BerbautajamRadioBtn(View view) {
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.YBerbautajam:
                if (checked)

                    break;
            case R.id.NBerbautajam:
                if (checked)

                    break;
        }


    }

    public void SegelutuhRadioBtn (View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.YSegelutuh:
                if (checked)
                    break;
            case R.id.NSegelutuh:
                if (checked)
                    break;
        }
    }

    public void InfestasihamaRadioBtn (View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.YInfestasihama:
                if (checked)
                    break;
            case R.id.NInfestasihama:
                if (checked)
                    break;
        }
    }

    public void KotorberdebuRadioBtn (View view){
        boolean checked = ((RadioButton) view).isChecked();

        switch (view.getId()){
            case R.id.YKotorberdebu:
                if (checked)
                    break;
            case R.id.NKotorberdebu:
                if (checked)
                    break;
        }
    }
}
