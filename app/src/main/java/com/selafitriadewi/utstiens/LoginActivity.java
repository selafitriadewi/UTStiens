package com.selafitriadewi.utstiens;

import android.arch.persistence.room.Database;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    SharedPrefManager sharedPrefManager;
    public List<User> admin;
    public EditText tfNama,tfPassword;
    public Button btnMasuk;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPrefManager = new SharedPrefManager(this);

        if (sharedPrefManager.getSPSudahLogin()){
            startActivity(new Intent(LoginActivity.this, dashboard.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
            finish();
        }

        admin = new ArrayList<>();
        admin.add(new User("sela", "sela"));

        tfNama = (EditText) findViewById(R.id.edittext_username);
        tfPassword = (EditText) findViewById(R.id.edittext_password);
        btnMasuk = (Button) findViewById(R.id.button_login);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User tmpAdmin = null;
                   for(User u:admin   ){
                    if(u.getName().equals(tfNama.getText().toString()) && u.getPassword().equals(tfPassword.getText().toString())){
                        tmpAdmin = u;
                    }
                }

                if(tmpAdmin != null){
                    SharedPreferences spPengguna = LoginActivity.this.getSharedPreferences("Userlogin", Context.MODE_PRIVATE);
                    SharedPreferences.Editor edit = spPengguna.edit();
                    edit.putString("sedangLogin",tmpAdmin.getName());
                    edit.apply();
                    sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);
                    Intent intent = new Intent(LoginActivity.this, dashboard.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this, "Username atau Password Salah", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

}