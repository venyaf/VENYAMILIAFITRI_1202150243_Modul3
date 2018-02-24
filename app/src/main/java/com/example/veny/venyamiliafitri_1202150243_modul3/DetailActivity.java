package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private Button btnPlus, btnMinus;
    private ImageView capacity;
    private TextView status;
    private int level =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //Inisialisasi Views
        TextView drinksTitle = (TextView)findViewById(R.id.titleDetail);
        ImageView drinksImage = (ImageView)findViewById(R.id.drinksImageDetail);
        TextView drinksDetail = (TextView)findViewById(R.id.subTitleDetail);

        //Get drawable
        Drawable drawable = ContextCompat.getDrawable
                (this,getIntent().getIntExtra(Drink.IMAGE_KEY, 0));

        //Membuat placeholder abu-abu scrim saat gambar dimuat
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(Color.GRAY);

        //Menyamakan ukuran dengan image
        if(drawable!=null) {
            gradientDrawable.setSize(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        }

        //Set text dari Intent extra dan menampilkan toast item yang dipilih
        drinksTitle.setText(getIntent().getStringExtra(Drink.TITLE_KEY));
        Toast.makeText(DetailActivity.this,"Berikut detail dari air mineral merk " + drinksTitle.getText(), Toast.LENGTH_LONG).show();

        //Load image menggunakan glide library dan Intent extra
        Glide.with(this).load(getIntent().getIntExtra(Drink.IMAGE_KEY,0))
                .placeholder(gradientDrawable).into(drinksImage);

        //Set text dari Intent extra
        drinksDetail.setText(getIntent().getStringExtra(Drink.DETAIL_KEY));

        btnPlus = (Button) findViewById(R.id.btnPlus);
        btnMinus = (Button) findViewById(R.id.btnMinus);
        capacity = (ImageView) findViewById(R.id.imgBotol);
        status = (TextView) findViewById(R.id.status);

        //Ketika button plus diklik maka akan menjalankan method addCapacity
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCapacity();
            }
        });

        //Ketika button minus diklik maka akan menjalankan method minusCapacity
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                minusCapacity();
            }
        });

    }

    //Method minusCapacity dan toast apabila mencapai level 0
    private void minusCapacity() {
        status();
        if(level==0){
            Toast.makeText(this,"Air Terisi Sedikit",Toast.LENGTH_SHORT).show();
            return;
        }
        //setImage dari capacity.xml yang berisi vector asset dari botol
        capacity.setImageLevel(--level);
    }

    //Method addCapacity dan toast apabila mencapai level 6
    private void addCapacity() {
        status();
        if(level==6){
            Toast.makeText(this,"Air Terisi Penuh",Toast.LENGTH_SHORT).show();
            return;
        }
        //setImage dari capacity.xml yang berisi vector asset dari botol
        capacity.setImageLevel(++level);
    }

    //Method status untuk mengisi status pada textView status
    private void status() {
        int i = level + 1;
        status.setText(""+ i +"L");
    }


}
