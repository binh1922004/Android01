package vn.iotstar.laptrinhmobiest6;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OTPActivity extends AppCompatActivity {

    private EditText etOtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        // Ánh xạ EditText với ID etOtp
        etOtp = findViewById(R.id.etOtp);

        // Sự kiện khi nhấn "Xác nhận OTP"
        findViewById(R.id.btnVerifyOTP).setOnClickListener(v -> verifyOTP());
    }

    private void verifyOTP() {
        String otp = etOtp.getText().toString().trim();

        if (TextUtils.isEmpty(otp)) {
            Toast.makeText(this, "Vui lòng nhập OTP!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Giả sử OTP luôn đúng
        Toast.makeText(this, "OTP xác nhận thành công!", Toast.LENGTH_SHORT).show();

        // Trả kết quả về RegisterActivity
        setResult(RESULT_OK);
        finish();
    }
}
