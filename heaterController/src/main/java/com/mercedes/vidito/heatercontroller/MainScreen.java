package com.mercedes.vidito.heatercontroller;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainScreen extends AppCompatActivity {

    private BluetoothController bc;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainscreen);

        final Button connectButton = (Button) findViewById(R.id.button_connect);
        connectButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View view){
                    connectToArduino();
                }

        });

    }

    public void connectToArduino(){
        showMessage("Hola Que tal?");
    }

    public void showMessage (String message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
}
