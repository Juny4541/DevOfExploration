package com.example.juny.devofexploration;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ChenRunFang
 */
public class MyAidlService extends Service {
    private List<PigBean> mPigBeans;

    public MyAidlService() {
    }

    private IBinder mIBinder = new IMyAidlInterface.Stub() {
        @Override
        public void addPig(PigBean pig) throws RemoteException {
            mPigBeans.add(pig);
        }

        @Override
        public List<PigBean> getPigList() throws RemoteException {
            return mPigBeans;
        }
    };

    @Override
    public IBinder onBind(Intent intent) {
        mPigBeans = new ArrayList<>();
        return mIBinder;
    }
}
