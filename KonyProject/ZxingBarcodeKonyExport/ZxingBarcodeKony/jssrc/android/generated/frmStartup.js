function addWidgetsfrmStartup() {
    frmStartup.setDefaultUnit(kony.flex.DP);
    var Button0j5bbeec5679a4b = new kony.ui.Button({
        "focusSkin": "defBtnFocus",
        "height": "50dp",
        "id": "Button0j5bbeec5679a4b",
        "isVisible": true,
        "left": "56dp",
        "onClick": AS_Button_jf5dbf93f53e40ab9c7fa04891906ef2,
        "skin": "defBtnNormal",
        "text": "Start BarCode Scan",
        "top": "55dp",
        "width": "260dp",
        "zIndex": 1
    }, {
        "contentAlignment": constants.CONTENT_ALIGN_CENTER,
        "displayText": true,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {});
    var lblScanResult = new kony.ui.Label({
        "id": "lblScanResult",
        "isVisible": true,
        "left": "55dp",
        "skin": "defLabel",
        "text": "Scan Result",
        "textStyle": {
            "letterSpacing": 0,
            "strikeThrough": false
        },
        "top": "312dp",
        "width": kony.flex.USE_PREFFERED_SIZE,
        "zIndex": 1
    }, {
        "contentAlignment": constants.CONTENT_ALIGN_MIDDLE_LEFT,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {
        "textCopyable": false
    });
    frmStartup.add(Button0j5bbeec5679a4b, lblScanResult);
};

function frmStartupGlobals() {
    frmStartup = new kony.ui.Form2({
        "addWidgets": addWidgetsfrmStartup,
        "enabledForIdleTimeout": false,
        "id": "frmStartup",
        "layoutType": kony.flex.FREE_FORM,
        "needAppMenu": false,
        "skin": "slForm"
    }, {
        "displayOrientation": constants.FORM_DISPLAY_ORIENTATION_PORTRAIT,
        "layoutType": kony.flex.FREE_FORM,
        "padding": [0, 0, 0, 0],
        "paddingInPixel": false
    }, {
        "footerOverlap": false,
        "headerOverlap": false,
        "menuPosition": constants.FORM_MENU_POSITION_AFTER_APPMENU,
        "retainScrollPosition": false,
        "titleBar": true,
        "titleBarSkin": "slTitleBar",
        "windowSoftInputMode": constants.FORM_ADJUST_PAN
    });
};