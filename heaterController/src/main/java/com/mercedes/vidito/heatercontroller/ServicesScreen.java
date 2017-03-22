package com.mercedes.vidito.heatercontroller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by vidina.oliva on 22.03.2017.
 */

public class ServicesScreen extends Activity {

    private BluetoothDeviceService mBluetoothLeService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.servicescreen);

        final Button turnonButton = (Button) findViewById(R.id.button_turnon);
        turnonButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }

        });

    }
}
