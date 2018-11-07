package com.example.juny.devofexploration.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.juny.devofexploration.R;

import butterknife.ButterKnife;

/**
 * @author ChenRunFang
 */
public class ConstraintActivity extends BaseActivity {


    public static void intentToConstraintActivity(Context context) {
        Intent intent = new Intent(context, ConstraintActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint);
        ButterKnife.bind(this);
    }
}
