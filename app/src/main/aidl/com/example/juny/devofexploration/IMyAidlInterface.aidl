// IMyAidlInterface.aidl
package com.example.juny.devofexploration;

// Declare any non-default types here with import statements
import com.example.juny.devofexploration.PigBean;

interface IMyAidlInterface {
    void addPig(in PigBean pig);

       List<PigBean> getPigList();
}
