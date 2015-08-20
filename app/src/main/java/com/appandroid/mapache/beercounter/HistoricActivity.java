package com.appandroid.mapache.beercounter;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class HistoricActivity extends AppCompatActivity {

    List<String> historic_list = new ArrayList<String>();
    Button btn_return;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historic);

        Intent list = getIntent();
        historic_list = list.getStringArrayListExtra("historic_list");
        GlobalVars sharedData = GlobalVars.getInstance();
        historic_list= sharedData.getHistoricList();

        TextView textView = new TextView(this);
        textView = (EditText)findViewById(R.id.editText);
        textView.setTextColor(Color.RED);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setTextSize(15);
        for (int i=0; i< historic_list.size();i++){
            textView.append(historic_list.get(i));
            textView.append("\n");
        }
        //setContentView(textView);
    }


    /** Called when user click on Historic Button */
    public void ReturnMain (View view) {
        // Do something in response to button
        Intent intent = new Intent(this, MainActivity.class);
        // we send our list of historic entries.

        intent.putStringArrayListExtra("historic_list", (ArrayList<String>) historic_list);

        startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
