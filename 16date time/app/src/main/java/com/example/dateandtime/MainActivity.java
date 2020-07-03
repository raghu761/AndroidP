package com.example.dateandtime;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.MONTH;

public class MainActivity extends AppCompatActivity {

   // private TimePicker timePicker;
    private TextView textView;
    private DatePicker datePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        timePicker=findViewById(R.id.timepicker);
        textView=findViewById(R.id.textView);
        datePicker=findViewById(R.id.datepicker);

        Calendar calendar= Calendar.getInstance();
        datePicker.init(
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH),
                new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                        //CharSequence charSequence ="    " ;
                        textView.setText("year :"+i+"\nmonth :"+i1+1+"\n day"+i2);
                    }
                }
        );














//
//        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
//            @Override
//            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
//                textView.setText("Hour :" + i + "\nminutes " + i1);
//            }
//        });
    }
}
