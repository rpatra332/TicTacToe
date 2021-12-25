package com.retract.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<int[]> allPossibilities = new ArrayList<>();

    private int[] ttt = {0,0,0, 0,0,0, 0,0,0};

    private int playerTurn = 1;

    private int totalAccessedBlocks = 1;

    private TextView player1,player2;

    private ImageView[] image = {};

    private LinearLayout profile1,profile2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        player1 = findViewById(R.id.playerOneName);
        player2 = findViewById(R.id.playerTwoName);

        image = new ImageView[]{findViewById(R.id.image1),
            findViewById(R.id.image2),
            findViewById(R.id.image3),
            findViewById(R.id.image4),
            findViewById(R.id.image5),
            findViewById(R.id.image6),
            findViewById(R.id.image7),
            findViewById(R.id.image8),
            findViewById(R.id.image9)};

        profile1 = findViewById(R.id.playerOneProfile);
        profile2 = findViewById(R.id.playerTwoProfile);

        allPossibilities.add(new int[]{0,1,2});
        allPossibilities.add(new int[]{3,4,5});
        allPossibilities.add(new int[]{6,7,8});
        allPossibilities.add(new int[]{0,3,6});
        allPossibilities.add(new int[]{1,4,7});
        allPossibilities.add(new int[]{2,5,8});
        allPossibilities.add(new int[]{2,4,6});
        allPossibilities.add(new int[]{0,4,8});

        player1.setText(getIntent().getStringExtra("playerOne"));
        player2.setText(getIntent().getStringExtra("playerTwo"));

        image[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(0)) {
                    act((ImageView)view,0);
                }
            }
        });

        image[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(1)) {
                    act((ImageView)view,1);
                }
            }
        });

        image[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(2)) {
                    act((ImageView)view,2);
                }
            }
        });

        image[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(3)) {
                    act((ImageView)view,3);
                }
            }
        });

        image[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(4)) {
                    act((ImageView)view,4);
                }
            }
        });

        image[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(5)) {
                    act((ImageView)view,5);
                }
            }
        });

        image[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(6)) {
                    act((ImageView)view,6);
                }
            }
        });

        image[7].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(7)) {
                    act((ImageView)view,7);
                }
            }
        });

        image[8].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isTTTAccessible(8)) {
                    act((ImageView)view,8);
                }
            }
        });

    }

    private boolean isTTTAccessible(int TTTBlockNumber) {
        return ttt[TTTBlockNumber] == 0;
    }

    private void act(ImageView img, int TTTSelectedBlockNumber) {

        ttt[TTTSelectedBlockNumber] = playerTurn;

        if (playerTurn==1) {
            img.setImageResource(R.drawable.cross);

            if(haveWon()) {
                final WinPopUp w = new WinPopUp(MainActivity.this,"Hooray! " + player1.getText().toString().trim() + " won");
                //w.setCancelable(false);
                w.show();

            } else if (totalAccessedBlocks == 9) {
                final WinPopUp w = new WinPopUp(MainActivity.this,"Oh no! It's a draw");
                //w.setCancelable(false);
                w.show();

            } else {
                changeTurn(2);
                totalAccessedBlocks++;

            }
        } else {

            img.setImageResource(R.drawable.circle);

            if(haveWon()) {
                final WinPopUp w = new WinPopUp(MainActivity.this,"Hooray! " + player2.getText().toString() + " won");
                w.setCancelable(false);
                w.show();

            } else if (totalAccessedBlocks == 9) {
                final WinPopUp w = new WinPopUp(MainActivity.this,"Oh no! It's a draw");
                w.setCancelable(false);
                w.show();

            } else {
                changeTurn(1);
                totalAccessedBlocks++;

            }
        }

    }

    private void changeTurn(int currentPlayer) {

        playerTurn = currentPlayer;

        if (playerTurn == 1) {
            profile1.setBackgroundResource(R.drawable.board_back_bordered);
            profile2.setBackgroundResource(R.drawable.board_back);

        } else if (playerTurn == 2) {
            profile1.setBackgroundResource(R.drawable.board_back);
            profile2.setBackgroundResource(R.drawable.board_back_bordered);

        }
    }

    private boolean haveWon() {

        boolean result = false;

        for (int i = 0; i<allPossibilities.size(); i++) {
            final int[] p = allPossibilities.get(i);

            if(ttt[p[0]] == playerTurn && ttt[p[1]] == playerTurn && ttt[p[2]] == playerTurn) {
                result = true;
            }
        }
        return result;
    }

    public void restartMatch() {

        ttt = new int[] {0,0,0 ,0,0,0 ,0,0,0};
        playerTurn = 1;
        totalAccessedBlocks = 1;

        profile1.setBackgroundResource(R.drawable.board_back_bordered);

        for (ImageView img : image) {
            img.setImageResource(R.drawable.transparent);
        }
    }
}