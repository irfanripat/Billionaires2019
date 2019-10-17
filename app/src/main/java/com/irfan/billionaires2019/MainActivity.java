package com.irfan.billionaires2019;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Billionaires> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.rv_category);
        rvCategory.setHasFixedSize(true);

        list.addAll(BillionairesData.getListData());
        showRecyclerList();
    }

    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListBillionairesAdapter listBillionairesAdapter = new ListBillionairesAdapter(this);
        listBillionairesAdapter.setListBillionaires(list);
        rvCategory.setAdapter(listBillionairesAdapter);

        ItemClickSupport.addTo(rvCategory).setOnItemClickListener(new ItemClickSupport.OnItemClickListener() {
            @Override
            public void onItemClicked(RecyclerView recyclerView, int position, View v) {
                showSelectedBillionaires(list.get(position));
            }
        });
    }

    private void showSelectedBillionaires(Billionaires billionaires){
        Intent intentItemBillionaires = new Intent(MainActivity.this, DetailActivity.class);
        intentItemBillionaires.putExtra(DetailActivity.EXTRA_NAMA, billionaires.getNama());
        intentItemBillionaires.putExtra(DetailActivity.EXTRA_RANK, billionaires.getRank());
        intentItemBillionaires.putExtra(DetailActivity.EXTRA_UANG, billionaires.getUang());
        intentItemBillionaires.putExtra(DetailActivity.EXTRA_DESC, billionaires.getDesc());
        intentItemBillionaires.putExtra(DetailActivity.EXTRA_FOTO, billionaires.getFoto());
        startActivity(intentItemBillionaires);

    }
}

