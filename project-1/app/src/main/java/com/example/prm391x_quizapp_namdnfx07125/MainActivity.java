package com.example.prm391x_quizapp_namdnfx07125;

//import all needed libraries
import android.os.Bundle;
import android.app.Activity;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
//  create instances
    CheckBox q1_checkBox1,q1_checkBox2;
    RadioGroup q2_radioBooleanGroup;
    RadioButton q2_correctRadioButton;
    EditText q3_editText;

    Button btnSubmit,btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//assign values to previously created instances
        q1_checkBox1=(CheckBox)findViewById(R.id.checkBox1);
        q1_checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        q2_radioBooleanGroup=(RadioGroup)findViewById(R.id.radioGroup);
        q2_correctRadioButton = (RadioButton) findViewById(R.id.radioButton2);
        q3_editText = (EditText) findViewById(R.id.edittext);
        btnSubmit=(Button)findViewById(R.id.button);
        btnCancel=(Button)findViewById(R.id.button2);

        //checking and setting action when bttn2 is clicked
        btnCancel.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //checking and setting action when bttn1 is clicked
        btnSubmit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if((q1_checkBox1.isChecked()||q1_checkBox2.isChecked()) && (q2_radioBooleanGroup.getCheckedRadioButtonId()!=-1) && (!q3_editText.getText().toString().equals(""))) {
                    int score = 0;
                    String result;

                    if (!q1_checkBox1.isChecked() && q1_checkBox2.isChecked()) {
                        score++;
                    }
                    if (q2_correctRadioButton.isChecked()) {
                        score++;
                    }
                    if (q3_editText.getText().toString().toLowerCase().equals("anatidae")) {
                        score++;
                    }
                    if (score == 3) {
                        result = "Excellent! All answers are correct!";
                    } else {
                        result = score + " out of 3. Try again!";
                    }
                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, "Please answer all questions", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}