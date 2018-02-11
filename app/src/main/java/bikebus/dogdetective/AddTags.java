package bikebus.dogdetective;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.google.android.flexbox.FlexboxLayout;

public class AddTags extends AppCompatActivity {

    private String[] dogWords = {"floof", "pupperino", "doggo", "12/10", "smol", "medium", "big",
            "moon moon", "bork", "11/10", "good", "great", "wow", "heckin' amaze", "13/10", "mlem",
    "blep", "corgo", "puggo", "good boye", "good gurl"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);

        LayoutInflater inflater = (LayoutInflater) getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        FlexboxLayout flexboxLayout = (FlexboxLayout) findViewById(R.id.flexbox);
      //  FlexboxLayout.LayoutParams layoutParams = (FlexboxLayout.LayoutParams) flexboxLayout.getLayoutParams();
      //  layoutParams.setMargins(20, 20, 20, 20);

        for(String s: dogWords) {
            FrameLayout view = (FrameLayout) inflater.inflate(R.layout.button_tag, null);

            ((Button)view.findViewById(R.id.innerButton)).setText(s);
            flexboxLayout.addView(view);
            view.invalidate();


        }
        flexboxLayout.invalidate();

    }

}
