package com.appandroid.mapache.beercounter;

import android.app.Application;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlobalVars extends Application {
    int counter = 0;
    List<String> list = new ArrayList<String>();

    private static GlobalVars instance = new GlobalVars();

    // Getter-Setters
    public static GlobalVars getInstance() {
        return instance;
    }

    public void add_1 () {
        counter++;
    }

    public int getCounter () {
        return counter;
    }

    public void resetCounter () {
        counter = 0;
    }

    public List<String> getHistoricList() {
        return this.list;
    }

    public void resetHistoricList() {
        this.list.clear();
    }

    public void setHistoricList () {
        list.add(String.valueOf(new Date()));
    }
}
