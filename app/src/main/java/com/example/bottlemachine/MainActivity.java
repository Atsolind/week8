package com.example.bottlemachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    BottleDispenser bottleDispenser = BottleDispenser.getInstance();

    private TextView textViewSeek;
    private SeekBar seekBar;
    private TextView textView;
    private Spinner spinner;
    Context context = null;
    Bottle choice;
    String bottleReceipt = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = MainActivity.this;
        System.out.println("Tiedostosijainti: ");
        System.out.println(context.getFilesDir());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewSeek = (TextView) findViewById(R.id.textViewSeek);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);
        final ArrayList<Bottle> pullo = bottleDispenser.getPullolista();

        ArrayAdapter<Bottle> bottleAdapter = new ArrayAdapter<Bottle>(this, android.R.layout.simple_spinner_item, bottleDispenser.getPullolista());
        bottleAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(bottleAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                choice = pullo.get(pos);
                String item = parent.getItemAtPosition(pos).toString();
                Toast.makeText(parent.getContext(), "Selected: "+ item, Toast.LENGTH_SHORT).show();
            }
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

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
        String input = textViewSeek.getText().toString();
        int money = Integer.parseInt(input);
        setTextData(bottleDispenser.addMoney(money));
        seekBar.setProgress(0);
    }
    public void returnCoins(View v){
        setTextData(bottleDispenser.returnMoney());
    }
    public void purchase(View v){
        bottleReceipt= null;
        setTextData(bottleDispenser.buyBottle(choice));
        bottleReceipt = choice.getName()+ " : " + choice.getCost() + "€";

    }
    public void saveFile(View v){
        setTextData("Printing receipt.");
        String fileName = "bottle.txt";
        OutputStreamWriter outputStreamWriter = null;
        try {
            outputStreamWriter = new OutputStreamWriter(context.openFileOutput(fileName, Context.MODE_PRIVATE));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.write("************ RECEIPT ************" +"\n");
            outputStreamWriter.write(bottleReceipt);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outputStreamWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
