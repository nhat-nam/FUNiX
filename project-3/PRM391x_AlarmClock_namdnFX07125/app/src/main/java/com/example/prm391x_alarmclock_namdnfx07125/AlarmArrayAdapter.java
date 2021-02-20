package com.example.prm391x_alarmclock_namdnfx07125;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class AlarmArrayAdapter extends ArrayAdapter<Alarm>{
    private final Context context;
    private final List<Alarm> alarms;

    public AlarmArrayAdapter(Context context, List<Alarm> alarms){
        super(context, R.layout.alarm, alarms);
        this.context = context;
        this.alarms = alarms;
    }

    static class ViewHolder{
        protected LinearLayout linearLayout;
        protected TextView title;
        protected CheckBox checkBox;
    }

    @Override
    public View getView(int index, View convertView, ViewGroup parent){
        View view;
        Alarm alarm = alarms.get(index);
        if(convertView == null){

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.alarm, null);

            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.linearLayout = (LinearLayout)view.findViewById(R.id.alarmlist_item);
            viewHolder.title = (TextView)view.findViewById(R.id.title);
            viewHolder.checkBox = (CheckBox)view.findViewById(R.id.activeToggleButton);

            viewHolder.title.setText(alarm.time);

            viewHolder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b){
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
            });
        }else{
            view = convertView;
        }
        return view;
    }
}
