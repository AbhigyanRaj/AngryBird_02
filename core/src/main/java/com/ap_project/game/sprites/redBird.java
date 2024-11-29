package com.ap_project.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.physics.box2d.World;

import java.io.Serializable;

public class redBird extends bird  {

    public void printp(){
        System.out.println("Im batman ;)");

    }

    public redBird(String texturePath, World world) {
        super(texturePath,world);
        this.state=BirdState.WAITING;
    }


}
