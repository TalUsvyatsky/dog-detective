package bikebus.dogdetective;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ToggleButton;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static bikebus.dogdetective.R.drawable.button_tag;

public class AddTags extends AppCompatActivity {

    private String[] dogWords = {"floof", "pupperino", "doggo", "12/10", "smol", "medium", "big",
            "moon moon", "good gurl", "11/10", "good", "great", "wow",  "13/10","heckin' amaze", "mlem",
    "blep", "corgo", "puggo", "good boye","bork", "bamboozled", "woofer"};

    private ToggleButton[] allTagButtons = new ToggleButton[dogWords.length];

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);

        LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox);
      //  FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) flexboxLayout.getLayoutParams();
      //  layoutParams.setMargins(20, 20, 20, 20);
        int i = 0;
        for(String s: dogWords) {
            FrameLayout view = (FrameLayout) inflater.inflate(R.layout.button_tag, null);
            ToggleButton t = ((ToggleButton)view.findViewById(R.id.innerButton));
            t.setText(s);
            t.setTextOff(s);
            t.setTextOn(s);
            flexboxLayout.addView(view);
            view.invalidate();

            allTagButtons[i] = t;
            i++;
        }
        flexboxLayout.invalidate();

        Button submit = (Button)findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddTags.this, DogMap.class);
                startActivity(nextScreen);
            }
        });
    }

    public List<String> findChosenTags(View view) {
        LinkedList<String> chosen = new LinkedList<>();
        for (ToggleButton t: allTagButtons) {
            if(t.isChecked()) {
                chosen.add(t.getText().toString());
            }
        }
        System.out.println(chosen.toString());
        System.out.println(getIntent().getDoubleExtra("latitude",0));
        System.out.println(getIntent().getDoubleExtra("longitude",0));
        return chosen;

    }

}
