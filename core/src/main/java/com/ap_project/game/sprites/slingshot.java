package com.ap_project.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;

import java.io.Serializable;

public class slingshot  {
    public static Texture slingBack;
    public static Texture slingFront;
    public final float x;
    public final float y;

    public void dispose() {
        slingBack.dispose();
        slingFront.dispose();
    }

    public static Texture getslingFrontTexture(){
        return slingFront;
    }
    public static Texture getslingBackTexture(){
        return slingBack;
    }

    public slingshot(float x, float y) {
        slingBack = new Texture("sling-01.png"); // Load the back texture
        slingFront = new Texture("sling-02.png"); // Load the front texture
        this.x = x;
        this.y = y;
    }



    // Dispose of the textures when done

}

