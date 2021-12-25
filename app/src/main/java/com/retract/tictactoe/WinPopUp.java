package com.retract.tictactoe;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class WinPopUp extends Dialog {

    private final String message ;
    private final MainActivity mainActivity;

    public WinPopUp(@NonNull Context context, String message) {
        super(context);
        this.mainActivity = (MainActivity) context;
        this.message = message;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.win_pop_up);

        final TextView  winMessage = findViewById(R.id.popUpMessage);
        final Button btn = findViewById(R.id.restartButton);

        winMessage.setText(message);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainActivity.restartMatch();
                dismiss();
            }
        });

    }
}
