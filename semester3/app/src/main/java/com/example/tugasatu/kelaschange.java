package com.example.tugasatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import model.datasimpan;

public class kelaschange extends AppCompatActivity {

    private TextInputLayout textInputLayoutnama,textInputLayoutumur,textInputalamat;
    private Button buttonEdit;
    private String namalast, umurlast,alamatlast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kelaschange);



        textInputLayoutnama = findViewById(R.id.textInputLayoutnama);
        textInputLayoutumur = findViewById(R.id.textInputLayoutumur);
        textInputalamat = findViewById(R.id.textInputalamat);
        buttonEdit = findViewById(R.id.buttonEdit);

        //new=melempar
        Intent inttt  = getIntent();
        datasimpan smpn = MainActivity.dataInput.get(inttt.getIntExtra("position",0));

        //ambil
        namalast = smpn.getNama();
        umurlast = smpn.getUmur();
        alamatlast = smpn.getAlamat();


        //textview=>setText
        //textinputlayout=>getedittext.settext

        //ambil
        textInputLayoutnama.getEditText().setText(namalast);
        textInputLayoutumur.getEditText().setText(umurlast);
        textInputalamat.getEditText().setText(alamatlast);


        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                loading.startloading();
//                Handler handler = new Handler();
//                handler.postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        loading.dismissDialog();
//                        finish();
//                    }
//                },1000);

                smpn.setNama(textInputLayoutnama.getEditText().getText().toString().trim());
                smpn.setUmur(textInputLayoutumur.getEditText().getText().toString().trim());
                smpn.setAlamat(textInputalamat.getEditText().getText().toString().trim());

                Intent inn = new Intent(getApplicationContext(),MainActivity.class);
                inn.putExtra("position", getIntent().getIntExtra("position",0));
                startActivity(inn);

                Toast.makeText(getApplicationContext(), "data berhasil diedit", Toast.LENGTH_SHORT).show();

            }
        });
    }

}