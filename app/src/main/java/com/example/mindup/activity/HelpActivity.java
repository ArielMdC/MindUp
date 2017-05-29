package com.example.mindup.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.mindup.R;

public class HelpActivity extends Activity implements View.OnClickListener {

    Button buttonComecar;
    RadioButton radioButtonHelpIn, radioButtonHelpOut;
    RadioGroup radioGroupHelp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        buttonComecar = (Button) findViewById(R.id.buttonComecar);

        radioButtonHelpIn = (RadioButton) findViewById(R.id.radioButtonHelpIn);
        radioButtonHelpOut = (RadioButton) findViewById(R.id.radioButtonHelpOut);

        radioGroupHelp = (RadioGroup) findViewById(R.id.radioGroupHelp);
        radioGroupHelp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
                String text = checkedRadioButton.getText().toString();
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        });

        buttonComecar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        if (buttonComecar.getId() == view.getId()) {
            startActivity(new Intent(this, MainActivity.class));
        }

    }
}
