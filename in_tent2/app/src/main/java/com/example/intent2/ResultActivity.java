package com.example.intent2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nghiem;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnBack), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt_nghiem = findViewById(R.id.txt_nghiem);
        btnBack = findViewById(R.id.btnBack);

        // nhận intent
        Intent myIntent = getIntent();
        // lấy Bundle ra khỏi intent
        Bundle myBundle = myIntent.getBundleExtra("myPackage");
        // lấy dữ liệu khỏi Bundle
        int A = myBundle.getInt("soa");
        int B = myBundle.getInt("sob");
        // tiến hành giải PT bậc nhất
        String nghiem = "";
        if (A == 0 && B == 0) {
            nghiem = "PT Vô Số Nghiệm";
        } else if (A == 0 && B != 0) {
            nghiem = "PT Vô Nghiệm";
        } else {
            nghiem = "Nghiệm PT = " + (-1.0) * B / A;
        }
        txt_nghiem.setText(nghiem);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}