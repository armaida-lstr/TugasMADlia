package com.example.tugasatu;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import model.datasimpan;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview_ry;
    public static ArrayList<datasimpan>
    dataInput=new ArrayList<datasimpan>();
    private adapterinpt adapterr;
    private FloatingActionButton floatingActionButton_tambah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setupRecyclerView();
        setListener();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == 200) {
                datasimpan inputdata= data.getParcelableExtra("inputdata");
                dataInput.add(inputdata);
                adapterr.notifyDataSetChanged();
            }
        }

    }

    private void initView() {
        recyclerview_ry=findViewById(R.id.recyclerview_ry);
        adapterr= new adapterinpt(dataInput,getApplicationContext());
        floatingActionButton_tambah=findViewById(R.id.floatingActionButton_tambah);
    }

    private void setListener(){
        floatingActionButton_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), inputdata.class);
                startActivityForResult(intent,1);
            }
        });

    }
    private void setupRecyclerView() {
        RecyclerView.LayoutManager manager=new LinearLayoutManager(getBaseContext());
        recyclerview_ry.setLayoutManager(manager);
        recyclerview_ry.setAdapter(adapterr);
    }
}