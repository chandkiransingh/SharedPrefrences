package com.ck.sharedprefrences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences sharedPref;
    String userId;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        textView2 = findViewById(R.id.textView2);
        sharedPref = getSharedPreferences("MyData",MODE_PRIVATE);
        userId = sharedPref.getString("user_id", "default if empty");

        textView2.setText(userId);
    }
}
