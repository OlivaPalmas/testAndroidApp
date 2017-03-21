package com.mercedes.vidito.heatercontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.widget.Toast;

/**
 * Created by vidina.oliva on 21.03.2017.
 */

public class BluetoothController extends Object {

    private String bluetoothAddress;
    private BluetoothAdapter mBluetoothAdapter;

    {
        bluetoothAddress = "98:4F:EE:0F:4F:E7";
    }

    public BluetoothAdapter getBluetoothAdapter () {
        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        return mBluetoothAdapter;
    }



}
