package labs.bamboo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText linuxCreator;
    private RadioButton coffee;
    private RadioButton nuts;
    private CheckBox windows;
    private CheckBox linux;
    private CheckBox macosx;
    private EditText programming_language;
    private TextView score_value;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialize();
    }

    public void initialize() {
        linuxCreator = findViewById(R.id.linux_creator);
        coffee = findViewById(R.id.coffee);
        nuts = findViewById(R.id.nuts);
        windows = findViewById(R.id.windows);
        linux = findViewById(R.id.linux);
        macosx = findViewById(R.id.macosx);
        programming_language = findViewById(R.id.programming_language);
        score_value = findViewById(R.id.score_value);
        Button submit = findViewById(R.id.submit);
        submit.setOnClickListener(v -> validateQuiz());
    }

    public void validateQuiz(){
         int points = 0;

         if( linuxCreator.getText().toString().equals("Ruby on Rails") ){
            points += 25;
         }

         if( coffee.isChecked()  ){
            points += 25;
         }else if( nuts.isChecked() ){
            points += 0;
         }

         if ( windows.isChecked() ){
             points += 0;
         }

         if ( linux.isChecked() ){
             points += 25;
         }

         if ( macosx.isChecked() ){
             points += 0;
         }

         if( programming_language.getText().toString().equals("C") ||
                 programming_language.getText().toString().equals("c") ){
            points += 25;
         }

         score_value.setText(String.valueOf(points));

         String scoreMessage = "Total Score: "+String.valueOf(points);

         Toast toast = Toast.makeText(getApplicationContext(), scoreMessage, Toast.LENGTH_LONG);
         toast.setGravity(Gravity.CENTER, 0, 0);
         toast.show();
    }
}