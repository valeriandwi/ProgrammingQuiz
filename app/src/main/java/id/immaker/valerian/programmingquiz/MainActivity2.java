package id.immaker.valerian.programmingquiz;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity2 extends AppCompatActivity {
    int numberQuest;
    double score;
    String name;
    ImageView images;
    TextView questTextView;
    RadioGroup groupOption;
    String answerET;
    CheckBox check1,check2,check3,check4;
    boolean isChecked1,isChecked2,isChecked3,isChecked4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        numberQuest = 0;
        final int[] answer = {0, 3, 0, 0, 0,1};

        Button submitButton = (Button) findViewById(R.id.button_submit);
        groupOption = (RadioGroup) findViewById(R.id.group_option);
        final TextView scoreTextView = (TextView) findViewById(R.id.score_text_view);
        generateQuestion(numberQuest);
        setTitleBar(numberQuest + 1);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberQuest < 6) {
                    checkAnswerOption(answer[numberQuest]);
                    numberQuest += 1;
                }
                setTitleBar(numberQuest + 1);
                if (numberQuest < 6) {
                    generateQuestion(numberQuest);
                }
                if (numberQuest == 6) {
                    groupOption.setVisibility(View.GONE);
                    check1 = (CheckBox)findViewById(R.id.check1);
                    check2 = (CheckBox)findViewById(R.id.check2);
                    check3 = (CheckBox)findViewById(R.id.check3);
                    check4 = (CheckBox)findViewById(R.id.check4);
                    images.setVisibility(View.GONE);
                    check1.setVisibility(View.VISIBLE);
                    check2.setVisibility(View.VISIBLE);
                    check3.setVisibility(View.VISIBLE);
                    check4.setVisibility(View.VISIBLE);
                    questTextView.setText("Choice the list of the java's type data : ");
                    check1.setText("int");
                    check2.setText("String");
                    check3.setText("boolean");
                    check4.setText("public");
                    isChecked1 = check1.isChecked();
                    isChecked2 = check2.isChecked();
                    isChecked3 = check3.isChecked();
                    isChecked4 = check4.isChecked();
                    if((!isChecked1)&&(!isChecked2)&&(!isChecked3)&&(!isChecked4)){

                    }else{
                        if(isChecked1&&isChecked2&&isChecked3){
                            score+=12.5;
                        }
                        numberQuest+=1;
                    }
                }
                if (numberQuest == 7) {
                    setTitleBar(numberQuest + 1);
                    groupOption.setVisibility(View.GONE);
                    check1.setVisibility(View.GONE);
                    check2.setVisibility(View.GONE);
                    check3.setVisibility(View.GONE);
                    check4.setVisibility(View.GONE);
                    images.setVisibility(View.VISIBLE);
                    images.setImageResource(R.drawable.logoudacity);
                    EditText answerText = (EditText) findViewById(R.id.answer_edit_text);
                    answerText.setVisibility(View.VISIBLE);
                    questTextView.setText("This for-profit educational organization founded by Sebastian Thrun, David Stavens, and Mike Sokolsky offering massive open online courses (MOOCs). What's the name of organization ?");
                    answerET = answerText.getText().toString();
                    if (answerET.equals("")) {

                    } else {
                        if (answerET.equals("Udacity")||answerET.equals("udacity")) {
                            score += 12.5;
                        }
                        numberQuest += 1;
                    }
                }
                if (numberQuest == 8) {
                    Intent intent = new Intent(MainActivity2.this, ResultActivity.class);
                    intent.putExtra("EXTRA_SESSION_NAME", name);
                    intent.putExtra("EXTRA_SESSION_SCORE", score);
                    startActivity(intent);
                    finish();
                }
                scoreTextView.setText(String.valueOf(score));
            }
        });

    }

    public void setTitleBar(int numberQuest) {
        setTitle("Question - " + String.valueOf(numberQuest));
    }

    public void generateQuestion(int numberQuest) {
        final String[] option1 = new String[6];
        final String[] option2 = new String[6];
        final String[] option3 = new String[6];
        final String[] option4 = new String[6];
        final String[] quest = new String[6];
        final int[] images_src = new int[6];
        name = getIntent().getStringExtra("EXTRA_SESSION_NAME");

        quest[0] = "He is a Canadian computer scientist, best known as the creator of the Java programming language.Who is He ?";
        images_src[0] = R.drawable.james;
        option1[0] = "James Gosling";
        option2[0] = "Java Gosling";
        option3[0] = "James Gowling";
        option4[0] = "Java Gowling";

        quest[1] = "When is Python language first released and Who is the creator ?";
        images_src[1] = R.drawable.pythonlogo;
        option1[1] = "Guido van Rassum - 1992";
        option2[1] = "Guido van Ressum  - 1991";
        option3[1] = "Guido van Rassum - 1991";
        option4[1] = "Guido van Rossum - 1991";

        quest[2] = "In the mid 1990s, Yukihiro 'Matz' Matsumoto designing a dynamic , reflective, object-oriented, general purpose programming language. What is that ?";
        option1[2] = "Ruby";
        option2[2] = "C++";
        option3[2] = "Java";
        option4[2] = "Falcon";

        quest[3] = "What's the output of this code?";
        images_src[3] = R.drawable.javacode;
        option1[3] = "Hello World!";
        option2[3] = "Hello World !";
        option3[3] = "Hallo World !";
        option4[3] = "hello world!";

        quest[4] = "What's the output of this code if user's number input is 5 ?";
        images_src[4] = R.drawable.cpluscode;
        option1[4] = "5 is odd";
        option2[4] = "5 is Even";
        option3[4] = "Invalid Number";
        option4[4] = "Error messages";

        quest[5] = "What's the name programming language which used for this code ?";
        images_src[5] = R.drawable.htmlcode;
        option1[5] = "PHP";
        option2[5] = "HTML";
        option3[5] = "Joomla";
        option4[5] = "Golang";

        questTextView = (TextView) findViewById(R.id.quest_text_view);
        images = (ImageView) findViewById(R.id.images);
        final TextView firstOption = (TextView) findViewById(R.id.option1);
        final TextView secondOption = (TextView) findViewById(R.id.option2);
        final TextView thirdOption = (TextView) findViewById(R.id.option3);
        final TextView fourthOption = (TextView) findViewById(R.id.option4);

        groupOption.check(R.id.option1);
        images.setImageResource(images_src[numberQuest]);
        questTextView.setText(quest[numberQuest]);
        firstOption.setText(option1[numberQuest]);
        secondOption.setText(option2[numberQuest]);
        thirdOption.setText(option3[numberQuest]);
        fourthOption.setText(option4[numberQuest]);
    }

    public void checkAnswerOption(int answer) {
        int index = groupOption.indexOfChild(findViewById(groupOption.getCheckedRadioButtonId()));
        if (index == answer) {
            score += 12.5;
        }
    }

    private Boolean exit = false;

    @Override
    public void onBackPressed() {
        if (exit) {
            finish(); // finish activity
        } else {
            Toast.makeText(this, "Press Back Again To Exit Application.", Toast.LENGTH_SHORT).show();
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
