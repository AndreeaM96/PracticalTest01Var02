package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PacticalTest01Var02SecondaryActivity extends AppCompatActivity {

    EditText field;
    Button cor;
    Button incorr;

    private Listen1 listener1 = new Listen1();
    private class Listen1 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(1, new Intent());
            finish();
        }
    }

    private Listen2 listener2 = new Listen2();
    private class Listen2 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            setResult(2, new Intent());
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pactical_test01_var02_secondary);

        field = (EditText)findViewById(R.id.result_field);
        cor = (Button)findViewById(R.id.correct_button);
        incorr = (Button)findViewById(R.id.incorrect_button);

        Intent intent = getIntent();
        if (intent != null) {
            String op = intent.getStringExtra("operation");
            if (op != null) {
                field.setText(op);
            } else {
                Toast.makeText(this, "No operation", Toast.LENGTH_LONG).show();
            }
        }

        cor.setOnClickListener(listener1);
        cor.setOnClickListener(listener2);
    }
}
