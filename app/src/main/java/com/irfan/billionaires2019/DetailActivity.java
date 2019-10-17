package com.irfan.billionaires2019;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class DetailActivity extends AppCompatActivity {


    public static final String EXTRA_NAMA = "extra_nama";
    public static final String EXTRA_UANG = "extra_uang";
    public static final String EXTRA_RANK = "extra_rank";
    public static final String EXTRA_FOTO = "extra_foto";
    public static final String EXTRA_DESC = "extra_desc";

    TextView tvItemNama, tvItemUang, tvItemDesc;
    ImageView imgFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        tvItemNama = findViewById(R.id.tv_item_nama);
        tvItemUang = findViewById(R.id.tv_item_uang);
        tvItemDesc = findViewById(R.id.tv_item_desc);
        imgFoto = findViewById(R.id.tv_item_foto);

        String nama  = getIntent().getStringExtra(EXTRA_NAMA);
        String uang  = getIntent().getStringExtra(EXTRA_UANG);
        String rank  = getIntent().getStringExtra(EXTRA_RANK);
        String desc  = getIntent().getStringExtra(EXTRA_DESC);
        String foto  = getIntent().getStringExtra(EXTRA_FOTO);

        tvItemNama.setText(nama);
        tvItemUang.setText(uang);
        tvItemDesc.setText(desc);
        Glide.with(this)
                .load(foto)
                .into(imgFoto);


    }
}
