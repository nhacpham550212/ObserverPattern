package ntu.edu.vn.phamvuonglamnhac.observerpattern;

import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.TimePicker;

import java.util.Calendar;

public class MyTimeDialog {
    Context context;

    MyTimeDialog.OnMyTimeChangeListener onMyTimeChangeListener;
    Calendar calendar;

    public MyTimeDialog(Context context, OnMyTimeChangeListener onMyTimeChangeListener, Calendar calendar) {
        this.context = context;
        this.onMyTimeChangeListener = onMyTimeChangeListener;
        this.calendar = calendar;
    }

    public void showTimeDialog(){
        TimePickerDialog.OnTimeSetListener Listener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                calendar.set(hourOfDay, minute);
                if (onMyTimeChangeListener!=null) onMyTimeChangeListener.timeUpdate(calendar);

            }
        };

        TimePickerDialog timePickerDialog = new TimePickerDialog(context, Listener,
                calendar.get(Calendar.HOUR_OF_DAY),
                calendar.get(Calendar.MINUTE),
                true
        );
        timePickerDialog.show();
    }

    public static interface OnMyTimeChangeListener{
        public void timeUpdate(Calendar newTime);
    }
}