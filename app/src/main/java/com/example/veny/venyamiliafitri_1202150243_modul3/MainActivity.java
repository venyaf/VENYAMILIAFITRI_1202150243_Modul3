package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    //Member variables
    private RecyclerView mRecyclerView;
    private ArrayList<Drink> mDrinksData;
    private DrinksAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi RecyclerView
        mRecyclerView = (RecyclerView)findViewById(R.id.recyclerView);

        //Get jumlah kolom yang sesuai
        int gridColumnCount = getResources().getInteger(R.integer.grid_column_count);

        //Set Layout Manager
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumnCount));

        //Inisalisasi ArrayList yang berisi data
        mDrinksData = new ArrayList<>();

        //Inisialisasi adapter and set ke dalam RecyclerView
        mAdapter = new DrinksAdapter(this, mDrinksData);
        mRecyclerView.setAdapter(mAdapter);

        //Get data
        initializeData();
    }

    private void initializeData() {
        //Get resources dari file XML
        String[] drinksList = getResources().getStringArray(R.array.drinks_titles);
        String[] drinksInfo = getResources().getStringArray(R.array.drinks_info);
        TypedArray drinksImageResources = getResources().obtainTypedArray(R.array.drinks_images);
        String[] drinksDetail = getResources().getStringArray(R.array.drinks_detail);
        //Menghapus data(untuk menghindari duplikasi)
        mDrinksData.clear();


        //Membuat ArrayList dari objek Drinks yang berisi titles, gambar dan penjelasan tiap drink
        for(int i = 0; i<drinksList.length; i++){
            mDrinksData.add(new Drink(drinksList[i], drinksInfo[i],
                    drinksImageResources.getResourceId(i,0), drinksDetail[i]));
        }

        //Recycle array yang diketikkan
        drinksImageResources.recycle();

        //Notifikasi perubahan adapter
        mAdapter.notifyDataSetChanged();
    }
}
