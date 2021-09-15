package com.example.tugasatu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import model.datasimpan;

public class tampilanlast extends AppCompatActivity {

    private TextView cardnama, cardumur, cardalamat;
    private ImageButton imageButtonedit, imageButtondelete;
    private String nama, umur, alamat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilanlast);


        Intent terima = getIntent();

        int position = terima.getIntExtra("position", 0);

        nama = MainActivity.dataInput.get(position).getNama();
        umur = MainActivity.dataInput.get(position).getUmur();
        alamat = MainActivity.dataInput.get(position).getAlamat();


//
       initView();
        setListener();
    }
    private void initView() {
        cardnama = findViewById(R.id.cardnama);
        cardumur = findViewById(R.id.cardumur);
        cardalamat = findViewById(R.id.cardalamat);
        imageButtonedit = findViewById(R.id.imageButtonedit);
        imageButtondelete =findViewById(R.id.imageButtondelete);

        cardnama.setText(nama);
        cardumur.setText(umur);
        cardalamat.setText(alamat);
    }
    private void setListener() {
        imageButtondelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.dataInput.remove(getIntent().getIntExtra("position", 0));
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), " profile telah terhapus", Toast.LENGTH_SHORT).show();
            }
        });

        imageButtonedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   Intent intent = new Intent(getApplicationContext(),kelaschange.class);
                   intent.putExtra("position",getIntent().getIntExtra("position",0));
                   startActivity(intent);
            }
        });

    }
    }


 //   }



//