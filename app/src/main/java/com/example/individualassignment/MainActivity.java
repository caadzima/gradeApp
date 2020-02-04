package com.example.individualassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.Format;

public class MainActivity extends AppCompatActivity {

    TextView Grade, Letter;
    EditText AEInput, APInput, PEInput, PPInput, MEInput, MPInput, FEInput, FPInput;
    Button calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }
    public void addListenerOnButton() {
        AEInput = (EditText)findViewById(R.id.editTextAE);
        APInput = (EditText)findViewById(R.id.editTextaAP);
        PEInput = (EditText)findViewById(R.id.editTextPE);
        PPInput = (EditText)findViewById(R.id.editText4PP);
        MEInput = (EditText)findViewById(R.id.editTextME);
        MPInput = (EditText)findViewById(R.id.editTextMP);
        FEInput = (EditText)findViewById(R.id.editTextFE);
        FPInput = (EditText)findViewById(R.id.editTextFP);

        calculate = (Button)findViewById(R.id.buttonResult);

        calculate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                double earnedPoints;
                double possiblePoints;
                double grade;
                DecimalFormat FORMAT = new DecimalFormat("#.#");


                String numberGrade;
                String letterGrade;

                Grade = (TextView)findViewById(R.id.textViewGrade);
                Letter = (TextView)findViewById(R.id.textViewLetter);

                String ae = AEInput.getText().toString();
                String ap = APInput.getText().toString();
                String pe = PEInput.getText().toString();
                String pp = PPInput.getText().toString();
                String me = MEInput.getText().toString();
                String mp = MPInput.getText().toString();
                String fe = FEInput.getText().toString();
                String fp = FPInput.getText().toString();

                earnedPoints = Double.parseDouble(ae) + Double.parseDouble(pe)
                        + Double.parseDouble(me) + Double.parseDouble(fe);

                possiblePoints = Double.parseDouble(ap) + Double.parseDouble(pp)
                        + Double.parseDouble(mp) + Double.parseDouble(fp);

                grade = (earnedPoints / possiblePoints) * 100;

                if(grade >= 90.0) {
                    letterGrade = "A";
                }
                else if(grade >= 80.0) {
                    letterGrade = "B";
                }
                else if(grade >= 70.0) {
                    letterGrade = "C";
                }
                else if(grade >= 60.0) {
                    letterGrade = "D";
                }
                else {
                    letterGrade = "F";
                }

                numberGrade = String.valueOf(grade);

                Grade.setText(numberGrade);
                Letter.setText(letterGrade);

            }
        });
    }


}
