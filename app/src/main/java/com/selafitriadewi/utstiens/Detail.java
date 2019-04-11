package com.selafitriadewi.utstiens;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Detail extends AppCompatActivity {
    private TextView txtNama, txtharga;
    String nama,harga ;
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtNama = findViewById(R.id.textNama);
        txtharga = findViewById(R.id.textHarga);
        image=findViewById(R.id.img);

        Intent intent = getIntent();
        nama = intent.getStringExtra("nama");
        harga = intent.getStringExtra("harga");

        txtNama.setText(String.format(""+nama));
        txtharga.setText(String.format(""+harga));


        Bundle extras = getIntent().getExtras(); //mengirim data
        byte[] b = extras.getByteArray("picture");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);
        image.setImageBitmap(bmp);
    }
}
