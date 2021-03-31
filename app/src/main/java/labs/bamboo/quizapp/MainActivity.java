package labs.bamboo.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText framework;
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
        framework = findViewById(R.id.framework);
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

         if( framework.getText().toString().equals("Ruby on Rails") ){
            points += 25;
         }

         if( coffee.isChecked()  ){
            points += 25;
         }else if( nuts.isChecked() ){
            points += 0;
         }

         if ( windows.isChecked() ){
             points -= 15;
         }

         if ( linux.isChecked() ){
             points += 25;
         }

         if ( macosx.isChecked() ){
             points -= 10;
         }

         if( programming_language.getText().toString().equals("Ruby") ){
            points += 25;
         }

         score_value.setText(String.valueOf(points));
    }
}