package com.example.shan.demoapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnTrue, btnFalse, mNextButton;
    private  TextView mQuestionTextView;



    private Question[] mQuestionBank = new Question[]
        {
                new Question(R.string.question_australia,true),
                new Question(R.string.question_oceans, true),
                new Question(R.string.question_mideast,false)
        };

    private int mCurrentIndex = 0;
    private static final String KEY_INDEX = "index";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        Log.d("ActivityEvent", "onCreate event fired!");

        mQuestionTextView = (TextView)  findViewById(R.id.question_text_view);
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);

        btnFalse = (Button) findViewById(R.id.btn_false);
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Incorrect!"
                , Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }




    public void showNext(View v){
        mCurrentIndex++;
        if(mCurrentIndex>=mQuestionBank.length) {
            Toast.makeText(MainActivity.this, "Finished!",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.d("ActivityEvent", "onStart event fired!");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.d("ActivityEvent", "onResume event fired!");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.d("ActivityEvent", "onPause event fired!");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.d("ActivityEvent", "onStop event fired!");

    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d("ActivityEvent", "onDestroy event fired!");

    }

    public void trueClick(View v){
        Toast.makeText(MainActivity.this, "Correct"
                , Toast.LENGTH_SHORT).show();
    }

    /*
    public void btnFalseClick(View v){
        Toast.makeText(MainActivity.this, "Incorrect"
                , Toast.LENGTH_SHORT).show();
    }*/


}
