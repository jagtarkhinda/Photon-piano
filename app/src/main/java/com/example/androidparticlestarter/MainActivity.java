package com.example.androidparticlestarter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.particle.android.sdk.cloud.ParticleCloud;
import io.particle.android.sdk.cloud.ParticleCloudSDK;
import io.particle.android.sdk.cloud.ParticleDevice;
import io.particle.android.sdk.cloud.exceptions.ParticleCloudException;
import io.particle.android.sdk.utils.Async;

public class MainActivity extends AppCompatActivity {
    // MARK: Debug info
    private final String TAG="JSK";

    // MARK: Particle Account Info
    private final String PARTICLE_USERNAME = "jsk5755@gmail.com";
    private final String PARTICLE_PASSWORD = "Alpha123";

    // MARK: Particle device-specific info
    private final String DEVICE_ID = "22001d000447363333343435";

    // MARK: Particle Publish / Subscribe variables
    private long subscriptionId;

    // MARK: Particle device
    private ParticleDevice mDevice;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. Initialize your connection to the Particle API
        ParticleCloudSDK.init(this.getApplicationContext());

        // 2. Setup your device variable
        getDeviceFromCloud();
        //CREATING BUTTONS
          Button c1 = findViewById(R.id.c1);
        Button cd = findViewById(R.id.cd);
        Button d = findViewById(R.id.d);
        Button de = findViewById(R.id.de);
        Button e = findViewById(R.id.e);
        Button f = findViewById(R.id.f);
        Button fg = findViewById(R.id.fg);
        Button g = findViewById(R.id.g);
        Button ga = findViewById(R.id.ga);
        Button a = findViewById(R.id.a);
        Button ab = findViewById(R.id.ab);
        Button b = findViewById(R.id.b);
        Button c2 = findViewById(R.id.c2);


        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"C2,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"C5,8,D5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"D3,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        de.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"D5,8,E5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"E5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"F6,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        fg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"F5,8,G5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"G7,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"G5,8,A5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"A5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        ab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"A5,8,B5,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"B4,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commandToSend = "\"C1,8\"";
                Log.d(TAG, "Command to send to particle: " + commandToSend);
                deviceData(commandToSend);
            }
        });

   }



    /**
     * Custom function to connect to the Particle Cloud and get the device
     */
    public void getDeviceFromCloud() {
        // This function runs in the background
        // It tries to connect to the Particle Cloud and get your device
        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {

            @Override
            public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {
                particleCloud.logIn(PARTICLE_USERNAME, PARTICLE_PASSWORD);
                mDevice = particleCloud.getDevice(DEVICE_ID);
                return -1;
            }

            @Override
            public void onSuccess(Object o) {
                Log.d(TAG, "Successfully got device from Cloud");
            }

            @Override
            public void onFailure(ParticleCloudException exception) {
                Log.d(TAG, exception.getBestMessage());
            }
        });
    }

    //calling this function
    public void deviceData(String commandToSend){
        Async.executeAsync(ParticleCloudSDK.getCloud(), new Async.ApiWork<ParticleCloud, Object>() {
            @Override
            public Object callApi(@NonNull ParticleCloud particleCloud) throws ParticleCloudException, IOException {

                // 2. build a list and put the r,g,b into the list
                List<String> functionParameters = new ArrayList<String>();
                functionParameters.add(commandToSend);

                // 3. send the command to the particle
                try {
                    mDevice.callFunction("sound", functionParameters);
                } catch (ParticleDevice.FunctionDoesNotExistException e) {
                    e.printStackTrace();
                }

                return -1;
            }

            @Override
            public void onSuccess(Object o) {
                Log.d(TAG, "Sent colors command to device.");
            }

            @Override
            public void onFailure(ParticleCloudException exception) {
                Log.d(TAG, exception.getBestMessage());
            }
        });
    }

}
