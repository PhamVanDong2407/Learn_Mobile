package com.example.intent3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtNhapData, edtKq;
    Button btnkq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtNhapData = findViewById(R.id.edtNhapData);
        edtKq = findViewById(R.id.edtKq);
        btnkq = findViewById(R.id.btnkq);

        btnkq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai báo intent
                Intent myintent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(edtNhapData.getText().toString());
                // đưa dữ liệu vào intent
                myintent.putExtra("soa", a);
                // khởi động intent và đợi kết quả trả về
                startActivityForResult(myintent, 99);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == 33) {
            int kq = data.getIntExtra("kq", 0);
            edtKq.setText("Giá trị gốc là: " + kq);
        }
        if (requestCode == 99 && resultCode == 34) {
            int kq = data.getIntExtra("kq", 0);
            edtKq.setText("Giá trị bình phương là: " + kq);
        }
    }
}