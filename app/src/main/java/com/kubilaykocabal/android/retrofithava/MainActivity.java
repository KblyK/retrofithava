package com.kubilaykocabal.android.retrofithava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public Button mButton;
    public  EditText editTextCity;
    public final static String EXTRA_MESSAGE = "com.kubilaykocabal.android.retrofithava.SEND";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton=(Button)findViewById(R.id.buttonSearch);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                editTextCity =(EditText)findViewById(R.id.editTextCity);
                String message = editTextCity.getText().toString();
                intent.putExtra(EXTRA_MESSAGE,message);
                startActivity(intent);
            }
        });
    }



}
