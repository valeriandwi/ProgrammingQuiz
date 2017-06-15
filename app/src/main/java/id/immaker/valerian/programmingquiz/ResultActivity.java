package id.immaker.valerian.programmingquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.defaultValue;
import static android.R.attr.format;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        setTitle("Result");
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        String name = getIntent().getStringExtra("EXTRA_SESSION_NAME");
        double score = getIntent().getDoubleExtra("EXTRA_SESSION_SCORE",defaultValue);
        TextView nameTextView = (TextView)findViewById(R.id.name_result);
        TextView scoreTextView = (TextView)findViewById(R.id.score_result);
        nameTextView.setText(name+"'s");
        scoreTextView.setText("Score : "+score);
        ImageView imageResult = (ImageView)findViewById(R.id.image_result);
        TextView messageResult = (TextView)findViewById(R.id.messages);
        if(score == 100){
            messageResult.setText("PERFECT!");
            imageResult.setImageResource(R.drawable.emoji_5);
        }else if(score >= 70 && score <=90){
            messageResult.setText("Good Job!");
            imageResult.setImageResource(R.drawable.emoji_4);
        }else if(score >= 50 && score <=70){
            messageResult.setText("Keep Fighting!");
            imageResult.setImageResource(R.drawable.emoji_3);
        }else{
            messageResult.setText("Sorry");
            imageResult.setImageResource(R.drawable.emoji_2);
        }
        Toast.makeText(this, "Congratulations ! Your score : "+score, Toast.LENGTH_SHORT).show();

        Button explanationButton = (Button)findViewById(R.id.explanation_button);
        explanationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ResultActivity.this,ExplanationActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
            Intent intent = new Intent(ResultActivity.this,MainActivity.class);
            startActivity(intent);
            finish();
    }
}
