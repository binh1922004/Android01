/*
package vn.iotstar.laptrinhmobiest6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {
    private EditText etEmail;
    private Button btnSendOtp;
    private String generatedOtp = "123456";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);
        etEmail = findViewById(R.id.et_email);
        btnSendOtp = findViewById(R.id.btn_send_otp);
        btnSendOtp.setOnClickListener(v -> {
            String email = etEmail.getText().toString();
            if(TextUtils.isEmpty(email)){
                Toast.makeText(this, "Vui lòng nhập lại email!", Toast.LENGTH_SHORT).show();
                return;
            }
            // Gửi OTP qua API (hiện tại giả lập)
            sendOtpToEmail(email);
            // Chuyển sang màn hình nhập OTP
            Intent intent = new Intent(EmailActivity.this, OTPActivity.class);
            intent.putExtra("email", email);
            intent.putExtra("otp", generatedOtp);
            startActivity(intent);
        });
    }
    private void sendOtpToEmail(String email) {
        Toast.makeText(this, "OTP đã gửi tới " + email, Toast.LENGTH_SHORT).show();
    }
}
*/
