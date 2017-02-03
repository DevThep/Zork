package io.muic.ooc.zork.map;


import io.muic.ooc.zork.Monster;
import io.muic.ooc.zork.Room;
import io.muic.ooc.zork.item.*;
import io.muic.ooc.zork.map.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        Room r4 = new Room("Kitchen","Cooking utensils and stuff",
                5,2,-1,-1);
        Room r5 = new Room("Mysterious room","Stairs to the basement",
                -1,-1,-1,-1);
        r5.setLocked(true);
        r5.setToUnlock(4);
        r5.setExitLevel(true);
        ContainerItem bag = new ContainerItem("bag","An old bag");
        bag.addItem(new QuestItem("kronos-key","Sapphire Key"));
        bag.addItem(new UseableItem("aspirin","Pills",20));
        ContainerItem jar = new ContainerItem("jar","Old Jar");
        jar.addItem(new QuestItem("reaper-key","Rusty Key"));
        ContainerItem box = new ContainerItem("black-box","A black box.");
        box.addItem(new QuestItem("despair-key","A silver key"));
        ContainerItem chest = new ContainerItem("chest","Dusty wooden treasure chest");
        chest.addItem(new QuestItem("greed-key","Gold Key"));
        List<Item> r0Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("hammer","Rusty hammer",20));
                add(new UseableItem("water","universal liquid",17));
                add(bag);
            }
        };

        List<Item> r1Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("golf-club","Tiger Woods club",15));
                add(new UseableItem("vodka","universal liquid",-5));
                add(jar);
            }
        };

        List<Item> r2Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("bow","Bow and Arrow",25));
                add(new UseableItem("weed","Smoke to relieve yourself",35));
                add(box);
            }
        };

        List<Item> r3Items = new ArrayList<Item>() {
            {
                add(new UseableItem("morphine","Extreme painkiller",23));
                add(chest);
            }
        };

        List<Item> r4Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("sword","Katana",42));
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
        r0.setNote("I seek the throne!");
        r1.setNote("I live below");
        r2.setNote("This is your destiny");
        r3.setNote("Hel");
        GameMap map = new GameMap(rooms);
        map.setDescription(">>>>>>>>>>>>>>>>>>>>>\nLEVEL 1\nYou wake up in a dark mansion. Everything inside is a mess, the door behind you to the outside" +
                "\nis barricaded, you don't have a choice but to search for a way out from this damp and creepy place.");
        return map;
    }

    public GameMap createLvl2(){
        Room r0 = new Room("Living Room",
                "Torn Sofas, broken cupboards and family potraits.",
                1,-1,-1,-1);
        Room r1 = new Room("The Entrance",
                "Dark Hallway. The door leading outside is barred. There are 3 doors: to the north, east and west.",
                2,0,-1,-1);
        Room r2 = new Room("Games Room","A big room with a TV and a game console.",
                -1,1,-1,1);

        List<Item> r0Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("hatchet","Rusty hammer",17));
                add(new UseableItem("water","universal liquid",12));
            }
        };

        List<Item> r1Items = new ArrayList<Item>() {
            {
                add(new WeaponItem("flamethrower","Tiger Woods club",25));
                add(new UseableItem("fried-rice","universal liquid",17));
            }
        };

        List<Item> r2Items = new ArrayList<Item>() {
            {
                add(new UseableItem("weed","Smoke to relieve yourself",5));
            }
        };
        r0.addItems(r0Items);
        r1.addItems(r1Items);
        r2.addItems(r2Items);
        ArrayList<Room> rooms = new ArrayList<Room>(){
            {
                add(r0);
                add(r1);
                add(r2);
            }
        };
        Monster monster = new Monster("Mors");
        r0.setNote("Are you up for the challenge?");
        r1.setNote("Darkness");
        r2.setNote("Mors' Lair");
        r2.setMonster(monster);
        GameMap map = new GameMap(rooms);
        map.setDescription(">>>>>>>>>>>>>>>>>>>>>\nLEVEL 2\nStairs leading lower and lower underground." +
                "\nCobwebs, stalagmites and a growl growing louder");
        return map;
    }

    public void createLvl3(){
        boolean quit = false;
        System.out.println(">>>>>>>>>>>>>>>>>>>>>\nLEVEL 3");
        System.out.println("Mors is dead, the room turns dark, the doors disappear");
        Scanner in = new Scanner(System.in);
        while(!quit){
            System.out.println("How do get to the throne of Mors, if Mors is god of the death?");
            String ans = in.nextLine().toLowerCase();
            if (ans.equals("kill")){
                System.out.println("Kill whom.");
            }else if (ans.equals("kill myself")){
                System.out.println("Your destiny has been fufilled as the God of the Underworld !!!");
                System.out.println("<------ THE END ------>");
                System.exit(0);
            }
        }
    }
}
