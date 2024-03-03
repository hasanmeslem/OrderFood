package com.example.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerActivity extends AppCompatActivity {

    EditText etemail;
    EditText etpassword;
    Button btnreg;
    FirebaseAuth mAuth;
    ProgressBar prg;

    CheckBox ch;

    @Override
    public void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        currentUser=null;
        if(currentUser != null){
            startActivity(new Intent(registerActivity.this, WelcomeActivity.class));

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth=FirebaseAuth.getInstance();
        ch=findViewById(R.id.checkBox);
        etemail=findViewById(R.id.email);
        etpassword=findViewById(R.id.password);
        btnreg=findViewById(R.id.btnreg);
        prg=findViewById(R.id.pgbarreg);



        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prg.setVisibility(View.VISIBLE);
                String email,password;
                email=String.valueOf(etemail.getText());
                password=String.valueOf(etpassword.getText());

                if(TextUtils.isEmpty(email)){
                    Toast.makeText(registerActivity.this, "Enter Your Email", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(TextUtils.isEmpty(password)){
                    Toast.makeText(registerActivity.this, "Enter Your Password", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(!ch.isChecked()){
                    Toast.makeText(registerActivity.this, "Please accept our Terms and Conditions", Toast.LENGTH_SHORT).show();
                }


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                prg.setVisibility(View.GONE);
                                if (task.isSuccessful()) {
                                    Toast.makeText(registerActivity.this, "registered successfully", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(registerActivity.this, WelcomeActivity.class));




                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(registerActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });
    }

    public void login(View view) {
        startActivity(new Intent(registerActivity.this, loginActivity.class));
    }

    public void Welcome(View view) {
        startActivity(new Intent(registerActivity.this, WelcomeActivity.class));
    }

}