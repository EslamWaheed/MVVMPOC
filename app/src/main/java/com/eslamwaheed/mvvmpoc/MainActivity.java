package com.eslamwaheed.mvvmpoc;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    private TextView tv_count;
    private FloatingActionButton fab_add;

    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_count = findViewById(R.id.tv_count);
        fab_add = findViewById(R.id.fab_add);

        //get view model
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //live date observer
        MutableLiveData<Integer> integerLiveData = mainViewModel.getInitCount();

        integerLiveData.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                tv_count.setText("Count: " + integer);
            }
        });

        fab_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainViewModel.addCount();
            }
        });
    }
}