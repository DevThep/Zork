package io.muic.ooc.zork;


public class Player {
    private int hp = 100;
    private String name = "";
    private final static int MAX_ITEMS = 3;
    private String[] items = new String[3];
    private Room currentRoom;

    public Player(String name,Room curRoom) {
        this.name = name;
        this.currentRoom = curRoom;
    }

    public int getHP() {
        return hp;
    }
    public void setHP(int HP) {
        this.hp = hp;
    }
    public Room getCurrentRoom() {
        return currentRoom;
    }
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

}
