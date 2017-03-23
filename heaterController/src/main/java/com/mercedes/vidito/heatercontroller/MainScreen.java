package com.mercedes.vidito.heatercontroller;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainScreen extends AppCompatActivity {

    private BluetoothAdapter mBluetoothAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        final Button connectButton = (Button) findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                enableAdapter();
                Intent openScreenTwo = new Intent(view.getContext(), ServicesScreen.class);
                startActivityForResult(openScreenTwo, 0);
            }

        });

    }

    private void enableAdapter() {
        final BluetoothManager mBluetoothManager = (BluetoothManager) getSystemService(Context.BLUETOOTH_SERVICE);
        if (mBluetoothManager == null){
            showMessage("Bluetooth not supported");
            finish();
            return;
        }
        mBluetoothAdapter = mBluetoothManager.getAdapter();

        mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

        if (mBluetoothAdapter == null) {
            showMessage("Bluetooth not supported");
            finish();
            return;
        } else {
            if (!mBluetoothAdapter.isEnabled()) {
                Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(enableBtIntent, CONSTANTS.REQUEST_ENABLE_BT);
            }
            showMessage("Bluetooth is enabled");

        }
    }


    private void showMessage(String message) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // User chose not to enable Bluetooth.
        if (requestCode == CONSTANTS.REQUEST_ENABLE_BT && resultCode == RESULT_CANCELED) {
            showMessage("Could not enable Bluetooth");
            finish();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
