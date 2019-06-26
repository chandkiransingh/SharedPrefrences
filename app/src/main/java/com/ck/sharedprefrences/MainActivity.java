package com.ck.sharedprefrences;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    EditText editText;
    Button button,next;
    String userId="blank";
    SharedPreferences sharedPref ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        next = findViewById(R.id.next);



        button.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ApplySharedPref")
            @Override
            public void onClick(View view) {

               userId = editText.getText().toString();
                // get or create SharedPreferences
                sharedPref = getSharedPreferences("MyData", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();

                // save your string in SharedPreferences
                editor.putString("user_id", userId);
                editor.commit();

                textView.setText(userId);

            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });

        textView.setText(userId);
    }
}
