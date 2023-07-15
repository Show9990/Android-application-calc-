package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity2 extends AppCompatActivity {
    private EditText etA, etB, etC;
    private Button btnCalculate;
    private TextView Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        etA = findViewById(R.id.et_a);
        etB = findViewById(R.id.et_b);
        etC = findViewById(R.id.et_c);
        btnCalculate = findViewById(R.id.result);
        Result = findViewById(R.id.res);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateQuadraticEquation();
            }
        });
    }

    private void calculateQuadraticEquation() {
        double a = Double.parseDouble(etA.getText().toString());
        double b = Double.parseDouble(etB.getText().toString());
        double c = Double.parseDouble(etC.getText().toString());

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            Result.setText("Roots: " + root1 + ", " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            Result.setText("Root: " + root);
        } else {
            Result.setText("No real roots");
        }

    }
}