package com.kony.zxingbarcodescanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.konylabs.vm.Function;

/**
 * @author KH2195 John Vinodh.
 */
public class MainActivity extends AppCompatActivity {

    private IntentIntegrator integrator;
    public static Function mCallback = null;
    String mData[] = new String[2];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        /***** Code to start the barcode scanning start*******/
        integrator= new IntentIntegrator(MainActivity.this);
        integrator.setPrompt("Scan a barcode");
        integrator.setCameraId(0);  // Use a specific camera of the device
        integrator.setOrientationLocked(false);
        integrator.setBarcodeImageEnabled(true);
        integrator.initiateScan();
        /***** Code to start the barcode scanning End*******/
    }

    /****
     * Once the Barcode scanning is done this Method gets invoked with the barcode scanning info.
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult intentResult = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        String barcodeResult ="";
        if(intentResult !=null) {
            if(intentResult.getContents() !=null) {
                barcodeResult = intentResult.getContents();
            } else {
                barcodeResult =  "Scanning Failed";
            }
                sendDataToKony(barcodeResult);

        }


    }

    /***
     * This Function uses the callback from Kony JS Function and returns the scanned data back to Kony.
     * @param pdata
     */
    public void sendDataToKony(String pdata) {
        if (mCallback != null) {
            try {
                mData[0] = pdata;
                mCallback.execute(mData);
                Toast.makeText(this, "Scanned: " + pdata, Toast.LENGTH_LONG).show();
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(this, "Unable to Send Data to Kony", Toast.LENGTH_LONG).show();
            }
        }
        finish();
    }
}
