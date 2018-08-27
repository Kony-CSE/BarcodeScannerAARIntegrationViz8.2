//Type your code here
function onBtnScanBarcodeClick() {
    NSBarcodeScan.startScannring(
        /**Function*/
        onScanningResultCallback);
}

function onScanningResultCallback(response) {
    frmStartup.lblScanResult.text = "Scan Result ::" + response;
}