package id.immaker.valerian.programmingquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final EditText name = (EditText) findViewById(R.id.name_edit_text);
        Button enterQuiz = (Button) findViewById(R.id.button_enter);
        enterQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                String nameParticipant = name.getText().toString();
                if (nameParticipant.equals("")) {
                    name.setError("You must enter this");
                } else {
                    intent.putExtra("EXTRA_SESSION_NAME", nameParticipant);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back again to Exit Application", Toast.LENGTH_SHORT).show();
            exit = true;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    exit = false;
                }
            }, 3*1000);

        }
    }
}
