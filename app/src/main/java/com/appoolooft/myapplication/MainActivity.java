package com.appoolooft.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {
Switch mySwitch;
Sharedpref sharedpref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedpref =new Sharedpref(this);
        if (sharedpref.loadNightModeState()==true){
            setTheme(R.style.darkTheme);
        }
        else {
            setTheme(R.style.AppTheme);

        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mySwitch=findViewById(R.id.mySwich);
        if (sharedpref.loadNightModeState()==true){
            mySwitch.setChecked(true);
        }
        mySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    sharedpref.setNightMode(true);
                    restartApp();
                }
                else {
                    sharedpref.setNightMode(false);
                    restartApp();

                }
            }
        });
    }
    public void restartApp (){
        Intent intentRestartApp =new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intentRestartApp);
        finish();

    }
}
//Todo youtube address URL https://www.youtube.com/watch?v=-qsHE3TpJqw&t=19s