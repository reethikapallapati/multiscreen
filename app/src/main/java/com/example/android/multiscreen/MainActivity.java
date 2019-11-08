package com.example.android.multiscreen;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv1= (TextView) findViewById(R.id.textView1);
        TextView tv2= (TextView) findViewById(R.id.textView2);
        TextView tv3= (TextView) findViewById(R.id.textView3);
        TextView tv4= (TextView) findViewById(R.id.textView4);

        tv1.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent = new Intent(MainActivity.this, colorActivity.class);
                                       startActivity(intent);
                                       Toast.makeText(view.getContext(), "Color page", Toast.LENGTH_SHORT).show();
                                   }

                               }

        );
        tv2.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent2 = new Intent(MainActivity.this, familyActivity.class);
                                       startActivity(intent2);
                                       Toast.makeText(view.getContext(), "Family page", Toast.LENGTH_SHORT).show();
                                   }

                               }

        );
        tv3.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent3 = new Intent(MainActivity.this, numberActivity.class);
                                       startActivity(intent3);
                                       Toast.makeText(view.getContext(), "number page", Toast.LENGTH_SHORT).show();
                                   }

                               }

        );
        tv4.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View view) {
                                       Intent intent4 = new Intent(MainActivity.this, phrasesActivity.class);
                                       startActivity(intent4);
                                       Toast.makeText(view.getContext(), "phrase page", Toast.LENGTH_SHORT).show();
                                   }

                               }

        );

        TextView imk=(TextView)findViewById(R.id.imkanny);
                imk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String url = "http://www.facebook.com/kanny027";
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        startActivity(i);
                    }
                });


    }



}
