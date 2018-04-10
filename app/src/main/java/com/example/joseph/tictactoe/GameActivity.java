package com.example.joseph.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons =new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;
    private int player1Points;
    private int player2Points;

    private TextView displayP1Points;
    private TextView displayP2Points;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        //initialize text views to display players points
        displayP1Points = findViewById(R.id.player1_score);
        displayP2Points = findViewById(R.id.player2_score);


        // assign buttons to buttons array
        for(int i =0; i<3; i++){
            for (int j=0;j<3;j++){
                String buttonID = "button_"+i+j;
                int resID= getResources().getIdentifier(buttonID,"id", getPackageName());
                buttons[i][j]= findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }

        }
        Button resetBtn = findViewById(R.id.resetbutton);
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public void onClick(View view) {
        if(!((Button) view).getText().toString().equals("")){
            return;
        }
        if(player1Turn){
            ((Button) view).setText("X");

        }
        else {
            ((Button) view).setText("0");

        }
        roundCount++;

    }
    private Boolean checkWin(){
        String[][] field =new String[3][3];
        for(int i =0; i<3; i++){
            for (int j=0;j<3;j++){
               field[i][j]=  buttons[i][j].getText().toString();
            }
        }
        //check columns
        for(int i =0; i<3; i++){
            if(field[i][0].equals(field[i][1])&& field[i][0].equals(field[i][2])
                    &&!field[i][0].equals("")){
                return true;
            }

        }
        //check rows
        for(int i =0; i<3; i++){
            if(field[0][i].equals(field[1][i])&& field[0][i].equals(field[2][i])
                    &&!field[0][i].equals("")){
                return true;
            }

        }
        //check Diagonals.
        // top left to bottom right
        if(field[0][0].equals(field[1][1])&& field[0][0].equals(field[2][2])
                &&!field[0][0].equals("")){
            return true;
        }
        // top right to bottom left
        if(field[0][2].equals(field[1][1])&& field[0][2].equals(field[2][0])
                &&!field[0][2].equals("")){
            return true;
        }
        return false;
    }
}
