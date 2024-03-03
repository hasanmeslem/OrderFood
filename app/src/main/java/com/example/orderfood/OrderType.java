package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class OrderType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order__type);
        checkout.all_total= Starters.starters_total+Veg.total_veg+ NVeg.n_veg_total+ Dessert.dessert_total;
    }
    public void starter(View view)
    {
        startActivity(new Intent(OrderType.this, Starters.class));
        overridePendingTransition(R.anim.push_down_in, R.anim.push_down_out);
    }



    public void veg(View view)
    {
        startActivity(new Intent(OrderType.this, Veg.class));
        overridePendingTransition(R.anim.right_left, R.anim.left_right);
    }

    public void nveg(View view)
    {
        startActivity(new Intent(OrderType.this, NVeg.class));
        overridePendingTransition(R.anim.anim_in, R.anim.anim_out);
    }
    public void dessert(View view)
    {
        startActivity(new Intent(OrderType.this, Dessert.class));
        overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
    }

    public void fin_ord(View view)
    {
        final Object o= this;
        if(checkout.all_total>0) {
            startActivity(new Intent(OrderType.this, checkout.class));
            overridePendingTransition(R.anim.fadin, R.anim.fadout);
        }
        else{
            if(checkout.next_ord_flag==1)
            {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Are you sure you don't want to place another order?")
                        .setCancelable(false)
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                startActivity(new Intent(OrderType.this, thankyou.class));
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert = builder.create();
                alert.show();

            }

            else{
                Toast.makeText(getApplicationContext(), "Please select your order", Toast.LENGTH_SHORT).show();
            }

        }
    }
}