package vn.iotstar.laptrinhmobiest6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class OTPActivity extends AppCompatActivity {
    private EditText etOtp;
    private Button btnVerifyOtp;
    private String receivedOtp, email;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        etOtp = findViewById(R.id.et_otp);
        btnVerifyOtp = findViewById(R.id.btn_verify_otp);

        email = getIntent().getStringExtra("email");
        receivedOtp = getIntent().getStringExtra("otp");
        btnVerifyOtp.setOnClickListener(v -> {
            String otpInput = etOtp.getText().toString();
            if (TextUtils.isEmpty(otpInput)) {
                Toast.makeText(this, "Vui lòng nhập OTP!", Toast.LENGTH_SHORT).show();
                return;
            }
            if (otpInput.equals(receivedOtp)) {
                Toast.makeText(this, "Xác minh thành công!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OTPActivity.this, CreatePasswordActivity.class);
                intent.putExtra("email", email);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Mã OTP không đúng!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
