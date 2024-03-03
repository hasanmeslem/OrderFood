package com.example.orderfood;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class checkout extends AppCompatActivity {

    checkout a=this;
    public static Socket client;
    public static PrintWriter printwriter;
    public static BufferedReader bb;
    public static String messsage;
    public static String m1;
    static int old_all_total;
    static int all_total;

    String personal_preferances;
    Object oo;
    String fin_order_string="";
    public String S;
    static int next_ord_flag;
    static String order_string;
    static String old_ord_string="";

    @Override
    public void onBackPressed() {
        // do nothing.
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        show_Order();
        tot_v();
        oo=this;
    }


    public void show_Order() {
        if (Dessert.chocolate_ice_cream > 0) {
            fin_order_string = fin_order_string + "\nchocolate ice cream-" + String.valueOf(Dessert.chocolate_ice_cream) + ",";
        }
        if (Dessert.vanilla_ice_cream > 0) {
            fin_order_string = fin_order_string + "\nvannila ice cream-" + String.valueOf(Dessert.vanilla_ice_cream) + ",";
        }

        if (Dessert.strawberry_ice_cream > 0) {
            fin_order_string = fin_order_string + "\nstrawberry ice cream-" + String.valueOf(Dessert.strawberry_ice_cream) + ",";
        }
        if (Dessert.falooda > 0) {
            fin_order_string = fin_order_string + "\nfalooda-" + String.valueOf(Dessert.falooda) + ",";
        }
        if (Dessert.brownie_fudge > 0) {
            fin_order_string = fin_order_string + "\nbrownie fudge-" + String.valueOf(Dessert.brownie_fudge) + ",";
        }
        if (Dessert.alpine_chocolate > 0) {
            fin_order_string = fin_order_string + "\nalpine chocolate-" + String.valueOf(Dessert.alpine_chocolate) + ",";
        }
        if (Dessert.devils_delight > 0) {
            fin_order_string = fin_order_string + "\ndevils delite-" + String.valueOf(Dessert.devils_delight) + ",";
        }

        if (Dessert.black_forest > 0) {
            fin_order_string = fin_order_string + "\nblack forest-" + String.valueOf(Dessert.black_forest) + ",";
        }
        if (Dessert.chocolate_lava > 0) {
            fin_order_string = fin_order_string + "\nchocolate lava-" + String.valueOf(Dessert.chocolate_lava) + ",";
        }

        if (Dessert.dutch_almond > 0) {
            fin_order_string = fin_order_string + "\ndutch almond-" + String.valueOf(Dessert.dutch_almond) + ",";
        }
        if (NVeg.chicken_burger > 0) {
            fin_order_string = fin_order_string + "\nchicken burger-" + String.valueOf(NVeg.chicken_burger) + ",";
        }
        if (NVeg.chicken_bbq_pizza > 0) {
            fin_order_string = fin_order_string + "\nchicken bbq pizza-" + String.valueOf(NVeg.chicken_bbq_pizza) + ",";
        }
        if (NVeg.chicken_tikka > 0) {
            fin_order_string = fin_order_string + "\nchicken tikka-" + String.valueOf(NVeg.chicken_tikka) + ",";
        }
        if (NVeg.fried_fish_rice > 0) {
            fin_order_string = fin_order_string + "\nfried fish rice-" + String.valueOf(NVeg.fried_fish_rice) + ",";
        }
        if (NVeg.kolhapuri_chicken > 0) {
            fin_order_string = fin_order_string + "\nkolhapur chicken-" + String.valueOf(NVeg.kolhapuri_chicken) + ",";
        }
        if (NVeg.chicken_noodles > 0) {
            fin_order_string = fin_order_string + "\nchicken noodles-" + String.valueOf(NVeg.chicken_noodles) + ",";
        }
        if (NVeg.chicken_fried_rice > 0) {
            fin_order_string = fin_order_string + "\nchicken fried rice-" + String.valueOf(NVeg.chicken_fried_rice) + ",";
        }

        if (NVeg.chicken_lollipop > 0) {
            fin_order_string = fin_order_string + "\nchicken lollipop-" + String.valueOf(NVeg.chicken_lollipop) + ",";
        }

        if (NVeg.chicken_biryani> 0) {
            fin_order_string = fin_order_string + "\nchicken biryani-" + String.valueOf(NVeg.chicken_biryani) + ",";
        }
        if (NVeg.mutton_biryani> 0) {
            fin_order_string = fin_order_string + "\nmutton biryani-" + String.valueOf(NVeg.mutton_biryani) + ",";
        }

        if (Veg.roti > 0) {
            fin_order_string = fin_order_string + "\nroti-" + String.valueOf(Veg.roti) + ",";
        }
        if (Veg.butter_roti > 0) {
            fin_order_string = fin_order_string + "\nbutter roti-" + String.valueOf(Veg.butter_roti) + ",";
        }
        if (Veg.paneer_tikka > 0) {
            fin_order_string = fin_order_string + "\npaneer tikka-" + String.valueOf(Veg.paneer_tikka) + ",";
        }

        if (Veg.veg_pulao > 0) {
            fin_order_string = fin_order_string + "\nveg pulao-" + String.valueOf(Veg.veg_pulao) + ",";
        }
        if (Veg.mutter_paneer> 0) {
            fin_order_string = fin_order_string + "\nmutter paneer-" + String.valueOf(Veg.mutter_paneer) + ",";
        }
        if (Veg.veg_noodles> 0) {
            fin_order_string = fin_order_string + "\nveg noodles-" + String.valueOf(Veg.veg_noodles) + ",";
        }

        if (Veg.veg_fried_rice> 0) {
            fin_order_string = fin_order_string + "\nveg fried rice-" + String.valueOf(Veg.veg_fried_rice) + ",";
        }
        if (Veg.veg_burger> 0) {
            fin_order_string = fin_order_string + "\nveg burger-" + String.valueOf(Veg.veg_burger) + ",";
        }
        if (Veg.veg_biryani> 0) {
            fin_order_string = fin_order_string + "\nveg briyani-" + String.valueOf(Veg.veg_biryani) + ",";
        }

        if (Veg.paneer_kofta> 0) {
            fin_order_string = fin_order_string + "\npaneer kofta-" + String.valueOf(Veg.paneer_kofta) + ",";
        }
        if (Starters.veg_crispy > 0) {
            fin_order_string = fin_order_string + "\nveg crispy-" + String.valueOf(Starters.veg_crispy) + ",";
        }
        if (Starters.chicken_crispy > 0) {
            fin_order_string = fin_order_string + "\nchicken crispy-" + String.valueOf(Starters.chicken_crispy) + ",";
        }
        if (Starters.paneer_chilly > 0) {
            fin_order_string = fin_order_string + "\npaneer chilly-" + String.valueOf(Starters.paneer_chilly) + ",";
        }
        if (Starters.masala_papad > 0) {
            fin_order_string = fin_order_string + "\nmasala papad-" + String.valueOf(Starters.masala_papad) + ",";
        }
        if (Starters.veg_soup > 0) {
            fin_order_string = fin_order_string + "\nveg soup-" + String.valueOf(Starters.veg_soup) + ",";
        }
        if (Starters.chicken_soup > 0) {
            fin_order_string = fin_order_string + "\nchicken soup-" + String.valueOf(Starters.chicken_soup) + ",";
        }
        if (Starters.tomato_soup > 0) {
            fin_order_string = fin_order_string + "\ntomato soup-" + String.valueOf(Starters.tomato_soup) + ",";
        }
        if (Starters.cheese_pakoda > 0) {
            fin_order_string = fin_order_string + "\ncheese pakoda-" + String.valueOf(Starters.cheese_pakoda) + ",";
        }
        if (Starters.paneer_pakoda > 0) {
            fin_order_string = fin_order_string + "\npaneer pakoda-" + String.valueOf(Starters.paneer_pakoda) + ",";
        }
        if (Starters.chicken_chilly > 0) {
            fin_order_string = fin_order_string + "\nchicken chilly-" + String.valueOf(Starters.chicken_chilly) + ",";
        }
        String temp_order_view=fin_order_string+old_ord_string;
        TextView tv = (TextView) findViewById(R.id.order_final);
        tv.setText("" + temp_order_view);
    }

    public void main_menu(View view) {
        Intent goto_main_menu = new Intent(this, OrderType.class);
        startActivity(goto_main_menu);
        overridePendingTransition(R.anim.fadin, R.anim.fadout);
    }

    public void tot_v(){
        all_total=all_total+old_all_total;
        TextView tv = (TextView) findViewById(R.id.tot_p);
        tv.setText("total price:" + "$" +(checkout.all_total));
    }



    public class SendMessage extends AsyncTask<Void, Void, Void> {
        BufferedReader bb;
        Socket client;
        PrintWriter printwriter;


        @Override
        protected Void doInBackground(Void... params) {
            try {
                client = new Socket("192.168.1.105", 4444); // connect to the server
                printwriter = new PrintWriter(client.getOutputStream(), true);
                bb=new BufferedReader(new InputStreamReader(client.getInputStream()));
                printwriter.println(checkout.messsage); // write the message to output stream
                printwriter.flush();
                m1=bb.readLine();
                bb.close();
                client.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
    public void send_ord(View v){
        order_string=fin_order_string;



        final Object o = this;
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to confirm this order?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        messsage = "Order:" + WelcomeActivity.tablex + "|" + fin_order_string + "|" + Integer.toString(all_total)+"|"+personal_preferances;
                        checkout.SendMessage sendMessageTask = new checkout.SendMessage();
                        sendMessageTask.execute();
                        Intent nextact = new Intent((checkout) o, thankyou.class);
                        startActivity(nextact);
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
}