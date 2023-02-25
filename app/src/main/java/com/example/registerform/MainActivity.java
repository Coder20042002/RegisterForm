package com.example.registerform;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtName;
    private EditText edtPhone;
    private EditText edtAge;
    private CheckBox cbxSex;
    private RadioGroup radGr;
    private RadioButton rad_btn;
    private Button btnRgister ;
    String radioValue;
    String checkValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_name);
        edtPhone = findViewById(R.id.edt_phone);
        edtAge = findViewById(R.id.edt_age);
        cbxSex =(CheckBox) findViewById(R.id.cbx_sex);
        radGr = (RadioGroup) findViewById(R.id.rad_gr);
        btnRgister = (Button) findViewById(R.id.btn_register);

        btnRgister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerText();
            }
        });

    }

    private void registerText() {
        String strName = edtName.getText().toString().trim();
        User.name = strName;
        String strPhone = edtPhone.getText().toString().trim();
        User.phone = strPhone;
        String strAge = edtAge.getText().toString().trim();
        User.age = strAge;

        int checkRadioId = radGr.getCheckedRadioButtonId();
        rad_btn = (RadioButton) findViewById(checkRadioId);
        Toast.makeText(getApplicationContext(), rad_btn.getText(), Toast.LENGTH_SHORT).show();
        radioValue = String.valueOf(rad_btn.getText());
        User.level = radioValue;

        if(cbxSex.isChecked() == true) {
            checkValue = "Nam";
            User.sex = checkValue;
        } else {
            checkValue = "Nữ";
            User.sex = checkValue;
        }


        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        edtName.setText(User.name);
//        edtAge.setText((User.age));
//        edtPhone.setText(User.phone);
//
//
//    }
}