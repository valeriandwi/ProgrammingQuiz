package id.immaker.valerian.programmingquiz;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

public class ExplanationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explanation);
        setTitle("Explanation");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(new ListViewAdapter(this, new String[]
                {"Question 1 : \nJames Arthur Gosling, OC (born May 19, 1955) is a Canadian computer scientist, best known as the creator of the Java programming language.",
                        "Question 2 : \nPython is a widely used high-level programming language for general-purpose programming, created by Guido van Rossum and first released in 1991.",
                        "Question 3 : \nRuby is a dynamic, reflective, object-oriented, general-purpose programming language. It was designed and developed in the mid-1990s by Yukihiro 'Matz' Matsumoto in Japan.",
                        "Question 4 : \nSystem.out.print is a standard output function used in java. where System specifies the package name, out specifies the class name and print is a function in that class. and the answer is Hello World! of course",
                        "Question 5 : \n5 is odd . 'if statement' on this code describe that numbers 5 have a result of else statement",
                        "Question 6 : \nHypertext Markup Language (HTML) is the standard markup language for creating web pages and web applications. With Cascading Style Sheets (CSS) and JavaScript it forms a triad of cornerstone technologies for the World Wide Web.",
                "Question 7 : \nJava have 8 primitive data types : boolean, char , byte , short , int , long , float , double . 3 Non-Primitive Data Type : class , array , and interface",
                "Question 8 : \nUdacity is a for-profit educational organization founded by Sebastian Thrun, David Stavens, and Mike Sokolsky offering massive open online courses (MOOCs)."}));
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
