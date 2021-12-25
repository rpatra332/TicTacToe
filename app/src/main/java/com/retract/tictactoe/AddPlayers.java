package com.retract.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddPlayers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_players);

        final EditText player1 = findViewById(R.id.playerOneName);
        final EditText player2 = findViewById(R.id.playerTwoName);

        final AppCompatButton begin = findViewById(R.id.begin);

        begin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String P1Name = player1.getText().toString().trim();
                final String P2Name = player2.getText().toString().trim();

                if (P1Name.isEmpty() || P2Name.isEmpty()) {
                    Toast.makeText(AddPlayers.this, "Player Name Too Short", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(AddPlayers.this, MainActivity.class);
                    intent.putExtra("playerOne", P1Name);
                    intent.putExtra("playerTwo", P2Name);
                    startActivity(intent);
                }
            }
        });

    }
}