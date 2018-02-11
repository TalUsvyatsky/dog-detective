package bikebus.dogdetective;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import com.google.android.flexbox.FlexboxLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

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
                List<String> tags = findChosenTags(v);
                double lat = getIntent().getDoubleExtra("latitude",0);
                double lng = getIntent().getDoubleExtra("longitude",0);
                int icon = getIntent().getIntExtra("dog_clicked",1);
                try {
                    JSONObject dogInfo = new JSONObject();
                    dogInfo.put("lat",lat);
                    dogInfo.put("lng",lng);
                    dogInfo.put("icon",icon);
                    dogInfo.put("superlike",false);
                    JSONArray jsonTags = new JSONArray();
                    for(String s : tags) {
                        jsonTags.put(s);
                    }
                    dogInfo.put("tags", jsonTags);
                    new AddDogTask(dogInfo).execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                Intent nextScreen = new Intent(AddTags.this, DogMap.class);
                startActivity(nextScreen);
            }
        });
        ImageButton superlike = (ImageButton)findViewById(R.id.superlikeButton);
        superlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> tags = findChosenTags(v);
                double lat = getIntent().getDoubleExtra("latitude",0);
                double lng = getIntent().getDoubleExtra("longitude",0);
                int icon = getIntent().getIntExtra("dog_clicked",1);
                try {
                    JSONObject dogInfo = new JSONObject();
                    dogInfo.put("lat",lat);
                    dogInfo.put("lng",lng);
                    dogInfo.put("icon",icon);
                    dogInfo.put("superlike",true);
                    JSONArray jsonTags = new JSONArray();
                    for(String s : tags) {
                        jsonTags.put(s);
                    }
                    dogInfo.put("tags", jsonTags);
                    new AddDogTask(dogInfo).execute();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

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
        return chosen;

    }

    // Get the dogs in the background
    class AddDogTask extends AsyncTask<Void, Void, Boolean> {

        private final JSONObject o;

        AddDogTask(JSONObject o){
            this.o = o;
        }

        protected Boolean doInBackground(Void... urls) {
            // Do some validation here

            try {
                URL url = new URL("http://dog-detective.appspot.com/dog");
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestProperty("Content-Type","application/json");
                conn.setRequestProperty("Accept","application/json");
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                // Write the dog in
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(o.toString());
                wr.flush();

                return conn.getResponseCode() == HttpURLConnection.HTTP_CREATED;
            } catch (Exception e) {
                Log.e("ERROR", e.getMessage(), e);
                return null;
            }
        }

        protected void onPostExecute(Boolean success) {
            // do nothing for now
        }
    }

}
