package com.example.viewmodelapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.example.viewmodelapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    MyViewModel viewModel;
    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //Helps access the viewModel class whenever needed in the activity or fragment in different events of
        // the activity/fragment lifecycle.
        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        mainBinding.btnCounter.setOnClickListener(v ->{
            viewModel.incrementCounter();
            mainBinding.textView2.setText(String.valueOf(viewModel.getCounter()));
        });
        mainBinding.textView2.setText(String.valueOf(viewModel.getCounter()));

    }


    /*
        View model  - a class that is responsible for preparing and managing the data for n Activity or fragment.
        It also handles the communication of the Activity/Fragment with the rest of the application.

        A view model is always created in association with a scope (a fragment or an activity)
        and will be retained as long as the scope is alive.
        ex. if its an activity, until it is finished

        In other words, this means that a ViewModel will not be destroyed if its owner is
        destroyed for configuration change. eg. rotation

        MODEL (get data) - > VIEW MODEL (process data) -> VIEW (display data)

        This will be helpful to save the state of the views whenever the configuration changes.
        such as screen rotation.

     */
}