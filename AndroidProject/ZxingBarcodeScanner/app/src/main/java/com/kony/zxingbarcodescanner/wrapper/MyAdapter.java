package com.kony.zxingbarcodescanner.wrapper;

import android.content.Intent;

import com.google.zxing.integration.android.IntentIntegrator;
import com.kony.zxingbarcodescanner.MainActivity;
import com.konylabs.android.KonyMain;
import com.konylabs.vm.Function;

/**
 * Created by KH2195 John Vinodh on 27-Aug-18.
 */

public class MyAdapter {

    private static IntentIntegrator integrator;
    public static Function mCallback = null;

    /****
     * Invokes the third party Android Studio Activity to scan the barcode.
     * @param pCallback to send the result back to Kony JS Function
     */
    public static void invokeBarcodeScanner(Function pCallback) {
        MainActivity.mCallback = pCallback;
        KonyMain context = KonyMain.getActivityContext();
        Intent intent = new Intent(context,MainActivity.class);
        context.startActivity(intent);
    }

    /**********
     * This sets the Kony Activity Life Cycle Listener.
     * You will receive the callbacks for onResume, onPause, onActivityResult etc.
     */
    public static void setKonyActivityLifeCycleListener() {
        KonyMain.addActivityLifeCycleListener(new MyKonyActivityLifeCycleListener());
    }

    /*******
     * This function directly invokes the library scanning activity.
     * @param pcallback to send the result back to Kony JS Function
     */
    public static void invokeBarcodeScannerActivity(Function pcallback) {
        mCallback = pcallback;
        KonyMain context = KonyMain.getActivityContext();
        integrator= new IntentIntegrator(context);
        integrator.setPrompt("Scan a barcode");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setOrientationLocked(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
    }
}
