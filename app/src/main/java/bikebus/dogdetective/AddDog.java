package bikebus.dogdetective;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AddDog extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dog);



        ImageButton dog1 = (ImageButton) findViewById(R.id.WhiteDogLightBlueBack);
        ImageButton dog2 = (ImageButton) findViewById(R.id.TanDogGreenBack);
        ImageButton dog3 = (ImageButton) findViewById(R.id.BrownDogYellowBack);
        ImageButton dog4 = (ImageButton) findViewById(R.id.GrayDogDarkBlueBack);
        ImageButton dog5 = (ImageButton) findViewById(R.id.BrownDogPurpleBack);
        ImageButton dog6 = (ImageButton) findViewById(R.id.GrayDogOrangeBack);

        dog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 4);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
        dog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 2);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
        dog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 1);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
        dog4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 5);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
        dog5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 6);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
        dog6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nextScreen = new Intent(AddDog.this, AddTags.class);
                nextScreen.putExtra("dog_clicked", 3);
                nextScreen.putExtra("latitude", getIntent().getDoubleExtra("latitude", 0));
                nextScreen.putExtra("longitude", getIntent().getDoubleExtra("longitude", 0));
                startActivity(nextScreen);
            }
        });
    }
}
