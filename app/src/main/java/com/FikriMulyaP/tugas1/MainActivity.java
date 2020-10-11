package com.FikriMulyaP.tugas1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edWidth, edHeight, edLength;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edWidth = (EditText)findViewById(R.id.edt_width);
        edHeight = (EditText)findViewById(R.id.edt_height);
        edLength = (EditText)findViewById(R.id.edt_length);
        btnCalculate = (Button)findViewById(R.id.btn_calculate);
        tvResult = (TextView)findViewById(R.id.tv_result);
        btnCalculate.setOnClickListener(this);
        if (savedInstanceState != null) {
            String hasil = savedInstanceState.getString(STATE_HASIL);
            tvResult.setText(hasil);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_calculate) {
            String length = edLength.getText().toString().trim();
            String width = edWidth.getText().toString().trim();
            String height = edHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            if (TextUtils.isEmpty(length)) {
                isEmptyFields = true;
                edLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(width)) {
                isEmptyFields = true;
                edWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(height)) {
                isEmptyFields = true;
                edHeight.setError("Field ini tidak boleh kosong");
            }
            if (!isEmptyFields) {
                double l = Double.parseDouble(length);
                double w = Double.parseDouble(width);
                double h = Double.parseDouble(height);
                double volume = l * w * h;
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    private static final String STATE_HASIL = "state_hasil";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString(STATE_HASIL, tvResult.getText().toString());
        super.onSaveInstanceState((outState));
    }
}
