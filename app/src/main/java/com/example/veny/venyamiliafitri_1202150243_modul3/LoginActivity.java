package com.example.veny.venyamiliafitri_1202150243_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText username, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Inisialisasi views
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);

    }

    public void login(View view) {
        //get text dari username dan password
        final String user = username.getText().toString();
        String pass = password.getText().toString();

        //pengkondisian untuk login
        if(user.equals("EAD") && pass.equals("MOBILE")){
            //Toast apabila berhasil login
            Toast.makeText(this,"Anda berhasil login", Toast.LENGTH_LONG).show();
            //Melakukan intent ke aktivitas Main
            Intent login = new Intent(LoginActivity.this,MainActivity.class);
            //Memulai / menjalankan intent satu aktivitas
            startActivity(login);
        }else if(user.isEmpty() || pass.isEmpty()){
            //kondisi apabila text username atau password kosong
            Toast.makeText(this,"Silahkan isi terlebih dahulu", Toast.LENGTH_LONG).show();
        }else{
            //kondisi apabila username atau password yang dimasukkan salah
            Toast.makeText(this,"Login gagal",Toast.LENGTH_LONG).show();
        }
    }
}
