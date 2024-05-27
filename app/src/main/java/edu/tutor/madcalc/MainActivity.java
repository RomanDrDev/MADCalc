package edu.tutor.madcalc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView result, operation;
    TextView b_back, b_ac, b_res;
    TextView b_sqrt, b_log2, b_ln, b_leftb, b_rightb, b_exp, b_sin, b_cos, b_pi, b_e;
    TextView b_1, b_2, b_3, b_4, b_5 ,b_6, b_7, b_8, b_9, b_0, b_000, b_dot;
    TextView b_add, b_sub, b_div, b_mul, b_percent;
    Button button_cos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        result  = findViewById(R.id.result);
        operation = findViewById(R.id.operation);

        b_back = findViewById(R.id.b_back);
        b_ac = findViewById(R.id.b_ac);
        b_res = findViewById(R.id.b_res);

        b_sqrt = findViewById(R.id.b_sqrt);
        b_log2 = findViewById(R.id.b_log2);
        b_ln = findViewById(R.id.b_ln);
        b_leftb = findViewById(R.id.b_leftb);
        b_rightb = findViewById(R.id.b_rightb);
        b_exp = findViewById(R.id.b_exp);
        b_sin = findViewById(R.id.b_sin);
        b_cos = findViewById(R.id.b_cos);
        b_pi = findViewById(R.id.b_pi);
        b_e = findViewById(R.id.b_e);

        b_add = findViewById(R.id.b_add);
        b_sub = findViewById(R.id.b_sub);
        b_div = findViewById(R.id.b_div);
        b_mul = findViewById(R.id.b_mul);
        b_percent = findViewById(R.id.b_percent);

        b_1 = findViewById(R.id.b_1);
        b_2 = findViewById(R.id.b_2);
        b_3 = findViewById(R.id.b_3);
        b_4 = findViewById(R.id.b_4);
        b_5 = findViewById(R.id.b_5);
        b_6 = findViewById(R.id.b_6);
        b_7 = findViewById(R.id.b_7);
        b_8 = findViewById(R.id.b_8);
        b_9 = findViewById(R.id.b_9);
        b_0 = findViewById(R.id.b_0);
        b_000 = findViewById(R.id.b_000);
        b_dot = findViewById(R.id.b_dot);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = result.getText().toString();

                if (!val.equals("Error") && (!val.isEmpty())) {
                    DecimalFormat df = new DecimalFormat("0.################");
                    operation.setText((df.format(Double.parseDouble(val))).replace(',', '.'));
                }
                    result.setText("");
            }
        });

        // region system_button
        b_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                if (!val.isEmpty()) {
                    val = val.substring(0, val.length() - 1);
                    operation.setText(val);
                }
            }
        });
        b_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operation.setText("");
                result.setText("");
            }
        });
        b_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                if (!val.isEmpty()) {
                    try {
                        Expression expr = (new ExpressionBuilder(val)).build();
                        result.setText(String.valueOf(expr.evaluate()));
                    } catch (Exception e) {
                        result.setText("Error");
                    }
                }
            }
        });
        // endregion

        // region extended_operations
        b_sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "sqrt(");
            }
        });
        b_log2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "log2(");
            }
        });
        b_ln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "log(");
            }
        });
        b_leftb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "(");
            }
        });
        b_rightb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + ")");
            }
        });
        b_exp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "^");
            }
        });
        b_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "sin(");
            }
        });
        b_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "cos(");
            }
        });
        b_pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                //operation.setText(val + "3.141592653");
                operation.setText(val + "π");
            }
        });
        b_e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                //operation.setText(val + "2.718281828");
                operation.setText(val + "e");
            }
        });
        // endregion

        // region base_operations
        b_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "+");
            }
        });
        b_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "-");
            }
        });
        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "/");
            }
        });
        b_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "*");
            }
        });
        b_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "%");
            }
        });
        // endregion

        // region numeric_buttons
        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "1");
            }
        });
        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "2");
            }
        });
        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "3");
            }
        });
        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "4");
            }
        });
        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "5");
            }
        });
        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "6");
            }
        });
        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "7");
            }
        });
        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "8");
            }
        });
        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "9");
            }
        });
        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "0");
            }
        });
        b_000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + "000");
            }
        });
        b_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = operation.getText().toString();
                operation.setText(val + ".");
            }
        });
        // endregion

    }
}