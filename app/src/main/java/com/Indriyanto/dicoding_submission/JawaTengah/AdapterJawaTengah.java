package com.Indriyanto.dicoding_submission.JawaTengah;

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

public class AdapterJawaTengah extends RecyclerView.Adapter<AdapterJawaTengah.CardViewViewHolder> {
    private ArrayList<JawaTengah> listJateng;

    public AdapterJawaTengah(ArrayList<JawaTengah> list) {
        this.listJateng = list;
    }

    @NonNull
    @Override
    public CardViewViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_wisata, viewGroup, false);
        return new CardViewViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CardViewViewHolder holder, int position) {

        JawaTengah jateng = listJateng.get(position);
        Glide.with(holder.itemView.getContext())
                .load(jateng.getGambar())
                .into(holder.image);
        holder.txtnamawisata.setText(jateng.getNamawisata());
        holder.txtkategori.setText(jateng.getKategori());
        holder.txtlokasi.setText(jateng.getAlamat());

        final String namaWisata = jateng.getNamawisata();
        final String ketgoriWisata = jateng.getKategori();
        final String alamatWisata = jateng.getAlamat();
        final String tiketWisata = jateng.getTiketmasuk();
        final String deskripsiWisata = jateng.getDeskripsi();
        final Integer gambarWisata = jateng.getGambar();


        holder.btnklik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  Toast.makeText(holder.itemView.getContext(), "Anda memilih " +
                ///        listjogja.get(holder.getAdapterPosition()).getNamaWisata(), Toast.LENGTH_SHORT).show();

                Intent pindahdetail =new Intent(v.getContext(), DetailWisata.class);
                pindahdetail.putExtra("namaWisata",namaWisata );
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
        return listJateng.size();
    }

    class CardViewViewHolder extends RecyclerView.ViewHolder {
        CardView btnklik;
        ImageView image;
        TextView txtnamawisata, txtkategori,txtlokasi,txtdetail,txttarifmasuk;
        CardViewViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            txtnamawisata = itemView.findViewById(R.id.txtnamawisata);
            txtkategori = itemView.findViewById(R.id.txtkategori);
            txtlokasi = itemView.findViewById(R.id.txtlokasi);
            ////txtdetail = itemView.findViewById(R.id.txtdetail);
            txttarifmasuk = itemView.findViewById(R.id.txttarifmasuk);
            btnklik = itemView.findViewById(R.id.btnklik);

        }
    }
}
