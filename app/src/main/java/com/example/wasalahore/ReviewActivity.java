package com.example.wasalahore;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.wasalahore.Model.CustomAdapter;
import com.example.wasalahore.Model.CustomItem;
import com.example.wasalahore.Model.ReviewDataClass;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;

public class ReviewActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    Spinner spinner;
    int width = 150;
    ArrayList<CustomItem> customList;

    DatabaseReference databaseReference;
    String Company;
    String Model;
    String lisence;
    RatingBar body_shape, tyres, shawks, sound_system, room_space, seating_comfort, ac, steering, brakes, gear, wind_screen, head_lights, backlights, doors, horn, battery, design, generator,
            compressor, cooling_system, plugs, seatbelt, gear_box, fuel_average, pick;
    Button submit_review;
    float avg_rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        spinner = findViewById(R.id.select_rating);
        customList = getCustomList();


        Intent intent = getIntent();
        lisence = intent.getStringExtra("lisenceno");
        Model = intent.getStringExtra("modelname");
        Company = intent.getStringExtra("companyname");

        CustomAdapter adapter = new CustomAdapter(this, customList);
        if (spinner != null) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(this);
        }




        databaseReference = FirebaseDatabase.getInstance().getReference("review");

        body_shape = findViewById(R.id.body_shape);
        tyres = findViewById(R.id.tyres);
        shawks = findViewById(R.id.shawks);
        sound_system = findViewById(R.id.sound_system);
        room_space = findViewById(R.id.room_space);
        seating_comfort = findViewById(R.id.seating_comfort);
        ac = findViewById(R.id.ac);
        steering = findViewById(R.id.steering);
        brakes = findViewById(R.id.brakes);
        gear = findViewById(R.id.gear);
        wind_screen = findViewById(R.id.wind_screen);
        head_lights = findViewById(R.id.head_lights);
        backlights = findViewById(R.id.backlights);
        doors = findViewById(R.id.doors);
        horn = findViewById(R.id.horn);
        battery = findViewById(R.id.battery);
        design = findViewById(R.id.deisgn);
        generator = findViewById(R.id.generator);
        compressor = findViewById(R.id.compressor);
        cooling_system = findViewById(R.id.cooling_system);
        plugs = findViewById(R.id.plugs);
        seatbelt = findViewById(R.id.seatbelt);
        gear_box = findViewById(R.id.gear_box);
        fuel_average = findViewById(R.id.fuel_average);
        pick = findViewById(R.id.pick);
        submit_review = findViewById(R.id.submit_review);

        submit_review.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (body_shape.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Body Shape's rating please.", Toast.LENGTH_SHORT).show();
                else if (tyres.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Tyres's rating please.", Toast.LENGTH_SHORT).show();
                else if (shawks.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Shawks's rating please.", Toast.LENGTH_SHORT).show();
                else if (sound_system.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Sound Systen's rating please.", Toast.LENGTH_SHORT).show();
                else if (room_space.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Room Space's rating please.", Toast.LENGTH_SHORT).show();
                else if (seating_comfort.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Seating Comfort's rating please.", Toast.LENGTH_SHORT).show();
                else if (ac.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select AC's rating please.", Toast.LENGTH_SHORT).show();
                else if (steering.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Steering's rating please.", Toast.LENGTH_SHORT).show();
                else if (brakes.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Brakes's rating please.", Toast.LENGTH_SHORT).show();
                else if (gear.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Gear's rating please.", Toast.LENGTH_SHORT).show();
                else if (wind_screen.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Wind Screen's rating please.", Toast.LENGTH_SHORT).show();
                else if (head_lights.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Head Light's rating please.", Toast.LENGTH_SHORT).show();
                else if (backlights.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Back Light's rating please.", Toast.LENGTH_SHORT).show();
                else if (doors.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Doors's rating please.", Toast.LENGTH_SHORT).show();
                else if (horn.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Horn's rating please.", Toast.LENGTH_SHORT).show();
                else if (battery.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Battery's rating please.", Toast.LENGTH_SHORT).show();
                else if (design.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Design's rating please.", Toast.LENGTH_SHORT).show();
                else if (generator.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Generator's rating please.", Toast.LENGTH_SHORT).show();
                else if (compressor.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Compressor's rating please.", Toast.LENGTH_SHORT).show();
                else if (cooling_system.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Cooling System's rating please.", Toast.LENGTH_SHORT).show();
                else if (plugs.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Plugs's rating please.", Toast.LENGTH_SHORT).show();
                else if (seatbelt.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Seatbelt's rating please.", Toast.LENGTH_SHORT).show();
                else if (gear_box.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select GearBox's rating please.", Toast.LENGTH_SHORT).show();
                else if (fuel_average.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Fuel Average's rating please.", Toast.LENGTH_SHORT).show();
                else if (pick.getRating() == 0.0)
                    Toast.makeText(ReviewActivity.this, "Select Pick's rating please.", Toast.LENGTH_SHORT).show();

                else {
                    avg_rating = body_shape.getRating() + tyres.getRating() + shawks.getRating() + sound_system.getRating() + room_space.getRating() + seating_comfort.getRating() + ac.getRating() + steering.getRating() + brakes.getRating() + gear.getRating() + wind_screen.getRating() + head_lights.getRating() + backlights.getRating() + doors.getRating() + horn.getRating() + battery.getRating() + design.getRating() + generator.getRating() + compressor.getRating() + cooling_system.getRating() + plugs.getRating() + seatbelt.getRating() + gear_box.getRating() + fuel_average.getRating() + pick.getRating();
                    avg_rating = avg_rating / 25;
                    ReviewDataClass reviewDataClass = new ReviewDataClass(Company, Model, lisence, Float.toString(body_shape.getRating()), Float.toString(tyres.getRating()), Float.toString(shawks.getRating()), Float.toString(sound_system.getRating()), Float.toString(room_space.getRating()), Float.toString(seating_comfort.getRating()), Float.toString(ac.getRating()), Float.toString(steering.getRating()), Float.toString(brakes.getRating()), Float.toString(gear.getRating()), Float.toString(wind_screen.getRating()), Float.toString(head_lights.getRating()), Float.toString(backlights.getRating()), Float.toString(doors.getRating()), Float.toString(horn.getRating()), Float.toString(battery.getRating()), Float.toString(design.getRating()), Float.toString(generator.getRating()), Float.toString(compressor.getRating()), Float.toString(cooling_system.getRating()), Float.toString(plugs.getRating()), Float.toString(seatbelt.getRating()), Float.toString(gear_box.getRating()), Float.toString(fuel_average.getRating()), Float.toString(pick.getRating()), Float.toString(avg_rating));
                    if (databaseReference.child(Company).child(Model).child(lisence).setValue(reviewDataClass).isSuccessful()) {
                        Toast.makeText(ReviewActivity.this, "Review added succesfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(ReviewActivity.this, "Review added succesfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }


    private ArrayList<CustomItem> getCustomList() {
        customList = new ArrayList<>();
        customList.add(new CustomItem(5,"Five Stars", R.drawable.ic_grade_black_24dp));
        customList.add(new CustomItem(4,"Four Stars", R.drawable.ic_grade_black_24dp));
        customList.add(new CustomItem(3,"Three Stars", R.drawable.ic_grade_black_24dp));
        customList.add(new CustomItem(2,"Two Stars", R.drawable.ic_grade_black_24dp));
        customList.add(new CustomItem(1,"One Star", R.drawable.ic_grade_black_24dp));
        return customList;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        try {
            LinearLayout linearLayout = findViewById(R.id.customSpinnerItemLayout);
            width = linearLayout.getWidth();
        } catch (Exception e) {
        }
        spinner.setDropDownWidth(width);
        CustomItem item = (CustomItem) adapterView.getSelectedItem();
        Toast.makeText(this, item.getSpinnerItemName(), Toast.LENGTH_SHORT).show();
        String rating=Integer.toString(item.getId());
        ReviewDataClass reviewDataClass = new ReviewDataClass(Company, Model, lisence,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating,rating);
        if (databaseReference.child(Company).child(Model).child(lisence).setValue(reviewDataClass).isSuccessful()) {
            Toast.makeText(ReviewActivity.this, "Review added succesfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ReviewActivity.this, "Review added succesfully", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
