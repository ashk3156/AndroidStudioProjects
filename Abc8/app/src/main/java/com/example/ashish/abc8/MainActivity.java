package com.example.ashish.abc8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView) findViewById(R.id.hello);
    }
    public void Change(View view)
    {
        /*String message="i m ashish";
        textView.setText(message);*/
        String button_text;
        button_text=((Button) view) .getText().toString();
        if(button_text.equals("go to 2nd activity"))
        {
            Intent intent=new Intent(this,Main2Activity.class);
            startActivity(intent);
        }
        else if(button_text.equals("go to 3rd activity"))
        {
            Intent intent=new Intent(this,Main3Activity.class);
            startActivity(intent);
        }
    }
}
