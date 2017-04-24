package com.example.android.inclassassignment11_katiebtake2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerview;
    private MoodAdapter moodAdapter;
    private DatabaseReference moodReference = FirebaseDatabase.getInstance().getReference("moods");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerview = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        moodAdapter = new MoodAdapter(moodReference);
        recyclerview.setAdapter(moodAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_mood, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                Intent intent = new Intent(this, AddMood.class);
                startActivityForResult(intent, 1);

                Toast.makeText(this, "Adding Item", Toast.LENGTH_SHORT).show();

//                String id = UUID.randomUUID().toString();
//                Random random = new Random();
//                moodReference.child(id).setValue(new Mood(id, "Happy", random.nextInt(100), random.nextBoolean()));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Mood m = (Mood) data.getSerializableExtra(Keys.MOOD);
            moodReference.child(m.id).setValue(m);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        moodAdapter.cleanup();
    }
}
