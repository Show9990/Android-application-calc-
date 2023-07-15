package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textResult;
    private StringBuilder currentNumber;
    private double result;
    private String operator;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textResult = findViewById(R.id.textView);
        currentNumber = new StringBuilder();
        operator = "";
        next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(MainActivity.this , MainActivity2.class);
                startActivity(intent);

            }
        });

        // Set click listeners for number buttons
        for (int i = 0; i <= 9; i++) {
            String buttonId = "button_" + i;
            int resId = getResources().getIdentifier(buttonId, "id", getPackageName());
            Button button = findViewById(resId);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    currentNumber.append(button.getText().toString());
                    textResult.setText(currentNumber.toString());
                }
            });
        }

        // Set click listener for operator buttons
        Button buttonAdd = findViewById(R.id.button_add);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("+");
            }
        });


        Button buttonSubtract=findViewById(R.id.button_subtract);
        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("-");
            }
        });
        Button buttonMultiply=findViewById(R.id.button_multiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("*");
            }
        });
        Button buttonDivide=findViewById(R.id.button_divide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation("/");
            }
        });
        Button buttonDecimal=findViewById(R.id.button_decimal);
        buttonDecimal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                performOperation(".");
            }
        });

        // Set click listener for equal button
        Button buttonEqual = findViewById(R.id.button_equal);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateResult();
            }
        });

        // Set click listener for clear button
        Button buttonClear = findViewById(R.id.button_clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCalculator();
            }
        });
    }

    private void performOperation(String newOperator) {
        if (!currentNumber.toString().isEmpty()) {
            double value = Double.parseDouble(currentNumber.toString());
            if (operator.equals("+")) {
                result += value;
            } else if (operator.equals("-")) {
                result -= value;
            } else if (operator.equals("*")) {
                result *= value;
            } else if (operator.equals("/")) {
                if (value != 0) {
                    result /= value;
                } else {
                    textResult.setText("Error");
                    return;
                }
            } else {
                result = value;
            }
        }
        operator = newOperator;
        currentNumber.setLength(0);
        textResult.setText(String.valueOf(result));
    }

    private void calculateResult() {
        if (!currentNumber.toString().isEmpty()) {
            double value = Double.parseDouble(currentNumber.toString());
            if (operator.equals("+")) {
                result += value;
            } else if (operator.equals("-")) {
                result -= value;
            } else if (operator.equals("*")) {
                result *= value;
            } else if (operator.equals("/")) {
                if (value != 0) {
                    result /= value;
                } else {
                    textResult.setText("Error");
                    return;
                }
            }
            currentNumber.setLength(0);
            textResult.setText(String.valueOf(result));
        }
    }

    private void clearCalculator() {
        result = 0;
        operator = "";
        currentNumber.setLength(0);
        textResult.setText("0");

    }
}