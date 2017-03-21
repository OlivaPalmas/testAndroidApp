package com.mercedes.vidito.heatercontroller;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;

import java.io.IOException;
import java.util.UUID;


/**
 * Created by vidina.oliva on 21.03.2017.
 */

public class BluetoothController extends Object {

    private static final UUID MY_UUID = UUID.fromString("2320f898-0e52-11e7-93ae-92361f002671");
    private String bluetoothAddress;
    private Activity mainActivity;
    private BluetoothAdapter mBluetoothAdapter;


    public BluetoothController(Activity mainActivity) {
        this.mainActivity = mainActivity;
        this.bluetoothAddress = "98:4F:EE:0F:4F:E7";
        this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean existBluetoothAdapter() {

        if (mBluetoothAdapter != null) {
            return true;
        } else {
            return false;
        }
    }


    public void enableAdapter() {

        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            mainActivity.startActivityForResult(enableBtIntent, Constants.REQUEST_ENABLE_BT);
        }
    }


    public boolean connect() {
        BluetoothDevice arduino = mBluetoothAdapter.getRemoteDevice(bluetoothAddress);
        BluetoothSocket tmp = null;
        if (arduino != null) {
            try {
                tmp = arduino.createRfcommSocketToServiceRecord(MY_UUID);
            } catch (IOException ex) {
                return false;
            }
            try {
                tmp.connect();
            } catch (IOException e) {
                try {
                    tmp.close();
                    return false;
                } catch (IOException e1) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }

    }


}
