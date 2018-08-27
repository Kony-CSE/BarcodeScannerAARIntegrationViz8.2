package com.kony.zxingbarcodescanner.wrapper;

import android.content.Intent;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.konylabs.android.KonyMain;
import com.konylabs.ffi.KonyActivityLifeCycleListener;

/**
 * Created by KH2195 on 28-Aug-18.
 */

class MyKonyActivityLifeCycleListener extends KonyActivityLifeCycleListener {

    String mData[] = new String[2];
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if(intentResult !=null && intentResult.getContents() !=null) {
            String barcodeResult = intentResult.getContents();
            sendDataToKony(barcodeResult);
        }
    }

    public void sendDataToKony(String pdata) {
        KonyMain context = KonyMain.getActivityContext();
        if (MyAdapter.mCallback != null) {
            try {
                mData[0] = pdata;
                MyAdapter.mCallback.execute(mData);
                Toast.makeText(context, "Scanned: " + pdata, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(context, "Unable to Send Data to Kony", Toast.LENGTH_LONG).show();
            }
        }
    }
}
