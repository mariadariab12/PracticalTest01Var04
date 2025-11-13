package ro.pub.cs.systems.eim.myapplication;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText student;
    private EditText grupa;
    private EditText text;
    private CheckBox checkBox, checkBox2;
    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {

            String student_text = student.getText().toString();
            String grupa_text = grupa.getText().toString();

            String nume = student_text + " " + grupa_text;

            if (view.getId() == R.id.display) {
                if(checkBox.isChecked() && checkBox2.isChecked()) {
                    if(student_text.isEmpty() || grupa_text.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Nu ati introdus niciun nume", Toast.LENGTH_SHORT).show();
                    } else{
                        text.setText(nume);
                    }
                }
                else if(checkBox.isChecked() && !checkBox2.isChecked()) {
                    if(student_text.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Nu ati introdus niciun nume", Toast.LENGTH_SHORT).show();
                    }
                    text.setText(student_text);
                }
                else if(!checkBox.isChecked() && checkBox2.isChecked()) {
                    if(grupa_text.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Nu ati introdus grupa", Toast.LENGTH_SHORT).show();
                    }
                    text.setText(grupa_text);
                }

            }
            else if (view.getId() == R.id.navigate_to_secondary_activity_button) {
                Intent intent = new Intent(getApplicationContext(), SecondMainActivity.class);

                String student_text_int = student.getText().toString();
                intent.putExtra("student", student_text_int);

                String grupa_text_int = grupa.getText().toString();
                intent.putExtra("grupa", grupa_text_int);
                startActivityForResult(intent, 1);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        student = findViewById(R.id.student);
        grupa = findViewById(R.id.grupa);
        text = findViewById(R.id.text);

        checkBox = findViewById(R.id.checkBox);
        checkBox2 = findViewById(R.id.checkBox2);

        Button display = findViewById(R.id.display);
        display.setOnClickListener(buttonClickListener);

        Button navigateToSecondaryActivityButton = findViewById(R.id.navigate_to_secondary_activity_button);
        navigateToSecondaryActivityButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("student")) {
                student.setText(savedInstanceState.getString("student"));
            } else {
                student.setText(String.valueOf(""));
            }
            if (savedInstanceState.containsKey("grupa")) {
                grupa.setText(savedInstanceState.getString("grupa"));
            } else {
                grupa.setText(String.valueOf(""));
            }
        } else {
            student.setText(String.valueOf(""));
            grupa.setText(String.valueOf(""));
        }

    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("student", student.getText().toString());
        savedInstanceState.putString("grupa", grupa.getText().toString());
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState.containsKey("student")) {
            student.setText(savedInstanceState.getString("student"));
        } else {
            student.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("grupa")) {
            grupa.setText(savedInstanceState.getString("grupa"));
        } else {
            grupa.setText(String.valueOf(0));
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 1) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }
}