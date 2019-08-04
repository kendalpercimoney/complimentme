package com.kendalpercimoney.complimentme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Vibrator;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{



    private ImageView ballIV;
    private TextView answerTV;

    //strings to push on click
    private String[] answersArray = {"your perspective is refreshing. :)", "you’re more helpful than you realize. :)", " you’re even more beautiful on the inside than you are on the outside. :)",
            "you're most incredible when you're not afraid to be yourself :)", "you're a candle in the darkness :)", "you're really something special :)",
            "you're more fun than a ball pit filled with candy :)"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set window to full screen (under status bar - can't get it to work on the navigation bar)
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);




        ballIV = findViewById(R.id.btn);
        answerTV = findViewById(R.id.answer);

        ballIV.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn:

                answerTV.setText("hold on....");

                int rand = new Random().nextInt(answersArray.length);

                answerTV.setText(answersArray[rand]);

                //vibrate on touch
                Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    v.vibrate(VibrationEffect.createOneShot(50, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    //deprecated in API 26
                    v.vibrate(50);
                }

                break;

        }

    }
}
