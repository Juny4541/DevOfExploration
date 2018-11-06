package com.example.juny.devofexploration.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.juny.devofexploration.IMyAidlInterface;
import com.example.juny.devofexploration.MyAidlService;
import com.example.juny.devofexploration.PigBean;
import com.example.juny.devofexploration.R;

import java.util.List;

/**
 * 跨进程通信 - AIDL 实现示例页面
 *
 * @author ChenRunFang
 */
public class AIDLActivity extends BaseActivity {
    private IMyAidlInterface mIMyAidlInterface;
    private PigBean mPigBean;
    private Button mBindBtn;
    private Button mCommunicationBtn;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mIMyAidlInterface = null;
        }
    };

    /**
     * 跳转到AIDL示例页面
     */
    public static void intentToAIDLActivity(Context context) {
        Intent intent = new Intent(context, AIDLActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aidl);
        mBindBtn = findViewById(R.id.btn_bind);
        mCommunicationBtn = findViewById(R.id.btn_communication);

        mBindBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MyAidlService.class);
                bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
            }
        });

        mCommunicationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPigBean = new PigBean("zu", "100");
                try {
                    mIMyAidlInterface.addPig(mPigBean);
                    List<PigBean> mPigList = mIMyAidlInterface.getPigList();
                    Toast.makeText(AIDLActivity.this, "zhu = " + mPigList.get(0).name + mPigList.get(0).weight, Toast.LENGTH_SHORT).show();

                } catch (RemoteException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}

