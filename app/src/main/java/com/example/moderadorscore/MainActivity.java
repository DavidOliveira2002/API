package com.example.moderadorscore;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ScoreModerator moderator;
    private TextView scoreDisplay;
    private EditText playerNameInput, scoreInput;
    private Button addButton, removeButton, approveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moderator = new ScoreModerator();

        scoreDisplay = findViewById(R.id.scoreDisplay);
        playerNameInput = findViewById(R.id.playerNameInput);
        scoreInput = findViewById(R.id.scoreInput);
        addButton = findViewById(R.id.addButton);
        removeButton = findViewById(R.id.removeButton);
        approveButton = findViewById(R.id.approveButton);

        addButton.setOnClickListener(v -> {
            String name = playerNameInput.getText().toString();
            int score = Integer.parseInt(scoreInput.getText().toString());
            moderator.addPendingScore(name, score);
            updateDisplay();
        });

        removeButton.setOnClickListener(v -> {
            String name = playerNameInput.getText().toString();
            moderator.removePendingScore(name);
            updateDisplay();
        });

        approveButton.setOnClickListener(v -> {
            moderator.approveAllScores();
            updateDisplay();
        });
    }

    private void updateDisplay() {
        scoreDisplay.setText(moderator.getFinalScoresAsString());
    }
}
