package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    TextInputEditText name_et, family_et;
    String gender_st;
    MaterialButton btn_save_info;
    RadioGroup gender;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userManager = new UserManager(this);

        name_et = findViewById(R.id.name);
        family_et = findViewById(R.id.family);

        btn_save_info = findViewById(R.id.btn_save);
        gender = findViewById(R.id.gender);
        // get data from shared preferences
        name_et.setText(userManager.getName());
        family_et.setText(userManager.getFamily());
        // check radio group
        gender_st = userManager.getGender();

        if (gender_st.equalsIgnoreCase("male")) {
             gender.check(R.id.man);
        } else if (gender_st.equalsIgnoreCase("female")) {
            gender.check(R.id.woman);
        }
        // set gender
        gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.man) {
                    gender_st = "male";
                } else {
                    gender_st = "female";
                }
            }
        });

        btn_save_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userManager.save_data(name_et.getText().toString(),
                        family_et.getText().toString(),
                        gender_st);

            }
        });

    }
}