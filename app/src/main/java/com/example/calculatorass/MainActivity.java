package com.example.calculatorass;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView input, output;
    Button all_clear, clear, equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input_text);
        output = findViewById(R.id.out);
        all_clear = findViewById(R.id.ac);
        clear = findViewById(R.id.c);
        equal = findViewById(R.id.equal);

        equal.setOnClickListener(v -> {
            String data = input.getText().toString();
            try {
                double result = calculate(data);
                output.setText(String.valueOf(result));
            } catch (Exception e) {
                output.setText("Error");
            }
        });

        all_clear.setOnClickListener(v -> {
            input.setText("");
            output.setText("");
        });

        clear.setOnClickListener(v -> {
            String text = input.getText().toString();
            if (text.length() > 0) {
                input.setText(text.substring(0, text.length() - 1));
            }
        });
    }


    public void getvalue(View view) {
        Button btn = (Button) view;
        input.setText(input.getText().toString() + btn.getText().toString());
    }

    public double calculate(String data) {
        String[] parts;

        if (data.contains("+")) {
            parts = data.split("\\+");
            return Double.parseDouble(parts[0]) + Double.parseDouble(parts[1]);
        }
        else if (data.contains("-")) {
            parts = data.split("-");
            return Double.parseDouble(parts[0]) - Double.parseDouble(parts[1]);
        }
        else if (data.contains("*")) {
            parts = data.split("\\*");
            return Double.parseDouble(parts[0]) * Double.parseDouble(parts[1]);
        }
        else if (data.contains("/")) {
            parts = data.split("/");
            return Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
        }
        return 0;
    }
}