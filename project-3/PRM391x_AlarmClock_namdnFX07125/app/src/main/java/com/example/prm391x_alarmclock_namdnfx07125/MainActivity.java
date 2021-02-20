package com.example.prm391x_alarmclock_namdnfx07125;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class MainActivity extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private AlarmArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView alarmsDisplay = (ListView) findViewById(R.id.alarmList);
        final List<Alarm> alarms = new ArrayList<>();

        adapter = new AlarmArrayAdapter(this, alarms);
        alarmsDisplay.setAdapter(adapter);

        for(int i=0;i<alarms.size();i++){
            if(alarms.get(i).isActive){
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, alarms.get(i).hour);
                calendar.set(Calendar.MINUTE, alarms.get(i).minute);
                Intent myIntent = new Intent(MainActivity.this, AlarmReceiver.class);
                pendingIntent = PendingIntent.getBroadcast(MainActivity.this, 0, myIntent, 0);
                alarmManager.set(AlarmManager.RTC, calendar.getTimeInMillis(), pendingIntent);
            }else{
                alarmManager.cancel(pendingIntent);
            }
        }

        ImageButton button = (ImageButton) findViewById(R.id.add_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker timePicker, int hour, int minute) {
        Alarm alarm = new Alarm();
        alarm.time = Integer.toString(hour) + ":" + Integer.toString(minute);
        alarm.hour = hour;
        alarm.minute = minute;
        alarm.isActive = true;
        adapter.add(alarm);
    }
}

