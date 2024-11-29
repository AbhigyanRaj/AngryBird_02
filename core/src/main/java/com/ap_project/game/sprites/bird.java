package com.ap_project.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

import java.io.Serializable;

/**
 * Represents an abstract bird in the game with physics-based properties and states.
 * Code by Abhigyan and Arnav :)
 */
public abstract class bird<T extends bird<T>> {
    private Vector2 position;
    private Vector2 velocity;
    private Texture birdTexture;
    private TextureRegion textureRegion;
    public float width;
    public float height;
    private Body body;
    protected final World world;
    private boolean isLaunched = false;
    public boolean isDragging = false;
    private static final float PPM = 1.0f;
    public BirdState state;

    public bird(String texturePath, World world) {
        this.world = world;
        this.birdTexture = new Texture(texturePath);
        this.textureRegion = new TextureRegion(birdTexture);
        this.width = this.birdTexture.getWidth() * 0.2f;
        this.height = this.birdTexture.getHeight() * 0.2f;
        this.state = BirdState.WAITING;
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(this.position);
        bodyDef.linearVelocity.set(0, 0);
        bodyDef.angularVelocity = 0;
        bodyDef.angularDamping = 10;
        body = world.createBody(bodyDef);
        CircleShape shape = new CircleShape();
        shape.setRadius(Math.min(width, height) / 2 / PPM);
        float radius = Math.min(width, height) / 2 / PPM;
        float area = (float) (Math.PI * Math.pow(radius, 2));
        float desiredMass = 80f;
        float newDensity = desiredMass / area;
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = newDensity;
        fixtureDef.friction = 0.5f;
        fixtureDef.restitution = 0.5f;
        body.createFixture(fixtureDef);
        shape.dispose();
        body.setUserData(this);
    }

    public Texture getBirdTexture() {
        return birdTexture;
    }

    public Vector2 getPosition() {
        return this.getBody().getPosition();
    }

    public void setVelocity(Vector2 velocity) {
        this.velocity.set(velocity);
        this.getBody().setLinearVelocity(velocity);
        this.getBody().setAngularVelocity(0);
    }

    public void setPosition(Vector2 position) {
        this.position.set(position);
        this.getBody().setTransform(position.x, position.y, this.getBody().getAngle());
    }

    public void jumpToSling(Vector2 slingPerchPosition) {
        if (state == BirdState.WAITING) {
            body.setGravityScale(0);
            state = BirdState.READY;
            setPosition(body.getPosition());
            body.setTransform(slingPerchPosition, 0);
        }
    }

    public boolean isLaunched() {
        return state == BirdState.LAUNCHED;
    }

    public boolean isLanded() {
        return state == BirdState.LANDED;
    }

    public TextureRegion getTextureRegion() {
        return textureRegion;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Body getBody() {
        return body;
    }

    public void dispose() {
        birdTexture.dispose();
        world.destroyBody(body);
    }
}
