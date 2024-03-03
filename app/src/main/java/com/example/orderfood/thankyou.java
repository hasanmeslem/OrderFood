package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class thankyou extends AppCompatActivity {

    Button logout;
    FirebaseAuth mAuth;
    FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        logout=findViewById(R.id.logout);
        mAuth=FirebaseAuth.getInstance();
        user=mAuth.getCurrentUser();

        if(user==null){
            startActivity(new Intent(thankyou.this, loginActivity.class));
        }

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(thankyou.this, loginActivity.class));
            }
        });




    }


    public void main_menu(View view)
    {
        checkout.next_ord_flag=1;
        checkout.old_ord_string= checkout.order_string+ checkout.old_ord_string;
        checkout.old_all_total= checkout.all_total;

        NVeg.chicken_burger=0;
        NVeg.chicken_bbq_pizza=0;
        NVeg.chicken_tikka=0;
        NVeg.fried_fish_rice=0;
        NVeg.kolhapuri_chicken=0;
        NVeg.chicken_noodles=0;
        NVeg.chicken_fried_rice=0;
        NVeg.chicken_lollipop=0;
        NVeg.chicken_biryani=0;
        NVeg.mutton_biryani=0;
        NVeg.n_veg_total=0;

        Starters.veg_crispy=0;
        Starters.chicken_crispy=0;
        Starters.paneer_chilly=0;
        Starters.chicken_chilly=0;
        Starters.masala_papad=0;
        Starters.veg_soup=0;
        Starters.chicken_soup=0;
        Starters.tomato_soup=0;
        Starters.cheese_pakoda=0;
        Starters.paneer_pakoda=0;
        Starters.starters_total=0;

        Veg.roti=0;
        Veg.butter_roti=0;
        Veg.paneer_tikka=0;
        Veg.veg_pulao=0;
        Veg.mutter_paneer=0;
        Veg.veg_noodles=0;
        Veg.veg_fried_rice=0;
        Veg.veg_burger=0;
        Veg.veg_biryani=0;
        Veg.paneer_kofta=0;
        Veg.total_veg=0;

        Dessert.chocolate_ice_cream=0;
        Dessert.vanilla_ice_cream=0;
        Dessert.strawberry_ice_cream=0;
        Dessert.falooda=0;
        Dessert.brownie_fudge=0;
        Dessert.alpine_chocolate=0;
        Dessert.devils_delight=0;
        Dessert.black_forest=0;
        Dessert.chocolate_lava=0;
        Dessert.dutch_almond=0;
        Dessert.dessert_total=0;


        Intent menu= new Intent(this, OrderType.class);
        startActivity(menu);

    }
}