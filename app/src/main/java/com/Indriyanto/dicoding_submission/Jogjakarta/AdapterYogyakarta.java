package com.Indriyanto.dicoding_submission.Jogjakarta;

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

public class AdapterYogyakarta extends RecyclerView.Adapter<AdapterYogyakarta.ListViewHolder> {
    private ArrayList<Yokyakarta> listjogja;

    public AdapterYogyakarta(ArrayList<Yokyakarta> list) {
        this.listjogja = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_wisata, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Yokyakarta jogja = listjogja.get(position);
        Glide.with(holder.itemView.getContext())
                .load(jogja.getGambar())
                .into(holder.image);
        holder.txtnamawisata.setText(jogja.getNamaWisata());
        holder.txtkategori.setText(jogja.getKategori());
        holder.txtlokasi.setText(jogja.getAlamat());

        final String namaWisata = jogja.getNamaWisata();
        final String ketgoriWisata = jogja.getKategori();
        final String alamatWisata = jogja.getAlamat();
        final String tiketWisata = jogja.getTiketmasuk();
        final String deskripsiWisata = jogja.getDeskripsi();
        final Integer gambarWisata = jogja.getGambar();


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
        return listjogja.size();
    }

    class ListViewHolder extends RecyclerView.ViewHolder {
        CardView btnklik;
        ImageView image;
        TextView txtnamawisata, txtkategori,txtlokasi,txttarifmasuk,txtdetail;

        ListViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            txtnamawisata = itemView.findViewById(R.id.txtnamawisata);
            txtkategori = itemView.findViewById(R.id.txtkategori);
            txtlokasi = itemView.findViewById(R.id.txtlokasi);
            txttarifmasuk = itemView.findViewById(R.id.txttarifmasuk);
            btnklik = itemView.findViewById(R.id.btnklik);
        }
    }

}
