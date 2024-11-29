package com.ap_project.game.states;

import com.ap_project.game.Core;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Displays the result screen after the player wins, with options to go home, play again, or proceed to the next level.
 * Code by Abhigyan and Arnav :)
 */
public class resultState extends abstractState implements Screen {
    private final Core game;
    private final OrthographicCamera camera;
    private final Texture background;
    private final Texture stars;
    private final Texture homeBtn;
    private final Texture playAgain;
    private final Texture nextLevelBtn;
    private int level;

    public resultState(Core game, int level) {
        super();
        this.game = game;
        this.level = level;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Core.WIDTH, Core.HEIGHT);
        background = new Texture("winbg.png");
        stars = new Texture("stars.png");
        homeBtn = new Texture("homeBtn.png");
        playAgain = new Texture("playAgain.png");
        nextLevelBtn = new Texture("nextLevelBtn.png");
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            if (isButtonPressed(touchPos, 450, 310, homeBtn, 0.2f)) {
                game.setScreen(new menuState(game));
                dispose();
            }

            if (isButtonPressed(touchPos, 750, 300, playAgain, 0.3f)) {
                goToNextLevel();
            }

            if (isButtonPressed(touchPos, 600, 300, nextLevelBtn, 0.3f)) {
                goToNextLevel();
            }
        }
    }

    private boolean isButtonPressed(Vector3 touchPos, float x, float y, Texture button, float scale) {
        return touchPos.x >= x && touchPos.x <= x + button.getWidth() * scale &&
            touchPos.y >= y && touchPos.y <= y + button.getHeight() * scale;
    }

    private void goToNextLevel() {
        if (Core.currentLevel == level) {
            Core.currentLevel++;
        }
        level++;
        game.setScreen(new playState(game, level));
        dispose();
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);

        game.batch.begin();
        game.batch.draw(background, 0, 0, Core.WIDTH, Core.HEIGHT);
        game.batch.draw(stars, 300, 300, stars.getWidth() * 0.5f, stars.getHeight() * 0.5f);
        game.batch.draw(homeBtn, 450, 310, homeBtn.getWidth() * 0.2f, homeBtn.getHeight() * 0.2f);
        game.batch.draw(nextLevelBtn, 600, 300, nextLevelBtn.getWidth() * 0.3f, nextLevelBtn.getHeight() * 0.3f);
        game.batch.draw(playAgain, 750, 300, playAgain.getWidth() * 0.3f, playAgain.getHeight() * 0.3f);
        game.batch.end();

        update(delta);
    }

    @Override
    public void show() {
        // Not used
    }

    @Override
    public void create() {
        // Not used
    }

    @Override
    public void resize(int width, int height) {
        // Not used
    }

    @Override
    public void pause() {
        // Not used
    }

    @Override
    public void resume() {
        // Not used
    }

    @Override
    public void hide() {
        // Not used
    }

    @Override
    public void dispose() {
        background.dispose();
        stars.dispose();
        homeBtn.dispose();
        playAgain.dispose();
        nextLevelBtn.dispose();
    }
}
