package com.ap_project.game.states;

import com.ap_project.game.Core;
import com.ap_project.game.sprites.bird;
import com.ap_project.game.sprites.block;
import com.ap_project.game.sprites.pig;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Handles collisions between game objects and manages hit points and destruction.
 * Code by Abhigyan and Arnav :)
 */
public class collisionHandler implements ContactListener {
    private final playState playState;

    collisionHandler(playState playState) {
        this.playState = playState;
    }

    @Override
    public void beginContact(Contact contact) {
        Object userDataA = contact.getFixtureA().getBody().getUserData();
        Object userDataB = contact.getFixtureB().getBody().getUserData();
        handleCollision(userDataA, userDataB);
    }

    private void handleCollision(Object objA, Object objB) {
        if (objA instanceof bird<?> && objB instanceof block<?>) {
            block<?> block = (block<?>) objB;
            block.decreaseHitPoints();
            checkAndRemoveBlock(block);
        } else if (objA instanceof bird<?> && objB instanceof pig<?>) {
            pig<?> pig = (pig<?>) objB;
            pig.decreaseHitPoints();
            checkAndRemovePig(pig);
        } else if (objA instanceof block<?> && objB instanceof block<?>) {
            block<?> block = (block<?>) objB;
            block.decreaseHitPoints();
            checkAndRemoveBlock(block);
        } else if (objA instanceof block<?> && objB instanceof pig<?>) {
            pig<?> pig = (pig<?>) objB;
            pig.decreaseHitPoints();
            checkAndRemovePig(pig);
        }
    }

    private void checkAndRemoveBlock(block<?> block) {
        if (block.isDestroyed()) {
            removeBlock(block);
        }
    }

    private void removeBlock(block<?> block) {
        playState.queueBodyForDestruction(block.getBody(), block);
        playState.getBlocks().remove(block);
    }

    private void checkAndRemovePig(pig<?> pig) {
        if (pig.isDestroyed()) {
            removePig(pig);
        }
    }

    private void removePig(pig<?> pig) {
        playState.queueBodyForDestruction(pig.getBody(), pig);
        playState.getPigs().remove(pig);
    }

    @Override
    public void endContact(Contact contact) {
        // Not used
    }

    @Override
    public void preSolve(Contact contact, Manifold manifold) {
        // Not used
    }

    @Override
    public void postSolve(Contact contact, ContactImpulse contactImpulse) {
        // Not used
    }
}
