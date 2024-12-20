package com.ap_project.game.states;

import com.ap_project.game.sprites.*;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Defines the levels of the game by setting up blocks, pigs, birds, and their positions.
 * Code by Abhigyan and Arnav :)
 */
public class level {

    public static void getLevel3(World world, ArrayList<block<?>> blocks, ArrayList<pig<?>> pigs, ArrayList<bird<?>> birds, List<Vector2> blockPositions, List<Vector2> pigPositions, List<Vector2> birdsPositions) {
        Array<block<?>> blocksLevel3 = new Array<>();
        blocksLevel3.add(new woodenBlock("wb123.jpeg", world));
        blocksLevel3.add(new woodenBlock("wb61.jpg", world));
        blocksLevel3.add(new woodenBlock("wb61.jpg", world));
        blocksLevel3.add(new woodenBlock("wb123.jpeg", world));
        blocksLevel3.add(new woodenBlock("wb1r.png", world));
        blocksLevel3.add(new woodenBlock("wb1r.png", world));
        blocksLevel3.add(new woodenBlock("wb10.png", world));
        blocksLevel3.add(new woodenBlock("wb10.png", world));
        blocksLevel3.add(new woodenBlock("wb10.png", world));
        List<Vector2> blockPositionsLevel3 = new ArrayList<>(Arrays.asList(
            new Vector2(850, 100),
            new Vector2(900 + 25, 100),
            new Vector2(900 + 25, 100 + blocksLevel3.get(2).height - 20),
            new Vector2(950 + 28 + 25, 100),
            new Vector2(850, 100 + blocksLevel3.get(0).height * 0.5f + 20),
            new Vector2(850 + blocksLevel3.get(4).width / 2, 100 + blocksLevel3.get(0).height * 0.5f + 20),
            new Vector2(848, 100 + 20 + blocksLevel3.get(0).height * 0.5f + 26),
            new Vector2(925, 100 + 20 + blocksLevel3.get(0).height * 0.5f + 26),
            new Vector2(1000, 100 + 20 + blocksLevel3.get(0).height * 0.5f + 26)
        ));
        Array<pig<?>> pigsLevel3 = new Array<>();
        pigsLevel3.add(new pig1("pigKing.png", world));
        pigsLevel3.add(new pig2("pig1b.png", world));
        pigsLevel3.add(new pig2("pig3a.png", world));
        List<Vector2> pigsPositionsLevel3 = new ArrayList<>(Arrays.asList(
            new Vector2(960, 100 + 80 + 180),
            new Vector2(880, 100),
            new Vector2(1040, 100)
        ));
        Array<bird<?>> birdsLevel3 = new Array<>();
        birdsLevel3.add(new redBird("redBird.png", world));
        birdsLevel3.add(new chuck("chuck.png", world));
        birdsLevel3.add(new bomb("bomb.png", world));
        List<Vector2> birdsPositionsLevel3 = new ArrayList<>(Arrays.asList(
            new Vector2(170, 105),
            new Vector2(130, 105),
            new Vector2(90, 105)
        ));
        for (block<?> b : blocksLevel3) {
            blocks.add(b);
        }
        for (pig<?> p : pigsLevel3) {
            pigs.add(p);
        }
        for (bird<?> b : birdsLevel3) {
            birds.add(b);
        }
        blockPositions.addAll(blockPositionsLevel3);
        pigPositions.addAll(pigsPositionsLevel3);
        birdsPositions.addAll(birdsPositionsLevel3);
    }

    public static void getLevel1(World world, ArrayList<block<?>> blocks, ArrayList<pig<?>> pigs, ArrayList<bird<?>> birds, List<Vector2> blockPositions, List<Vector2> pigPositions, List<Vector2> birdsPositions) {
        Array<block<?>> blocksLevel1 = new Array<>();
        blocksLevel1.add(new woodenBlock("wb1.png", world));
        blocksLevel1.add(new woodenBlock("wb6.png", world));
        blocksLevel1.add(new woodenBlock("wb6.png", world));
        blocksLevel1.add(new woodenBlock("wb1.png", world));
        blocksLevel1.add(new woodenBlock("wb1r.png", world));
        blocksLevel1.add(new woodenBlock("wb1r.png", world));
        blocksLevel1.add(new woodenBlock("wb10.png", world));
        blocksLevel1.add(new woodenBlock("wb10.png", world));
        blocksLevel1.add(new woodenBlock("wb10.png", world));
        List<Vector2> blockPositionsLevel1 = new ArrayList<>(Arrays.asList(
            new Vector2(850, 100),
            new Vector2(900 + 25, 100),
            new Vector2(900 + 25, 100 + blocksLevel1.get(2).height - 20),
            new Vector2(950 + 28 + 25, 100),
            new Vector2(850, 100 + blocksLevel1.get(0).height * 0.5f + 20),
            new Vector2(850 + blocksLevel1.get(4).width / 2, 100 + blocksLevel1.get(0).height * 0.5f + 20),
            new Vector2(848, 100 + 20 + blocksLevel1.get(0).height * 0.5f + 26),
            new Vector2(925, 100 + 20 + blocksLevel1.get(0).height * 0.5f + 26),
            new Vector2(1000, 100 + 20 + blocksLevel1.get(0).height * 0.5f + 26)
        ));
        Array<pig<?>> pigsLevel1 = new Array<>();
        pigsLevel1.add(new pig1("pig1a.png", world));
        pigsLevel1.add(new pig2("pig2a.png", world));
        pigsLevel1.add(new pig2("pig2a.png", world));
        List<Vector2> pigsPositionsLevel1 = new ArrayList<>(Arrays.asList(
            new Vector2(928 - 50, 100),
            new Vector2(925, 100 + 20 + blocksLevel1.get(0).height * 0.5f + 35 + blocksLevel1.get(8).height * 0.5f),
            new Vector2(1012 - 50, 100)
        ));
        Array<bird<?>> birdsLevel1 = new Array<>();
        birdsLevel1.add(new redBird("redBird.png", world));
        birdsLevel1.add(new chuck("chuck.png", world));
        birdsLevel1.add(new bomb("bomb.png", world));
        List<Vector2> birdsPositionsLevel1 = new ArrayList<>(Arrays.asList(
            new Vector2(170, 105),
            new Vector2(130, 105),
            new Vector2(90, 105)
        ));
        for (block<?> b : blocksLevel1) {
            blocks.add(b);
        }
        for (pig<?> p : pigsLevel1) {
            pigs.add(p);
        }
        for (bird<?> b : birdsLevel1) {
            birds.add(b);
        }
        blockPositions.addAll(blockPositionsLevel1);
        pigPositions.addAll(pigsPositionsLevel1);
        birdsPositions.addAll(birdsPositionsLevel1);
    }

    public static void getLevel2(World world, ArrayList<block<?>> blocks, ArrayList<pig<?>> pigs, ArrayList<bird<?>> birds, List<Vector2> blockPositions, List<Vector2> pigPositions, List<Vector2> birdsPositions) {
        Array<block<?>> blocksLevel2 = new Array<>();
        blocksLevel2.add(new woodenBlock("wb12.jpg", world));
        blocksLevel2.add(new woodenBlock("wb61.jpg", world));
        blocksLevel2.add(new woodenBlock("wb61.jpg", world));
        blocksLevel2.add(new woodenBlock("wb12.jpg", world));
        blocksLevel2.add(new woodenBlock("wb1r.png", world));
        blocksLevel2.add(new woodenBlock("wb1r.png", world));
        blocksLevel2.add(new woodenBlock("wb10.png", world));
        blocksLevel2.add(new woodenBlock("wb10.png", world));
        blocksLevel2.add(new woodenBlock("wb10.png", world));
        List<Vector2> blockPositionsLevel2 = new ArrayList<>(Arrays.asList(
            new Vector2(850, 100),
            new Vector2(900 + 25, 100),
            new Vector2(900 + 25, 100 + blocksLevel2.get(2).height - 20),
            new Vector2(950 + 28 + 25, 100),
            new Vector2(850, 100 + blocksLevel2.get(0).height * 0.5f + 20),
            new Vector2(850 + blocksLevel2.get(4).width / 2, 100 + blocksLevel2.get(0).height * 0.5f + 20),
            new Vector2(848, 100 + 20 + blocksLevel2.get(0).height * 0.5f + 26),
            new Vector2(925, 100 + 20 + blocksLevel2.get(0).height * 0.5f + 26),
            new Vector2(1000, 100 + 20 + blocksLevel2.get(0).height * 0.5f + 26)
        ));
        Array<pig<?>> pigsLevel2 = new Array<>();
        pigsLevel2.add(new pig1("pig1a.png", world));
        pigsLevel2.add(new pig2("pig2a.png", world));
        pigsLevel2.add(new pig2("pig2a.png", world));
        List<Vector2> pigsPositionsLevel2 = new ArrayList<>(Arrays.asList(
            new Vector2(960, 100 + 80 + 180),
            new Vector2(880, 100),
            new Vector2(1040, 100)
        ));
        Array<bird<?>> birdsLevel2 = new Array<>();
        birdsLevel2.add(new redBird("redBird.png", world));
        birdsLevel2.add(new chuck("chuck.png", world));
        birdsLevel2.add(new bomb("bomb.png", world));
        List<Vector2> birdsPositionsLevel2 = new ArrayList<>(Arrays.asList(
            new Vector2(170, 105),
            new Vector2(130, 105),
            new Vector2(90, 105)
        ));
        for (block<?> b : blocksLevel2) {
            blocks.add(b);
        }
        for (pig<?> p : pigsLevel2) {
            pigs.add(p);
        }
        for (bird<?> b : birdsLevel2) {
            birds.add(b);
        }
        blockPositions.addAll(blockPositionsLevel2);
        pigPositions.addAll(pigsPositionsLevel2);
        birdsPositions.addAll(birdsPositionsLevel2);
    }
}
