package com.example.viewmodelapp;

import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {
    int counter = 0;
    public void incrementCounter() {
        counter++;
    }
    public int getCounter() {
        return counter;
    }


}
