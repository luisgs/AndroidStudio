package com.appandroid.mapache.beercounter;

import android.app.Application;
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

    TextView textTitle;
    EditText scoreText;
    // Calling for the global variables!
    GlobalVars sharedData = GlobalVars.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.addButton);
        btn3 = (Button)findViewById(R.id.resetButton);


        scoreText = (EditText)findViewById(R.id.editText);

        scoreText.setTextSize(60);

        // print the current counter value from globalvars
        scoreText.setText(Integer.toString(sharedData.getCounter()));
        // coloured its field
        textField();

        textTitle = (TextView)findViewById(R.id.myTextTitle);

        //---set on click listeners on the buttons-----
        btn1.setOnClickListener(this);
        btn3.setOnClickListener(this);
        //b_historic.setOnClickListener(this);

        // change font size of the text
        textTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 35);
    }

    // Print score field depending my standards :)
    public void textField () {
        if (sharedData.getCounter() > 7)
            scoreText.setBackgroundColor(Color.RED);
        else if (sharedData.getCounter() > 4)
            scoreText.setBackgroundColor(Color.YELLOW);
        else if (sharedData.getCounter() == 0)
            scoreText.setBackgroundColor(Color.GREEN);
        else
            scoreText.setBackgroundColor(Color.CYAN);
    }

    @Override
    public void onClick(View v) {

        if (v == btn1){
            sharedData.add_1();
            textField();
            //scoreText.setText(Integer.toString(counter));
            scoreText.setText(Integer.toString(sharedData.getCounter()));
           // list.add(String.valueOf(new Date()));
            sharedData.setHistoricList();
        }

        if (v == btn3) {
            sharedData.resetCounter();
            scoreText.setText(Integer.toString(sharedData.getCounter()));
            //list.clear();
            sharedData.resetHistoricList();
            textField();
        }
    }


    /** Called when user click on Historic Button */
    public void ShowHistoric (View view) {
        // Do something in response to button
        Intent intent = new Intent(this, HistoricActivity.class);
        // we send our list of historic entries.

        intent.putStringArrayListExtra("historic_list", (ArrayList<String>) sharedData.getHistoricList());

        startActivity(intent);
    }
}