package com.example.bottlemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    BottleDispenser bottleDispenser = BottleDispenser.getInstance();

    private TextView textViewSeek;
    private SeekBar seekBar;
    private TextView textView;
    String input;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSeek = (TextView) findViewById(R.id.textViewSeek);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Bottle> bottleAdapter = new ArrayAdapter<Bottle>(this, android.R.layout.simple_spinner_item, bottleDispenser.getPullolista());
        bottleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(bottleAdapter);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewSeek.setText(""+ progress + "");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }

    public void setTextData(String s){
        textView.setText(s);
    }
    public void insertMoney(View v){
        input = textViewSeek.getText().toString();
        int money = Integer.parseInt(input);
        setTextData(bottleDispenser.addMoney(money));
        seekBar.setProgress(0);
    }
    public void returnCoins(View v){
        setTextData(bottleDispenser.returnMoney());
    }
    public void chooseBottle(){

    }

}
