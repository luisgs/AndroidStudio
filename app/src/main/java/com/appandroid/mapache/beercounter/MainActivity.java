package com.appandroid.mapache.beercounter;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.Activity;
import android.graphics.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class MainActivity extends Activity implements OnClickListener {

    Button btn1;
    Button btn3;
    Button b_historic;
    TextView textTitle;
    EditText scoreText;
    int counter = 0;
    List<String> list = new ArrayList<String>();
    Date dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.addButton);
        btn3 = (Button)findViewById(R.id.resetButton);
        //b_historic = (Button)findViewById(R.id.historicButton);
        scoreText = (EditText)findViewById(R.id.editText);
        textTitle = (TextView)findViewById(R.id.myTextTitle);

        //---set on click listeners on the buttons-----
        btn1.setOnClickListener(this);
        btn3.setOnClickListener(this);
        //b_historic.setOnClickListener(this);

        // change font size of the text
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
    }

    @Override
    public void onClick(View v) {
        if (v == btn1){
            counter++;
            scoreText.setText(Integer.toString(counter));
            scoreText.setBackgroundColor(Color.CYAN);
            list.add(String.valueOf(new Date()));
        }

        if (v == btn3) {
            if (counter != 0) {
                scoreText.setText(list.get(counter-1));
            } else {
                counter = 0;
                scoreText.setText(Integer.toString(counter));
            }
            scoreText.setBackgroundColor(Color.RED);
        }
    }


    /** Called when user click on Historic Button */
    public void ShowHistoric (View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HistoricActivity.class);
        // we send our list of historic entries.

        intent.putStringArrayListExtra("historic_list", (ArrayList<String>) list);

        startActivity(intent);
    }
}