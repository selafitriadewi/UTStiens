package com.selafitriadewi.utstiens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

public class dashboard extends AppCompatActivity {
    private static final String LOG_TAG =MainActivity.class.getSimpleName() ;
    SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }
    public void tambahClick(View view) {
        Log.d(LOG_TAG, "Add Product");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void List(View view) {
        Log.d(LOG_TAG, "List Product");
        Intent intent = new Intent(this, TiensList.class);
        startActivity(intent);
    }
    public void logout(View view) {
        Log.d(LOG_TAG, "Logout");

        sharedPrefManager = new SharedPrefManager(this);

        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
        startActivity(new Intent(dashboard.this, LoginActivity.class)
                .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
        finish();
    }

}
