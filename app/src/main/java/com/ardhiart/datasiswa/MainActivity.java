package com.ardhiart.datasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ClickNilai = (ImageView) findViewById(R.id.ivNilai);

        ClickNilai.setOnClickListener(new View.OnClickListener() {
            public void onClick(View V) {
                Intent intent = new Intent(V.getContext(), Nilai.class);
                startActivityForResult(intent, 0);
            }
        });
    }
}
