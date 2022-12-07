package com.example.surfaceviewworkpage;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;

public class Game extends AppCompatActivity {


    Thread thread;
    BoardGame boardGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        boardGame = new BoardGame(this);

        thread = new Thread(boardGame);
        thread.start();

        ViewGroup.LayoutParams layoutParams = new ActionBar.LayoutParams
                (ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);


        addContentView(boardGame,layoutParams);


    }

}