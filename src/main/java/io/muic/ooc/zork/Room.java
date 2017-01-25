package io.muic.ooc.zork;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private final static int MAX_ITEMS = 3;
    private List<Item> items = new ArrayList<>();
    private Monster monster = null;
    private Map<String,Room> exitMap = new HashMap<String, Room>();

    public boolean addItem(Item item) {
        if (this.items.size() < MAX_ITEMS){
            this.items.add(item);
            return true;
        }else {
            return false;
        }
    }

    public String getInfo() {
        // print items
        // print monster
        // print exit
        // print
        return "TODO";
    }

    public void setMonster(Monster monster){
        if (this.monster != null){
            this.monster = monster;
        }
    }

    public void setExit(String direction, Room exitingRoom){
        switch (direction){
            case "north" :
            case "east" :
            case "west" :
            case "south" :
                exitMap.put(direction,exitingRoom);
            default: ;
        }

    }
}
