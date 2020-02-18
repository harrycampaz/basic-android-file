package com.dezzapps.staticfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = findViewById(R.id.textView);

        String data = readFile(this, R.raw.dedinition);

        textView.setText(data);

    }

    public static String readFile(Context context, int resId){
        InputStream stream = context.getResources().openRawResource(resId);

        InputStreamReader inputStreamReader = new InputStreamReader(stream);

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String currentine;

        StringBuilder builder = new StringBuilder();


        try {
            while ((currentine = bufferedReader.readLine()) != null){

                builder.append(currentine).append("\n");

            }

        }catch (IOException e){
            e.printStackTrace();
            return null;
        }

        return  builder.toString();
    }
}
