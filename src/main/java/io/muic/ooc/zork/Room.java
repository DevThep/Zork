package io.muic.ooc.zork;

import io.muic.ooc.zork.item.ContainerItem;
import io.muic.ooc.zork.item.Item;

import java.util.*;

public class Room {
    private String name = "";
    private String description = "";
    private Set<Item> items = new HashSet<>();
    private String note = "";
    private Monster monster = null;
    public int north;
    public int south;
    public int east;
    public int west;
    public boolean locked = false;
    public int toUnlock;
    private boolean exitLevel = false;
    private ArrayList<String> dir_avail = new ArrayList<>();
    public Room(String name, String description, int north, int south, int east, int west){
        this.name = name;
        this.description= description;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        if (this.north != -1) dir_avail.add("NORTH");
        if (this.south != -1) dir_avail.add("SOUTH");
        if (this.east != -1) dir_avail.add("EAST");
        if (this.west != -1) dir_avail.add("WEST");
    }

    public void setMonster(Monster monster) {
        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }

    public boolean containMonster() {
        if (this.monster != null){ return true; }
        return false;
    }

    public String getDescription() { return description; }

    public void getNote() {
        System.out.println("Reading Note....");
        System.out.println(note);
    }

    public void setNote(String note) {
        this.note = note;
    }

    public boolean isExitLevel() {
        return exitLevel;
    }

    public void setExitLevel(boolean exitLevel) {
        this.exitLevel = exitLevel;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
    }

    public void setToUnlock(int toUnlock) {
        this.toUnlock = toUnlock;
    }

    public boolean isLocked(){
        return locked;
    }

    public int getToUnlock() {
        return toUnlock;
    }

    public String getName() {
        return name;
    }

    public Item getItem(String itemName){
        for (Item i : items){
            if (i.getName().equals(itemName)){
                return i;
            }
        }
        return null;
    }

    public ContainerItem getContainerItem(String itemName){
        for (Item i : items){
            if (i.getName().equals(itemName) && (i instanceof ContainerItem)){
                return (ContainerItem) i;
            }
        }
        System.out.println(itemName + " does not exist");
        return null;
    }

    public boolean addItem(Item item) {
        this.items.add(item);
        return true;
    }

    public void addItems(List<Item> item) {
        for (Item i : item){
            this.items.add(i);
        }
    }

    public void removeItems(String name){
        for(Item i : items){
            if (i.getName().equals(name)) {
                items.remove(i);
                break;
            }
        }
    }

    public void getInfo() {
        System.out.println(this.description);
        System.out.println("Room items : " + getItemNames(items));
        getDirections();
    }

    private String getItemNames(Set<? extends Item> set){
        ArrayList<String> temp = new ArrayList<>();
        for(Item i: set){
            temp.add(i.getName());
        }
        return temp.toString();
    }

    public void getDirections(){
        System.out.println("Available directions : " + dir_avail.toString());
    }
}
