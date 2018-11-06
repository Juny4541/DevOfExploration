package com.example.juny.devofexploration.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.juny.devofexploration.R;

/**
 * @author ChenRunFang
 */
public class MainActivity extends BaseActivity {
    private Button mBindBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBindBtn = findViewById(R.id.btn_bind);
        mBindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AIDLActivity.intentToAIDLActivity(MainActivity.this);
            }
        });
    }
}
