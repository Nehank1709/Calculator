package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String temporary_holder = "";
    int first_number;
    int second_number;
    EditText out_result;
    TextView tvv;
    String op="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        out_result = findViewById(R.id.output);
    }

    public void function(View view) {
        TextView tv = (TextView) view;
        if(op.equals("")){
           String digit_extracted = tv.getText().toString();
            temporary_holder += digit_extracted;
            out_result.setText(temporary_holder);}
         if(op.equals("+")||op.equals("--")||op.equals("*")||op.equals("/")||op.equals("%")) {
             String digit_extracted = tv.getText().toString();
             temporary_holder += digit_extracted;
             out_result.setText(temporary_holder);
        }

    }

    public void operator_function(View view) {
        tvv = (TextView) view;
        op= tvv.getText().toString();
        first_number = Integer.parseInt(temporary_holder);
        temporary_holder = "";

    }

    public void operate(String s){
        String k="";
        second_number=Integer.parseInt(temporary_holder);
        temporary_holder="";
        switch (s){
        case "+": k= String.valueOf(first_number+second_number);
            out_result.setText(k);
            op="";
            break;
            case "*": k="";
                k= String.valueOf(first_number*second_number);
            out_result.setText(k);
            op="";
                break;
            case "--":   k="";
                k= String.valueOf(first_number-second_number);
            out_result.setText(k);
            op="";
                break;
           case "/": k="";
               k= String.valueOf(first_number/second_number);
            out_result.setText(k);
            op="";
               break;

            case "%": k="";
                k= String.valueOf(first_number%second_number);
            out_result.setText(k);
            op="";break;
    }}

    public void yes(View view){
        operate(op);

    }
    public void allclear(View view){
        temporary_holder="";
        out_result.setText(temporary_holder);

    }
    public void clearlastdigit(View view){
        int length=temporary_holder.length();
        temporary_holder=temporary_holder.substring(0,length-1);
        out_result.setText(temporary_holder);

    }
    public void changesign(View view){
        int m=-Integer.parseInt(temporary_holder);
            out_result.setText(m);
           }
}