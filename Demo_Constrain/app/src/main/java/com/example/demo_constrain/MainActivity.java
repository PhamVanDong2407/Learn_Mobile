package com.example.demo_constrain;

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

    // Khai báo các biến giao diện tại đây
    EditText edtA, edtB, edtKetQua;
    Button btnTong;

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

        // Ánh xạ id cho các biến giao diện ( kết nối các biến đến các đối tượng giao diện thông qua các id của nó)
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKetQua = findViewById(R.id.edtKetQua);
        btnTong = findViewById(R.id.btnTong);

        // Xử lý tương tác với người dùng
        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(edtA.getText().toString()); // Lấy dữ liệu từ edtA, ép sang kiểu int và gán vào biến a
                int b = Integer.parseInt(edtB.getText().toString());
                int c = a + b;
                edtKetQua.setText(c + ""); // Hiển thị kết quả ( ở đây thêm "" vì setText() trả về kiểu chuỗi nếu k có thêm sẽ sai
            }
        });


    }
}