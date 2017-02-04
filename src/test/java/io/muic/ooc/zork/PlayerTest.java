package io.muic.ooc.zork;

import io.muic.ooc.zork.item.Item;
import io.muic.ooc.zork.item.UseableItem;
import io.muic.ooc.zork.item.WeaponItem;
import io.muic.ooc.zork.Room;
import io.muic.ooc.zork.map.GameMap;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class PlayerTest extends TestCase {
    Room r0 = new Room("Room 0",
            "R0",
            -1,-1,1,-1);
    Room r1 = new Room("Room 1", "R1",
            2,3,4,0);
    Room r2 = new Room("Room 2","R2",
            -1,1,-1,-1);
    Room r3 = new Room("Room 3", "R3",
            1,-1,-1,-1);
    Room r4 = new Room("Room 4","R4",
            -1,-1,-1,1);

    List<Item> r0Items = new ArrayList<Item>() {
        {
            add(new WeaponItem("hammer","Rusty hammer",20));
            add(new UseableItem("water","universal liquid",17));
        }
    };

    List<Item> r1Items = new ArrayList<Item>() {
        {add(new WeaponItem("golf-club","Tiger Woods club",15));
            add(new UseableItem("vodka","universal liquid",-5));
        }
    };

    List<Item> r2Items = new ArrayList<Item>() {
        {add(new WeaponItem("bow","Bow and Arrow",25));
            add(new UseableItem("weed","Smoke to relieve yourself",35));}
    };

    List<Item> r3Items = new ArrayList<Item>() {
        { add(new UseableItem("morphine","Extreme painkiller",23));}
    };

    List<Item> r4Items = new ArrayList<Item>() {
        {add(new WeaponItem("sword","Katana",42));}
    };
    public class TestGen{
        public GameMap createTestMap(){
            r0.addItems(r0Items);
            r1.addItems(r1Items);
            r2.addItems(r2Items);
            r3.addItems(r3Items);
            r4.addItems(r4Items);
            ArrayList<Room> rooms = new ArrayList<Room>(){
                {add(r0);add(r1);add(r2);add(r3);add(r4);}
            };
            GameMap map = new GameMap(rooms);
            return map;
        }
    }
    TestGen testGen = new TestGen();
    @Test
    public void testSetCurrentRoom() throws Exception {
        GameMap map = testGen.createTestMap();
        Player player = new Player("Tester",map.get(0));
        player.setMap(map);
        player.setCurrentRoom("east");
        assertTrue(player.getCurrentRoom()==map.get(1));
        player.setCurrentRoom("north");
        assertTrue(player.getCurrentRoom()==map.get(2));
        player.setCurrentRoom("north");
        assertTrue(player.getCurrentRoom()==map.get(2));

    }
    @Test
    public void testTakeItem() throws Exception {
        GameMap map = testGen.createTestMap();
        Player player = new Player("Tester",map.get(0));
        player.setMap(map);
        player.takeItem("hammer");
        Item hammer = r0Items.get(0);
        Item water = r0Items.get(1);
        assertTrue(player.getWeapons().contains(hammer));
        player.takeItem("water");
        assertTrue(player.getPotions().contains(water));
        player.takeItem("bucket");
        assertTrue(player.getWeapons().size()==1 && player.getWeapons().size()==1);
    }
    @Test
    public void testDropItem() throws Exception {
        GameMap map = testGen.createTestMap();
        Player player = new Player("Tester",map.get(0));
        player.setMap(map);
        player.takeItem("hammer");
        player.takeItem("water");
        player.dropItem("hammer");
        player.dropItem("water");
        assertTrue(player.getWeapons().size()==0);
        assertTrue(player.getPotions().size()==0);
    }
    @Test
    public void testUse() throws Exception {
        GameMap map = testGen.createTestMap();
        Player player = new Player("Tester",map.get(0));
        player.takeItem("water");
        player.use("water");
        assertTrue(player.getHP()==87);
    }
    @Test
    public void testAttack() throws Exception {
        GameMap map = testGen.createTestMap();
        Player player = new Player("Tester",map.get(4));
        player.takeItem("sword");
        Monster monster = new Monster("TestMonster");
        r4.setMonster(monster);
        player.attack("sword");
        assertTrue(monster.getHP()==168);
    }

}