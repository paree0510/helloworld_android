package com.example.pareekshithkj.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    EditText hour, minute, msg;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hour = (EditText) findViewById(R.id.hour);
        minute = (EditText) findViewById(R.id.minute);
        msg = (EditText) findViewById(R.id.msg);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent alarm = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, msg.getText().toString())
                        .putExtra(AlarmClock.EXTRA_HOUR, Integer.parseInt(hour.getText().toString()))
                        .putExtra(AlarmClock.EXTRA_MINUTES, Integer.parseInt(minute.getText().toString()))
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, true);

                if (alarm.resolveActivity(getPackageManager()) != null) {
                    startActivity(alarm);
                }
            }
        });
    }
}
