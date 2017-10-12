package info.rebin.android.thirdproject;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText question1answer;
    RadioButton question1answer2;
    CheckBox question3answer1;
    CheckBox question3answer2;
    CheckBox question3answer3;
    CheckBox question3answer4;
    EditText question4answer;
    RadioButton question5answer1;
    CheckBox question6answer1;
    CheckBox question6answer2;
    CheckBox question6answer3;
    CheckBox question6answer4;
    RadioGroup question5;
    RadioGroup question2;
    Button submit;
    int score;
    View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (!question1answer.getText().toString().isEmpty() || question2.getCheckedRadioButtonId() != -1 || isCheked(question3answer1, question3answer2, question3answer3, question3answer4) || !question4answer.getText().toString().isEmpty() || question5.getCheckedRadioButtonId() != -1 || isCheked(question6answer1, question6answer2, question6answer3, question6answer4)) {
                if (question1answer.getText().toString().toLowerCase().trim().equals("2003")) {
                    score += 1;
                } else {
                    score = score;
                }
                if (question1answer2.isChecked()) {
                    score += 1;
                }
                if (question3answer1.isChecked() && question3answer2.isChecked() && question3answer4.isChecked() && !question3answer3.isChecked()) {
                    score += 1;
                }
                if (question4answer.getText().toString().toLowerCase().trim().equals("ide")) {
                    score += 1;
                } else {
                    score = score;
                }
                if (question5answer1.isChecked()) {
                    score += 1;
                }
                if (question6answer1.isChecked() && question6answer3.isChecked() && question6answer4.isChecked() && !question6answer2.isChecked()) {
                    score += 1;
                }
                CharSequence text = "Your Result is " + score + " Out of 6";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
                score = 0;
            } else {
                CharSequence text = "You have to answer at least 1 Question";
                Toast.makeText(getApplicationContext(), text, Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        question1answer = (EditText) findViewById(R.id.q1EditText);
        question1answer2 = (RadioButton) findViewById(R.id.q2a2);
        question3answer1 = (CheckBox) findViewById(R.id.q3a1);
        question3answer2 = (CheckBox) findViewById(R.id.q3a2);
        question3answer3 = (CheckBox) findViewById(R.id.q3a3);
        question3answer4 = (CheckBox) findViewById(R.id.q3a4);
        question4answer = (EditText) findViewById(R.id.q4EditText);
        question5answer1 = (RadioButton) findViewById(R.id.q5a1);
        question6answer1 = (CheckBox) findViewById(R.id.q6a1);
        question6answer2 = (CheckBox) findViewById(R.id.q6a2);
        question6answer3 = (CheckBox) findViewById(R.id.q6a3);
        question6answer4 = (CheckBox) findViewById(R.id.q6a4);
        question2 = (RadioGroup) findViewById(R.id.RadioGroupForQuestion2);
        question5 = (RadioGroup) findViewById(R.id.RadioGroupForQuestion5);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(clickListener);
    }

    public boolean isCheked(CheckBox... checkBoxes) {

        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked())
                return true;
        }
        return false;
    }
}