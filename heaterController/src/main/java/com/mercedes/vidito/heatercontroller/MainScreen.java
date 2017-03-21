package com.mercedes.vidito.heatercontroller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.Intent;

public class MainScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);
        final BluetoothController bluetoothController = new BluetoothController(this);
        final Button connectButton = (Button) findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    enableAdapter(bluetoothController);
                    connectToArduino(bluetoothController);
                }

        });

    }

    private void enableAdapter(BluetoothController controller){
        if(controller.existBluetoothAdapter()){
            controller.enableAdapter();
        } else {
            showMessage("Bluetooth adapter does not exists");
            finish();
        }


    }

    private void connectToArduino(BluetoothController controller){
        if (controller.connect()){
            showMessage("Connection establish with Arduino");
        } else {
            showMessage("Could not connect to Arduino");
            finish();
        }

    }

    private void showMessage(String message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // User chose not to enable Bluetooth.
        if (requestCode == Constants.REQUEST_ENABLE_BT && resultCode == RESULT_CANCELED) {
            showMessage("Could not enable Bluetooth");
            finish();
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



}
