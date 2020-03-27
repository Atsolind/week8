package com.example.bottlemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BottleDispenser bottleDispenser = BottleDispenser.getInstance();

    private TextView textViewSeek;
    private SeekBar seekBar;
    private TextView textView;
    String input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSeek = (TextView) findViewById(R.id.textViewSeek);
        seekBar = (SeekBar) findViewById(R.id.seekBar);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeek.setText(""+ progress + "€");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void addMoney(View v){
        input = textViewSeek.getText().toString();
        textView.setText("Money added: " +input);
        int money = Integer.parseInt(input);
        //bottleDispenser.addMoney(money);

    }

}
