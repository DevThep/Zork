package io.muic.ooc.zork.map;


import io.muic.ooc.zork.Room;

import java.util.ArrayList;

public class GameMap {

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
