package ntu.edu.vn.phamvuonglamnhac.observerpattern;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity
        implements MyDateDialog.OnMyDateChangeListener, MyTimeDialog.OnMyTimeChangeListener {

    EditText editDate, editTime;
    ImageView imvDate, imvTime;
    Context contextDate, contextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addViews();
        addEvents();
    }
    private void addViews(){
        //Date
        editDate = findViewById(R.id.edNgayDi);
        editDate.setEnabled(false);
        imvDate = findViewById(R.id.imvDate);

        //Time
        editTime = findViewById(R.id.edTimeDi);
        editTime.setEnabled(false);
        editDate.setEnabled(false);
        imvTime = findViewById(R.id.imvTime);
    }
    private void addEvents(){
        //Date
        imvDate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                MyDateDialog dateDialog = new MyDateDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance());
                dateDialog.showDateDialog();
            }
        });

        imvTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyTimeDialog timeDialog = new MyTimeDialog(
                        MainActivity.this,
                        MainActivity.this,
                        Calendar.getInstance()
                );
                timeDialog.showTimeDialog();
            }
        });
    }


    @Override
    public void dateUpdate(Calendar newDate) {
        StringBuilder builder = new StringBuilder();
        builder.append(newDate.get(Calendar.DAY_OF_MONTH)).append("/")
                .append(newDate.get(Calendar.MONTH)).append("/")
                .append(newDate.get(Calendar.YEAR));
        editDate.setText(builder.toString());
    }

    @Override
    public void timeUpdate(Calendar newTime) {
        StringBuilder builder = new StringBuilder();
        builder.append(newTime.get(Calendar.HOUR_OF_DAY)).append("h")
                .append(newTime.get(Calendar.MINUTE)).append("m");
        editTime.setText(builder.toString());
    }
}
