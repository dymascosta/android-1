package com.example.cliente.naoligamais;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.telephony.TelephonyManager;

import com.android.internal.telephony.ITelephony;

import java.lang.reflect.Method;


/**
 * Created by Cliente on 18/12/2017.
 */


public class Callbarring extends BroadcastReceiver {
    private String number;










    @Override
    public void onReceive(Context context, Intent intent)
    {

        if (!intent.getAction().equals("android.intent.action.PHONE_STATE"))
            return;


        else
        {
            BancoController crud = new BancoController(context);


            number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);


            if(crud.buscaRegistro(number))
            {

            disconnectPhoneItelephony(context);
            return;

            }
        }
    }


    @SuppressWarnings({ "rawtypes", "unchecked" })
    private void disconnectPhoneItelephony(Context context)
    {
        ITelephony telephonyService;
        TelephonyManager telephony =  (TelephonyManager)
                context.getSystemService(Context.TELEPHONY_SERVICE);
        try
        {
            Class c = Class.forName(telephony.getClass().getName());
            Method m = c.getDeclaredMethod("getITelephony");
            m.setAccessible(true);
            telephonyService = (ITelephony) m.invoke(telephony);
            telephonyService.endCall();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
