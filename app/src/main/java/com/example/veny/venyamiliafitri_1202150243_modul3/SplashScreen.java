package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {
    // Splash screen timer
    private static int splashInterval = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //menghilangkan ActionBar
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Method ini akan dijalankan ketika timer dari splash screen habis
                //Memulai main activity
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                //Toast ketika splashscreen muncul
                Toast.makeText(SplashScreen.this,"VENYAMILIAFITRI_1202150243", Toast.LENGTH_LONG).show();
                this.finish();
            }
            //Aktivity selesai
            private void finish(){

            }
            //timer saat splashscreen selesai
        }, splashInterval);
    }
}
