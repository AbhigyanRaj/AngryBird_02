package com.ap_project.game;

import com.ap_project.game.states.*;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * The main entry point for the game, managing global resources and screen transitions.
 * Code by Abhigyan and Arnav :)
 */
public class Core extends Game {
    public static final int WIDTH = 1280; // Screen width
    public static final int HEIGHT = 720; // Screen height
    public static final String TITLE = "Angry Bird-02"; // Game title
    public static int currentLevel; // Tracks the current game level

    public SpriteBatch batch; // For rendering sprites
    public BitmapFont font; // For rendering text
    public static resultState2 resultScreen2;

    @Override
    public void create() {
        batch = new SpriteBatch();
        font = new BitmapFont();
        currentLevel = 1;

        // Start with the opening state
        this.setScreen(new openingState(this));
    }

    @Override
    public void render() {
        super.render();
    }

    @Override
    public void dispose() {
        batch.dispose();
        font.dispose();
    }
}
