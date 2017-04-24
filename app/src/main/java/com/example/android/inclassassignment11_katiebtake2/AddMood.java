package com.example.android.inclassassignment11_katiebtake2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.UUID;

public class AddMood extends AppCompatActivity {

    private EditText moodNameInput;
    private EditText moodTenInput;
    private CheckBox moodDiscussedInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        moodNameInput = (EditText) findViewById(R.id.whats_your_mood);
        moodTenInput = (EditText) findViewById(R.id.type_out_of_ten);
        moodDiscussedInput = (CheckBox) findViewById(R.id.discussed_my_feelings);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_or_delete_data, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_save:
                Toast.makeText(this, "Mood saved", Toast.LENGTH_SHORT).show();

                String nameInput = moodNameInput.getText().toString();
                String idInput = UUID.randomUUID().toString();
                int tenInput = Integer.parseInt(moodTenInput.getText().toString());
                boolean discussedInput = moodDiscussedInput.isChecked();

                Mood m = new Mood(idInput, nameInput, tenInput, discussedInput);

                Intent data = new Intent();
                data.putExtra(Keys.MOOD, m);
                setResult(RESULT_OK, data);
                finish();

                return true;

            case R.id.menu_delete:
                Toast.makeText(this, "Mood deleted", Toast.LENGTH_SHORT).show();

                moodNameInput.setText("");
                moodTenInput.setText("");
                moodDiscussedInput.setChecked(false);

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
