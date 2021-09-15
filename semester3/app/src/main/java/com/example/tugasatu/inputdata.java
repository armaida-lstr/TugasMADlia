package com.example.tugasatu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.ContentLoadingProgressBar;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.datasimpan;

public class inputdata extends AppCompatActivity {


    private ImageButton imageButtonback;
    private TextInputLayout textInputLayout_nama;
    private TextInputLayout textInputLayout_umur;
    private  TextInputLayout textInputLayout_alamat;
    private Button button_save;
    private loading loading = new loading(inputdata.this);
    private String nama, umur, alamat, gambar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata);

        initView();
        setListener();
    }

    private void initView() {
        textInputLayout_nama = findViewById(R.id.textInputLayout_nama);
        textInputLayout_umur = findViewById(R.id.textInputLayout_umur);
        textInputLayout_alamat = findViewById(R.id.textInputLayout_alamat);
        button_save = findViewById(R.id.button_save);
        imageButtonback = findViewById(R.id.imageButtonback);
      //  tombolfull = findViewById(R.id. tombolfull);
    }

    private void setListener(){
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = textInputLayout_nama.getEditText().getText().toString().trim();
                String umur = textInputLayout_umur.getEditText().getText().toString().trim();
                String alamat = textInputLayout_alamat.getEditText().getText().toString().trim();
            //   String gambar = textInputLayout_alamat.getEditText().getText().toString().trim();


                Intent intent = new Intent();
                datasimpan temp = new datasimpan(nama, umur, alamat, gambar);
                intent.putExtra("inputdata", temp);
                setResult(200, intent);

                loading.startloading();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loading.dismissDialog();
                        finish();
                    }
                },1000);

                Toast.makeText(getApplicationContext(), "data berhasil disimpan", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentt= new Intent (getBaseContext(), MainActivity.class);
                startActivity(intentt);

            }
        });
//        tombolfull.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intt= new Intent (getBaseContext(), Mai.class);
//                startActivity(intt);
//            }
//        });


    }

}