package io.muic.ooc.zork.map;


import io.muic.ooc.zork.Room;
import io.muic.ooc.zork.item.*;
import io.muic.ooc.zork.map.GameMap;

import java.util.ArrayList;
import java.util.List;

public class GameMapGenerator {

    public GameMap createLvl1(){
        Room r0 = new Room("Living Room",
                "Torn Sofas, broken cupboards and family potraits.",
                -1,-1,1,-1);
        Room r1 = new Room("The Entrance",
                "Dark Hallway. The door leading outside is barred. There are 3 doors: to the north, east and west.",
                3,-1,2,0);
        Room r2 = new Room("Games Room","A big room with a TV and a game console.",
                4,-1,-1,1);
        Room r3 = new Room("Storage Room",
                "Dusty Room, dimly lit. Some medicine on the shelf",
                -1,1,-1,-1);
        Room r4 = new Room("Kitchen","cooking utensils and stuff",
                5,2,-1,-1);
        Room r5 = new Room("Mysterious room","Stairs to the basement",
                -1,-1,-1,-1);
        r5.setLocked(true);
        r5.setToUnlock(4);
        r5.setExitLevel(true);
        ContainerItem bag = new ContainerItem("bag","An old bag");
        bag.addItem(new QuestItem("key-of-kronos","Sapphire Key"));
        bag.addItem(new UseableItem("aspirin","Pills",20));
        ContainerItem jar = new ContainerItem("jar","Old Jar");
        jar.addItem(new QuestItem("key-of-reaper","Rusty Key"));
        ContainerItem box = new ContainerItem("black-box","A black box.");
        box.addItem(new QuestItem("key-of-despair","A silver key"));
        ContainerItem chest = new ContainerItem("treasure-chest","Dusty wooden treasure chest");
        chest.addItem(new QuestItem("key-of-greed","Gold Key"));
        List<Item> r0Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("hammer","Rusty hammer",40));
                add(new UseableItem("water","universal liquid",50));
                add(bag);
            }
        };

        List<Item> r1Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("golf-club","Tiger Woods club",40));
                add(new UseableItem("vodka","universal liquid",-5));
                add(jar);
            }
        };

        List<Item> r2Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("bow","Bow and Arrow",40));
                add(new UseableItem("satchel","Knapsack",50));
                add(box);
            }
        };

        List<Item> r3Items = new ArrayList<Item>() {
            {
                add(new UseableItem("Morphine","Extreme painkiller",50));
                add(chest);
            }
        };

        List<Item> r4Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("Sword","Katana",40));
            }
        };
        r0.addItems(r0Items);
        r1.addItems(r1Items);
        r2.addItems(r2Items);
        r3.addItems(r3Items);
        r4.addItems(r4Items);
        ArrayList<Room> rooms = new ArrayList<Room>(){
            {
                add(r0);
                add(r1);
                add(r2);
                add(r3);
                add(r4);
                add(r5);
            }
        };
        GameMap map = new GameMap(rooms);
        return map;
    }
}
