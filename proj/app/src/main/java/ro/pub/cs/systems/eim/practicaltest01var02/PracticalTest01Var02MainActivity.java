package ro.pub.cs.systems.eim.practicaltest01var02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var02MainActivity extends AppCompatActivity {

    private EditText field1;
    private EditText field2;
    private EditText result;
    private Button plus_button;
    private Button minus_button;
    private Button transfer_button;


    private PlusButtonClickListener plusButtonClickListener = new PlusButtonClickListener();
    private class PlusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int sum = 0;
            try {
                sum = Integer.parseInt(field1.getText().toString()) + Integer.parseInt(field2.getText().toString());
            } catch(NumberFormatException ex){
                Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG).show();
                return;
            }
            result.setText(field1.getText().toString() + " + " + field2.getText().toString() + " = " + sum);
        }
    }

    private MinusButtonClickListener minusButtonClickListener = new MinusButtonClickListener();
    private class MinusButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int diff = Integer.parseInt(field1.getText().toString()) - Integer.parseInt(field2.getText().toString());
            result.setText(field1.getText().toString() + " - " + field2.getText().toString() + " = " + diff);
        }
    }

    private TransferButtonClickListener transferButtonClickListener = new TransferButtonClickListener();
    private class TransferButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            String send = result.getText().toString();
            Intent intent = new Intent("ro.pub.cs.systems.eim.practicaltest01var02.PracticalTest01Var02MainActivity");
            intent.putExtra("operation", send);
            startActivityForResult(intent, 2017);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
            savedInstanceState.putString("field1", field1.getText().toString());


            savedInstanceState.putString("field2", field2.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var02_main);

        field1 = (EditText)findViewById(R.id.first_field);
        field2 = (EditText)findViewById(R.id.second_field);
        result = (EditText)findViewById(R.id.result_field);
        plus_button = (Button)findViewById(R.id.plus_button);
        minus_button = (Button)findViewById(R.id.minus_button);
        transfer_button = (Button)findViewById(R.id.transfer_button);

        plus_button.setOnClickListener(plusButtonClickListener);
        minus_button.setOnClickListener(minusButtonClickListener);
        transfer_button.setOnClickListener(transferButtonClickListener);

        if(savedInstanceState != null) {
            String toPrint = new String();
            int ok = 0;
            if (savedInstanceState.containsKey("field1")) {
                toPrint.concat(savedInstanceState.getString("field1") + " ");
                //Toast.makeText(getApplicationContext(), savedInstanceState.getString("field1"), Toast.LENGTH_LONG).show();
                toPrint = toPrint + savedInstanceState.getString("field1") + " ";
                ok = 1;
            }

            if (savedInstanceState.containsKey("field2")) {
                //toPrint.concat(savedInstanceState.getString("field2"));
                toPrint = toPrint + savedInstanceState.getString("field2");
                ok = 1;
            }
            if(ok == 1) {
                Toast.makeText(getApplicationContext(), toPrint, Toast.LENGTH_LONG).show();
            }
        }
    }
}
