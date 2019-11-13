package com.Indriyanto.dicoding_submission.JawaBarat;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.Indriyanto.dicoding_submission.DetailWisata;
import com.Indriyanto.dicoding_submission.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterJawaBarat extends RecyclerView.Adapter<AdapterJawaBarat.CardViewViewHolder> {
    private ArrayList<JawaBarat> listJabar;

    public AdapterJawaBarat(ArrayList<JawaBarat> list) {
        this.listJabar = list;
    }

    @NonNull
    @Override
    public AdapterJawaBarat.CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_wisata, viewGroup, false);
        return new CardViewViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final AdapterJawaBarat.CardViewViewHolder holder, int position) {

        JawaBarat jabar = listJabar.get(position);
        Glide.with(holder.itemView.getContext())
                .load(jabar.getGambar())
                .into(holder.image);
        holder.txtnamawisata.setText(jabar.getNamawisata());
        holder.txtkategori.setText(jabar.getKategori());
        holder.txtlokasi.setText(jabar.getAlamat());

        final String namaWisata = jabar.getNamawisata();
        final String ketgoriWisata = jabar.getKategori();
        final String alamatWisata = jabar.getAlamat();
        final String tiketWisata = jabar.getTiketmasuk();
        final String deskripsiWisata = jabar.getDeskripsi();
        final Integer gambarWisata = jabar.getGambar();


        holder.btnklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(holder.itemView.getContext(), "Anda memilih " +
                ///        listjogja.get(holder.getAdapterPosition()).getNamaWisata(), Toast.LENGTH_SHORT).show();

                Intent pindahdetail = new Intent(v.getContext(), DetailWisata.class);
                pindahdetail.putExtra("namaWisata", namaWisata);
                pindahdetail.putExtra("tiketmasuk", tiketWisata);
                pindahdetail.putExtra("gambar", gambarWisata);
                pindahdetail.putExtra("kategori", ketgoriWisata);
                pindahdetail.putExtra("alamat", alamatWisata);
                pindahdetail.putExtra("deskripsi", deskripsiWisata);
                v.getContext().startActivity(pindahdetail);

            }
        });

    }

    @Override
    public int getItemCount() {
        return listJabar.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        CardView btnklik;
        ImageView image;
        TextView txtnamawisata, txtkategori, txtlokasi, txtdetail, txttarifmasuk;

        CardViewViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            txtnamawisata = itemView.findViewById(R.id.txtnamawisata);
            txtkategori = itemView.findViewById(R.id.txtkategori);
            txtlokasi = itemView.findViewById(R.id.txtlokasi);
          ////  txtdetail = itemView.findViewById(R.id.txtdetail);
            txttarifmasuk = itemView.findViewById(R.id.txttarifmasuk);
            btnklik = itemView.findViewById(R.id.btnklik);

        }
    }

}