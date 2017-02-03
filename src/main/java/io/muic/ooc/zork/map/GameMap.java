package io.muic.ooc.zork.map;


import io.muic.ooc.zork.Room;

import java.util.ArrayList;

public class GameMap {
    private GameMap nextMap;
    private String description = "";

    public void setNextMap(GameMap nextMap) {
        this.nextMap = nextMap;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GameMap getNextMap() {
        return nextMap;
    }
    private ArrayList<Room> rooms = new ArrayList<>();

    public GameMap(ArrayList<Room> rooms){
        this.rooms = rooms;
    }

    protected void addRoom(Room room){
        rooms.add(room);
    }

    public Room get(int pos){
        if (pos==-1){
            return null;
        }else{
            return rooms.get(pos);
        }
    }
}
