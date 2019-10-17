package com.irfan.billionaires2019;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListBillionairesAdapter extends RecyclerView.Adapter<ListBillionairesAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Billionaires> listBillionaires;

    public ListBillionairesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<Billionaires> getListBillionaires() {
        return listBillionaires;
    }

    public void setListBillionaires(ArrayList<Billionaires> listBillionaires) {
        this.listBillionaires = listBillionaires;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_billionaires, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.tvNama.setText(getListBillionaires().get(position).getNama());
        categoryViewHolder.tvUang.setText(getListBillionaires().get(position).getUang());
        categoryViewHolder.tvRank.setText(getListBillionaires().get(position).getRank());
        Glide.with(context)
                .load(getListBillionaires().get(position).getFoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgFoto);
    }

    @Override
    public int getItemCount() {
        return getListBillionaires().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvUang, tvRank;
        ImageView imgFoto;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tv_item_nama);
            tvUang = itemView.findViewById(R.id.tv_item_uang);
            tvRank = itemView.findViewById(R.id.tv_item_rank);
            imgFoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
