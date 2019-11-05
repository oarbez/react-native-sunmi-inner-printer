package com.sunmi.innerprinter;

import android.content.BroadcastReceiver;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import android.content.Context;
import android.content.Intent;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import android.util.Log;

public class PrinterReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent data) {
        String action = data.getAction();
        String type = "PrinterStatus";
        Log.d("PrinterReceiver", action);

        try {
            if (SunmiInnerPrinterModule.reactApplicationContext != null) {
                SunmiInnerPrinterModule.reactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                    .emit(type, action);
            }
        } catch (Exception e) {
            Log.e("PrinterReceiver", "Unhandled sunmi exception", e);
        }
    }
}
