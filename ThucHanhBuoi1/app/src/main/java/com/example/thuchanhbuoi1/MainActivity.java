package com.example.thuchanhbuoi1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Khai báo các biến giao diện
    EditText edtUsername;
    EditText edtPass;
    Button btnLogin;

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

        // Ánh xạ ID cho các biến giao diện
        edtUsername = findViewById(R.id.edtUsername);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        // Xử lý tương tác với người dùng
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lấy giá trị từ EditText của tên đăng nhập và mật khẩu
                String username = edtUsername.getText().toString();
                String password = edtPass.getText().toString();

                // Kiểm tra xem tên đăng nhập và mật khẩu có đúng không
                if (username.equals("Đông") && password.equals("Đông123")) {
                    // Nếu đúng, hiển thị thông báo đăng nhập thành công
                    // (ở đây bạn có thể thực hiện hành động chuyển sang màn hình mới hoặc làm bất kỳ điều gì khác)
                    showToast("Đăng nhập thành công");
                } else {
                    // Nếu không, hiển thị thông báo lỗi
                    showToast("Tên đăng nhập hoặc mật khẩu không chính xác");
                }
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}