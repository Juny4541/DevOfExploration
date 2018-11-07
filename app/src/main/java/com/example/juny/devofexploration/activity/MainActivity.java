package com.example.juny.devofexploration.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.juny.devofexploration.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author ChenRunFang
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.btn_bind)
    Button mBtnBind;
    @BindView(R.id.btn_constraint)
    Button mBtnConstraint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_bind, R.id.btn_constraint})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_bind:
                AIDLActivity.intentToAIDLActivity(MainActivity.this);
                break;
            case R.id.btn_constraint:
                ConstraintActivity.intentToConstraintActivity(MainActivity.this);
                break;
            default:
                break;
        }
    }
}
