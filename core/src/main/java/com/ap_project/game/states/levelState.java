package com.ap_project.game.states;

import com.ap_project.game.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

public class levelState extends abstractState implements Screen {
    final private Texture background;
    final Core game;
    final private OrthographicCamera camera;
    final private Texture backButton;
    final private Texture level1Btn;
    final private Texture level2Btn;
    final private Texture level3Btn;
    final private float backWidth;
    final private float backHeight;
    private final Sound hoverSound;

    // Separate hover state variables for each button
    private boolean isHoveringLevel1 = false;
    private boolean isHoveringLevel2 = false;
    private boolean isHoveringLevel3 = false;

    // Explicit X and Y positions for the buttons
    private float level1BtnX = 200;  // Starting X for level 1 button
    private float level1BtnY = 200;  // Same Y for all buttons to align them horizontally

    private float level2BtnX = 500;  // Adjusted X to place level 2 button next to level 1
    private float level2BtnY = 200;  // Same Y

    private float level3BtnX = 800;  // Adjusted X to place level 3 button next to level 2
    private float level3BtnY = 200;  // Same Y

    private float backButtonX = 20;  // Back button remains in the same position
    private float backButtonY = 720 - 20;

    private float levelBtnWidth;
    private float levelBtnHeight;
    private float levelBtnSpacing;

    public levelState(Core game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Core.WIDTH, Core.HEIGHT);

        background = new Texture("levelSelectbg.png");
        backButton = new Texture("backButton.png");
        level1Btn = new Texture("level1btn.png");
        level2Btn = new Texture("level2btn.png");
        level3Btn = new Texture("level3btn.png");

        hoverSound = Gdx.audio.newSound(Gdx.files.internal("jump-01.mp3")); // Load the hover sound effect

        backWidth = backButton.getWidth() * 0.5f;
        backHeight = backButton.getHeight() * 0.5f;

        // Set dynamic size for the level buttons based on the screen width
        levelBtnWidth = Core.WIDTH * 0.22f; // 22% of the screen width for each button
        levelBtnHeight = level1Btn.getHeight() * (levelBtnWidth / level1Btn.getWidth()); // Maintain aspect ratio
        levelBtnSpacing = Core.WIDTH * 0.08f; // 8% of screen width for spacing between buttons
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            // Button 1 (Level 1)
            if (touchPos.x >= level1BtnX && touchPos.x <= level1BtnX + levelBtnWidth &&
                touchPos.y >= level1BtnY && touchPos.y <= level1BtnY + levelBtnHeight) {
                playState playScreen = new playState(game, 1);
                game.setScreen(playScreen);
                dispose();
            }
            // Button 2 (Level 2)
            else if (touchPos.x >= level2BtnX && touchPos.x <= level2BtnX + levelBtnWidth &&
                touchPos.y >= level2BtnY && touchPos.y <= level2BtnY + levelBtnHeight) {
                playState playScreen = new playState(game, 2);
                game.setScreen(playScreen);
                dispose();
            }
            // Button 3 (Level 3)
            else if (touchPos.x >= level3BtnX && touchPos.x <= level3BtnX + levelBtnWidth &&
                touchPos.y >= level3BtnY && touchPos.y <= level3BtnY + levelBtnHeight) {
                playState playScreen = new playState(game, 3);
                game.setScreen(playScreen);
                dispose();
            }

            // Back button
            else if (touchPos.x >= backButtonX && touchPos.x <= backButtonX + backWidth &&
                touchPos.y >= backButtonY - backHeight && touchPos.y <= backButtonY) {
                game.setScreen(new menuState(game));
                dispose();
            }
        }
    }

    @Override
    protected void update(float dt) {
    }

    @Override
    public void create() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float v) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        game.batch.begin();

        // Draw the background
        game.batch.draw(background, 0, 0, Core.WIDTH, Core.HEIGHT);

        // Draw the back button
        game.batch.draw(backButton, backButtonX, backButtonY - backHeight, backWidth, backHeight);

        // Get mouse/touch position
        Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
        camera.unproject(touchPos);

        // Hover effect for level1Btn
        if (touchPos.x >= level1BtnX && touchPos.x <= level1BtnX + levelBtnWidth &&
            touchPos.y >= level1BtnY && touchPos.y <= level1BtnY + levelBtnHeight) {
            if (!isHoveringLevel1) {
                hoverSound.play(); // Play hover sound
                isHoveringLevel1 = true; // Mark as hovering
            }
            // Draw shadow (slightly offset and darker)
            game.batch.setColor(0, 0, 0, 0.5f);
            game.batch.draw(level1Btn, level1BtnX + 3, level1BtnY + 3, levelBtnWidth + 5, levelBtnHeight + 5);
            game.batch.setColor(1, 1, 1, 1);
            // Draw scaled-up button for hover
            game.batch.draw(level1Btn, level1BtnX, level1BtnY, levelBtnWidth + 10, levelBtnHeight + 10);
        } else {
            isHoveringLevel1 = false;
            game.batch.draw(level1Btn, level1BtnX, level1BtnY, levelBtnWidth, levelBtnHeight);
        }

        // Hover effect for level2Btn
        if (touchPos.x >= level2BtnX && touchPos.x <= level2BtnX + levelBtnWidth &&
            touchPos.y >= level2BtnY && touchPos.y <= level2BtnY + levelBtnHeight) {
            if (!isHoveringLevel2) {
                hoverSound.play(); // Play hover sound
                isHoveringLevel2 = true; // Mark as hovering
            }
            // Draw shadow (slightly offset and darker)
            game.batch.setColor(0, 0, 0, 0.5f);
            game.batch.draw(level2Btn, level2BtnX + 3, level2BtnY + 3, levelBtnWidth + 5, levelBtnHeight + 5);
            game.batch.setColor(1, 1, 1, 1);
            // Draw scaled-up button for hover
            game.batch.draw(level2Btn, level2BtnX, level2BtnY, levelBtnWidth + 10, levelBtnHeight + 10);
        } else {
            isHoveringLevel2 = false;
            game.batch.draw(level2Btn, level2BtnX, level2BtnY, levelBtnWidth, levelBtnHeight);
        }

        // Hover effect for level3Btn
        if (touchPos.x >= level3BtnX && touchPos.x <= level3BtnX + levelBtnWidth &&
            touchPos.y >= level3BtnY && touchPos.y <= level3BtnY + levelBtnHeight) {
            if (!isHoveringLevel3) {
                hoverSound.play(); // Play hover sound
                isHoveringLevel3 = true; // Mark as hovering
            }
            // Draw shadow (slightly offset and darker)
            game.batch.setColor(0, 0, 0, 0.5f);
            game.batch.draw(level3Btn, level3BtnX + 3, level3BtnY + 3, levelBtnWidth + 5, levelBtnHeight + 5);
            game.batch.setColor(1, 1, 1, 1);
            // Draw scaled-up button for hover
            game.batch.draw(level3Btn, level3BtnX, level3BtnY, levelBtnWidth + 10, levelBtnHeight + 10);
        } else {
            isHoveringLevel3 = false;
            game.batch.draw(level3Btn, level3BtnX, level3BtnY, levelBtnWidth, levelBtnHeight);
        }

        game.batch.end();

        handleInput();
    }

    @Override
    public void resize(int i, int i1) {
    }

    @Override
    public void hide() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        background.dispose();
        backButton.dispose();
        level1Btn.dispose();
        level2Btn.dispose();
        level3Btn.dispose();
        hoverSound.dispose();
    }
}
