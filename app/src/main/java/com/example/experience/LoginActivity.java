package com.example.experience;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class LoginActivity extends AppCompatActivity {
EditText edt_email,edt_password;
Dialog dialog_til;
Button btn_kiru;
ImageView img_earth;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        dialog_til = new Dialog(this);
        edt_email = findViewById(R.id.edt_email);
        img_earth = findViewById(R.id.img_earth);
        btn_kiru = findViewById(R.id.btn_kiru);
        img_earth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_til.setContentView(R.layout.dialog_til);
                dialog_til.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog_til.show();
            }
        });
        edt_password = findViewById(R.id.edt_password);
        btn_kiru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edt_email.getText().toString().equals("admin")&&edt_password.getText().toString().equals("123123")){
                    Intent intent = new Intent(getApplication(),AdminMainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}