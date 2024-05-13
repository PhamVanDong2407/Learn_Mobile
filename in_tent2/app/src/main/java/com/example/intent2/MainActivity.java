package com.example.intent2;

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

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB;
    Button btnKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnBack), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        btnKq = findViewById(R.id.btnKq);

        // xử lý tương tác
        btnKq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo intent
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                // lấy dữ liệu
                int A = Integer.parseInt(edtA.getText().toString());
                int B = Integer.parseInt(edtB.getText().toString());
                // đóng gói dữ liệu vào Bundle
                Bundle myBundle = new Bundle();
                // đưa dữ liệu vào Bundle
                myBundle.putInt("soa", A);
                myBundle.putInt("sob", B);
                // đưa Bundle vào intent
                myIntent.putExtra("myPackage", myBundle);
                // khởi động intent
                startActivity(myIntent);
            }
        });
    }
}