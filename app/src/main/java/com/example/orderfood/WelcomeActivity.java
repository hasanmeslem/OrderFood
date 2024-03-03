package com.example.orderfood;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class WelcomeActivity extends Activity {

    static int tablex;

    @Override
    public void onBackPressed() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.slimple_text_client, menu);
        return true;
    }

    public void nextact(View view) {

        EditText table = (EditText) findViewById(R.id.table_no);
        if (table.getText().toString().isEmpty()) {

            Toast.makeText(getApplicationContext(),
                    "Please enter your table number", Toast.LENGTH_SHORT).show();
        }


        else {

            Editable newTxt = (Editable) table.getText();
            String tbl_no = newTxt.toString();
            tablex = Integer.parseInt(tbl_no);
            if (tablex<=25 && tablex!=0) {
                startActivity(new Intent(WelcomeActivity.this, OrderType.class));
                overridePendingTransition(R.anim.fadin, R.anim.fadout);
            }
            else{
                Toast.makeText(getApplicationContext(),
                        "Please enter valid table number", Toast.LENGTH_SHORT).show();
            }
        }
    }
}