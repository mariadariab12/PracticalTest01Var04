package ro.pub.cs.systems.eim.practicaltest01var04;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import ro.pub.cs.systems.eim.practicaltest01var04.Constans;


public class PracticalTest01Var04MainActivity extends AppCompatActivity {

    private EditText leftEditText;
    private EditText rightEditText;

    private final IntentFilter intentFilter = new IntentFilter();

    private final ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {

        private EditText student;
        private EditText grupa;

//        private final IntentFilter intentFilter = new IntentFilter();

        private final ButtonClickListener buttonClickListener = new ButtonClickListener();

        private class ButtonClickListener implements View.OnClickListener {

            @Override
            public void onClick(View view) {
                int leftNumberOfClicks = Integer.parseInt(leftEditText.getText().toString());
                int rightNumberOfClicks = Integer.parseInt(rightEditText.getText().toString());

                if (view.getId() == R.id.display) {
                    leftNumberOfClicks++;
                    leftEditText.setText(String.valueOf(leftNumberOfClicks));
                }
            }
        }
    }
    }