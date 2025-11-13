package ro.pub.cs.systems.eim.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Objects;

import org.w3c.dom.Text;

public class SecondMainActivity extends AppCompatActivity {

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.ok) {
                setResult(RESULT_OK, null);
            } else if (id == R.id.cancel) {
                setResult(RESULT_CANCELED, null);
            }

            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_main);

        TextView student_text2 = findViewById(R.id.student2);
        TextView grupa_text2 = findViewById(R.id.grupa2);

        Intent intent = getIntent();
        if (intent != null && Objects.requireNonNull(intent.getExtras()).containsKey("student")) {
            String student = intent.getStringExtra("student");
            student_text2.setText(student);
        }

        if (intent != null && Objects.requireNonNull(intent.getExtras()).containsKey("grupa")) {
            String grupa = intent.getStringExtra("grupa");
            grupa_text2.setText(grupa);
        }

        Button okButton = findViewById(R.id.ok);
        okButton.setOnClickListener(buttonClickListener);
        Button cancelButton = findViewById(R.id.cancel);
        cancelButton.setOnClickListener(buttonClickListener);
    }
}