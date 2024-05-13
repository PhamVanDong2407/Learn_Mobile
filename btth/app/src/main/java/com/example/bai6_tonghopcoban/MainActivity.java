package com.example.bai6_tonghopcoban;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // khai báo các tên biến
    EditText edtHoTen, edtCCCD, edtTTBS;
    RadioGroup ridGroup;
    RadioButton rbtnTrungCap, rbtnCaoDang, rbtnDaiHoc;
    CheckBox cbxDocSach, cbxDocBao, cbxCoding;
    Button btnSave;

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

        // ánh xạ id
        edtHoTen = findViewById(R.id.edtHoTen);
        edtCCCD = findViewById(R.id.edtCCCD);
        edtTTBS = findViewById(R.id.edtTTBS);
        ridGroup = findViewById(R.id.ridGroup);
        rbtnTrungCap = findViewById(R.id.rbtnTrungCap);
        rbtnCaoDang = findViewById(R.id.rbtnCaoDang);
        rbtnDaiHoc = findViewById(R.id.rbtnDaiHoc);
        cbxDocSach = findViewById(R.id.cbxDocSach);
        cbxDocBao = findViewById(R.id.cbxDocBao);
        cbxCoding = findViewById(R.id.cbxCoding);
        btnSave = findViewById(R.id.btnSave);

        // xử lý tương tác với người dùng
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lấy thông tin họ tên
                String hoTen = edtHoTen.getText().toString();
                if (hoTen.length() < 3) {
                    // ở đây nếu tên < 3 kí tự sẽ hiển thị ra ô thông báo
                    Toast.makeText(MainActivity.this, "Họ tên phải có độ dài 3 kí tự trở lên !", Toast.LENGTH_LONG).show();
                    edtHoTen.requestFocus(); // đưa con trở focus về lại ô nhập họ tên
                    edtHoTen.selectAll(); // bôi đen đoạn tên đã nhập
                    return; // quay trở lại cho người dùng nhập tiếp
                }
                // lấy thông tin CCCD
                String CCCD = edtCCCD.getText().toString();
                if (CCCD.length() < 9) {
                    Toast.makeText(MainActivity.this, "Căn cước công dân phải đủ 9 số !", Toast.LENGTH_LONG).show();
                    edtCCCD.requestFocus();
                    edtCCCD.selectAll();
                    return;
                }
                // lấy thông tin bằng cấp
                int idSelect = ridGroup.getCheckedRadioButtonId(); // trả về các button được chọn trong cái group này
                RadioButton radSelect = findViewById(idSelect);
                String bangCap = radSelect.getText().toString();
                // lấy thông tin sở thích
                String favourite = "";
                if (cbxDocSach.isChecked()) {
                    favourite += cbxDocSach.getText().toString() + "-";
                }
                if (cbxDocBao.isChecked()) {
                    favourite += cbxDocBao.getText().toString() + "-";
                }
                if (cbxCoding.isChecked()) {
                    favourite += cbxCoding.getText().toString() + "-";
                }
                // lấy thông tin bổ sung
                String boSung = edtTTBS.getText().toString();
                String tongHop = hoTen + "\n" + CCCD + "\n" + bangCap + "\n" + favourite + "\n";
                tongHop += "----------THÔNG TIN BỔ SUNG----------\n";
                tongHop += boSung + "\n";
                tongHop += "--------------------------------------------------------";
                // tạo Dialog và hiển thị tổng hợp lên
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                myDialog.setMessage(tongHop);
                myDialog.setPositiveButton("ĐÓNG", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                myDialog.create().show();
            }

//            @Override
            public void onBackPressed() {
                AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                b.setTitle("Question");
                b.setMessage("Are you sure you want to exit?");
                b.setPositiveButton("Yes", new DialogInterface.
                        OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                b.setNegativeButton("No", new
                        DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                b.create().show();
            }

        });
    }
}