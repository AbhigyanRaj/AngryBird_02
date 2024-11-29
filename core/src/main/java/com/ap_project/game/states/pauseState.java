package com.ap_project.game.states;

import com.ap_project.game.Core;
import com.ap_project.game.pauseGameSave;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;

/**
 * Represents the pause menu with options to resume, save, or exit the game.
 * Code by Abhigyan and Arnav :)
 */
public class pauseState extends abstractState implements Screen {
    private final Core game;
    private final Texture background;
    private final Texture crossBtn;
    private final Texture resumeBtn;
    private final Texture saveAndExitBtn;
    private final Texture exitBtn;
    private final pauseGameSave pauseGameSave;
    private final OrthographicCamera camera;

    public pauseState(Core game) {
        super();
        this.game = game;
        background = new Texture("pausebg.png");
        crossBtn = new Texture("crossBtn.png");
        resumeBtn = new Texture("resumeBtn.png");
        saveAndExitBtn = new Texture("saveAndExitBtn.png");
        exitBtn = new Texture("exitBtn.png");
        pauseGameSave = new pauseGameSave();
        camera = new OrthographicCamera();
        camera.setToOrtho(false, Core.WIDTH, Core.HEIGHT);
    }

    @Override
    protected void handleInput() {
        if (Gdx.input.justTouched()) {
            Vector3 touchPos = new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);

            float resumeBtnX = 520, resumeBtnY = 410;
            float saveAndExitBtnX = 520, saveAndExitBtnY = 300;
            float exitBtnX = 520, exitBtnY = 120;
            float crossBtnX = 750, crossBtnY = 555;

            if (isButtonPressed(touchPos, resumeBtnX, resumeBtnY, resumeBtn)) {
                resumeGame();
            } else if (isButtonPressed(touchPos, saveAndExitBtnX, saveAndExitBtnY, saveAndExitBtn)) {
                game.setScreen(new menuState(game));
                dispose();
            } else if (isButtonPressed(touchPos, exitBtnX, exitBtnY, exitBtn)) {
                game.setScreen(new menuState(game));
                dispose();
            } else if (isButtonPressed(touchPos, crossBtnX, crossBtnY, crossBtn)) {
                resumeGame();
            }
        }
    }

    private boolean isButtonPressed(Vector3 touchPos, float btnX, float btnY, Texture btn) {
        return touchPos.x >= btnX && touchPos.x <= btnX + btn.getWidth() * 0.4f &&
            touchPos.y >= btnY && touchPos.y <= btnY + btn.getHeight() * 0.4f;
    }

    private void resumeGame() {
        Gdx.graphics.setContinuousRendering(true);
        playState playScreen = pauseGameSave.loadGameState();
        if (playScreen == null) {
            playScreen = new playState(game, Core.currentLevel);
        }
        game.setScreen(playScreen);
        dispose();
    }

    @Override
    protected void update(float dt) {
        handleInput();
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0.2f, 1);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background, 0, 0, Core.WIDTH, Core.HEIGHT);
        game.batch.draw(resumeBtn, 520, 430, resumeBtn.getWidth() * 0.4f, resumeBtn.getHeight() * 0.4f);
        game.batch.draw(saveAndExitBtn, 520, 315, saveAndExitBtn.getWidth() * 0.3f, saveAndExitBtn.getHeight() * 0.3f);
        game.batch.draw(exitBtn, 520, 200, exitBtn.getWidth() * 0.4f, exitBtn.getHeight() * 0.4f);
        game.batch.draw(crossBtn, 750, 555, crossBtn.getWidth() * 0.25f, crossBtn.getHeight() * 0.25f);
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
        dispose();
    }

    @Override
    public void dispose() {
        if (background != null) background.dispose();
        if (resumeBtn != null) resumeBtn.dispose();
        if (saveAndExitBtn != null) saveAndExitBtn.dispose();
        if (exitBtn != null) exitBtn.dispose();
        if (crossBtn != null) crossBtn.dispose();
    }
}
