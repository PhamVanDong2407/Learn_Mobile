package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    EditText edtDuLieuNhan;
    Button btnGuiGoc, btnGuiBP;
    Intent myintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtDuLieuNhan = findViewById(R.id.edtDuLieuNhan);
        btnGuiGoc = findViewById(R.id.btnGuiGoc);
        btnGuiBP = findViewById(R.id.btnGuiBP);

        // nhận intent
        myintent = getIntent();
        // lấy dữ liệu ra khỏi intent
        int a = myintent.getIntExtra("soa", 0);
        edtDuLieuNhan.setText(a + "");

        btnGuiGoc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a);
                setResult(33,myintent);
                finish();
            }
        });

        btnGuiBP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myintent.putExtra("kq", a*a);
                setResult(34, myintent);
                finish();
            }
        });
    }
}