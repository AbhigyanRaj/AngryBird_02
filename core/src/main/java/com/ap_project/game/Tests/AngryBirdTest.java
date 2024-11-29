//package com.ap_project.game.Tests;
//
//import com.ap_project.game.sprites.bird;
//import com.badlogic.gdx.physics.box2d.World;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//// Create a concrete bird implementation for testing
//class TestBird extends bird<TestBird> {
//    public TestBird(String texturePath, World world) {
//        super(texturePath, world);
//    }
//}
//
//public class AngryBirdTest {
//
//    @Test
//    public void checkTestPositionOfBird() {
//        // Initialize a Box2D world with no gravity
//        World world = new World(new com.badlogic.gdx.math.Vector2(0, 0), true);
//
//        // Create a test bird with a sample texture path
//        bird<TestBird> testBird = new TestBird("bird.png", world);
//
//        // Set the bird's position
//        float expectedX = 20f;
//        float expectedY = 30f;
//        testBird.getBody().setTransform(expectedX, expectedY, 0);
//
//        // Verify the bird's position
//        assertEquals(expectedX, testBird.getBody().getPosition().x, 0.01f);
//        assertEquals(expectedY, testBird.getBody().getPosition().y, 0.01f);
//
//        // Clean up resources
//        testBird.dispose();
//        world.dispose();
//    }
//}
