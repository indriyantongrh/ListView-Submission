package com.Indriyanto.dicoding_submission.JawaTimur;

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
import com.Indriyanto.dicoding_submission.JawaBarat.JawaBarat;
import com.Indriyanto.dicoding_submission.Jogjakarta.AdapterYogyakarta;
import com.Indriyanto.dicoding_submission.Jogjakarta.Yokyakarta;
import com.Indriyanto.dicoding_submission.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class AdapterJawaTimur extends RecyclerView.Adapter<AdapterJawaTimur.ListViewHolder> {
    private ArrayList<JawaTimur> listjatim;

    public AdapterJawaTimur(ArrayList<JawaTimur> list) {
        this.listjatim = list;
    }


    @NonNull
    @Override
    public AdapterJawaTimur.ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_wisata, viewGroup, false);
        return new ListViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull final AdapterJawaTimur.ListViewHolder holder, int position) {
        JawaTimur jatim = listjatim.get(position);
        Glide.with(holder.itemView.getContext())
                .load(jatim.getGambar())
                .into(holder.image);
        holder.txtnamawisata.setText(jatim.getNamaWisata());
        holder.txtkategori.setText(jatim.getKategori());
        holder.txtlokasi.setText(jatim.getAlamat());

        final String namaWisata = jatim.getNamaWisata();
        final String ketgoriWisata = jatim.getKategori();
        final String alamatWisata = jatim.getAlamat();
        final String tiketWisata = jatim.getTiketmasuk();
        final String deskripsiWisata = jatim.getDeskripsi();
        final Integer gambarWisata = jatim.getGambar();


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
        return listjatim.size();
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
            ///txtdetail = itemView.findViewById(R.id.txtdetail);
            txttarifmasuk = itemView.findViewById(R.id.txttarifmasuk);
            btnklik = itemView.findViewById(R.id.btnklik);
        }
    }
}
