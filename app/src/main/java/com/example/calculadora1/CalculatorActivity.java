package com.example.calculadora1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CalculatorActivity extends AppCompatActivity {

    private TextView tvResult;
    private Button btnClear;
    private Button btnplus;
    private Button btnDivide;
    private Button btnMultiply;
    private Button btnMinus;
    private Button btnEquals;
    private Button btnDot;
    private Button btn0;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private boolean isNewOperation = true;
    private double currentValue = 0;
    private double lastValue = 0;
    private String lastOperator = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        tvResult = findViewById(R.id.tv_result);
        btnClear = findViewById(R.id.btn_clear);
        btnDivide = findViewById(R.id.btn_divide);
        btnplus = findViewById(R.id.btn_plus);
        btnMultiply = findViewById(R.id.btn_multiply);
        btnMinus = findViewById(R.id.btn_minus);
        btnEquals = findViewById(R.id.btn_equals);
        btnDot = findViewById(R.id.btn_dot);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                lastOperator = "/";
                isNewOperation = true;
            }
        });

        btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                lastOperator = "*";
                isNewOperation = true;
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                lastOperator = "-";
                isNewOperation = true;
            }
        });
        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                lastOperator = "+";
                isNewOperation = true;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculate();
                isNewOperation = true;
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isNewOperation) {
                    tvResult.setText("0.");
                    isNewOperation = false;
                } else if (!tvResult.getText().toString().contains(".")) {
                    tvResult.append(".");
                }
            }
        });

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("0");
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("2");
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("4");
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appendNumber("9");
            }
        });
    }

    private void clear() {
        tvResult.setText("0");
        isNewOperation = true;
        lastOperator = "";
        currentValue = 0;
        lastValue = 0;
    }

    private void appendNumber(String num) {
        if (isNewOperation) {
            tvResult.setText(num);
            isNewOperation = false;
        } else {
            tvResult.append(num);
        }
    }

    private void calculate() {
        if (isNewOperation) {
            return;
        }

        double value = Double.parseDouble(tvResult.getText().toString());

        if (lastOperator.equals("+")) {
            currentValue = lastValue + value;
        } else if (lastOperator.equals("-")) {
            currentValue = lastValue - value;
        } else if (lastOperator.equals("*")) {
            currentValue = lastValue * value;
        } else if (lastOperator.equals("/")) {
            currentValue = lastValue / value;
        } else {
            currentValue = value;
        }

        lastValue = currentValue;
        tvResult.setText(String.valueOf(currentValue));
        lastOperator = "";
    }
}