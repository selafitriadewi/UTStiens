package com.selafitriadewi.utstiens;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class welcome1 extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

    }
    public void button(View view) {
        Intent login = new Intent(welcome1.this, LoginActivity.class);
        startActivity(login);
    }
}
