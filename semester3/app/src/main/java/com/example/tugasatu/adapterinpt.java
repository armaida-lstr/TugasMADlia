package com.example.tugasatu;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import model.datasimpan;

public class adapterinpt extends RecyclerView.Adapter<adapterinpt.datasimpanViewHolder> {

    private Context context;

    private ArrayList<datasimpan> Listinpt;

    public adapterinpt(ArrayList<datasimpan> Listinpt, Context context) {

        this.Listinpt = Listinpt;
        this.context = context;
    }

    @NonNull
    @Override
    public datasimpanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater LayoutInflater = android.view.LayoutInflater.from((parent.getContext()));
        View view = LayoutInflater.inflate(R.layout.tampilansatu, parent, false);
        return new datasimpanViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull datasimpanViewHolder holder, int position) {
        holder.tampilnama.setText(String.valueOf(Listinpt.get(position).getNama()));
        holder.tampilumur.setText(String.valueOf(Listinpt.get(position).getUmur()));
        holder.tampilalamat.setText(String.valueOf(Listinpt.get(position).getAlamat()));
       //  holder.imageView.setImageTintList(Listinpt.get(position).getGambar()));



    }

    @Override
    public int getItemCount(
    ) {
        return Listinpt.size();
    }

    public class datasimpanViewHolder extends RecyclerView.ViewHolder {
        private TextView tampilnama, tampilumur,tampilalamat;
     //   private TextView cardnama, cardumur, cardalamat;
        private ImageButton  tombolfull;
        private ImageView imageView;


        public datasimpanViewHolder(@NonNull View itemView) {
            super(itemView);
            tampilnama = itemView.findViewById(R.id.tampilnama);
            tampilumur = itemView.findViewById(R.id.tampilumur);
            tampilalamat = itemView.findViewById(R.id.tampilalamat);
            imageView = itemView.findViewById(R.id.imageView);
//            imageButtonedit = itemView.findViewById(R.id.imageButtonedit);
//            imageButtondelete = itemView.findViewById(R.id.imageButtondelete);
            tombolfull=itemView.findViewById(R.id. tombolfull);


        tombolfull.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String nama = tampilnama.getText().toString().trim();
            String umur = tampilumur.getText().toString().trim();
            String alamat = tampilalamat.getText().toString().trim();

            int position = getAdapterPosition();

            Intent intt = new Intent(context, tampilanlast.class);
            intt.putExtra("nama", nama);
            intt.putExtra("umur", umur);
            intt.putExtra("alamat", alamat);
            intt.putExtra("position", position);
            intt.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intt);
        }
});



        }

    }
}
