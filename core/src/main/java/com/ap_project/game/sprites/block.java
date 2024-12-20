package com.ap_project.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Represents a block in the game with physical properties and collision boundaries.
 * Code by Abhigyan and Arnav :)
 */
public abstract class block<T extends block<T>> {
    Vector2 position;
    Vector2 velocity;
    public float width, height;
    public Texture block;
    protected World world;
    private Body body;
    private Rectangle bounds;
    private static final float PPM = 1.0f;
    public int hits;

    public block(String texturePath, World world) {
        this.world = world;
        this.block = new Texture(texturePath);
        this.width = this.block.getWidth() * 0.2f;
        this.height = this.block.getHeight() * 0.2f;

        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set((this.position.x - width / 2) / PPM, (this.position.y - height / 2) / PPM);
        bodyDef.linearVelocity.set(0, 0);
        body = world.createBody(bodyDef);

        PolygonShape shape = new PolygonShape();
        shape.setAsBox(width / 4 / PPM, height / 4 / PPM);
        FixtureDef fixtureDef = new FixtureDef();
        float area = 2 * 5f;
        float desiredMass = 0.6f;
        fixtureDef.shape = shape;
        fixtureDef.density = desiredMass / area;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.3f;
        body.createFixture(fixtureDef);
        shape.dispose();

        body.setUserData(this);
        bounds = new Rectangle(this.position.x, this.position.y, this.width, this.height);
    }

    public void setPosition(Vector2 position) {
        this.position.set(position);
        this.getBody().setTransform(position.x, position.y, this.getBody().getAngle());
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity = velocity;
        this.getBody().setLinearVelocity(velocity);
        this.getBody().setAngularVelocity(0);
    }

    public Vector2 getPosition() {
        return this.getBody().getPosition();
    }

    public void dispose() {
        block.dispose();
        world.destroyBody(body);
    }

    public Texture getBlockTexture() {
        return block;
    }

    public void setBlockTexture(Texture block) {
        this.block = block;
    }

    public void decreaseHitPoints() {
        this.hits--;
    }

    public boolean isDestroyed() {
        return this.hits <= 0;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Body getBody() {
        return body;
    }
}
