package com.example.colorpicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import yuku.ambilwarna.AmbilWarnaDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


//                 ***************Important**************

//  ****************Sync Now*****************************
//  *implementation 'com.github.yukuku:ambilwarna:2.0.1'*
//  *****************************************************
//
//
//

public class MainActivity extends AppCompatActivity {

    LinearLayout linearLayout;
    int tColor, n=0;
    Button button;
    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = (LinearLayout)findViewById(R.id.layout);
        tColor = ContextCompat.getColor(MainActivity.this, R.color.colorAccent);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=1;
                openColorPicker();
            }
        });
        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                n=2;
                openColorPicker();
            }
        });

    }

    public void openColorPicker() {
        AmbilWarnaDialog colorPicker = new AmbilWarnaDialog(this, tColor, new AmbilWarnaDialog.OnAmbilWarnaListener() {
            @Override
            public void onCancel(AmbilWarnaDialog dialog) {

            }

            @Override
            public void onOk(AmbilWarnaDialog dialog, int color) {
                tColor = color;
                if( n == 1) {
                    button.setBackgroundColor(tColor);
                    button2.setBackgroundColor(tColor);
                }
                else if(n == 2) {
                    linearLayout.setBackgroundColor(tColor);
                }
            }
        });
        colorPicker.show();
    }


}
