package io.muic.ooc.zork;


import io.muic.ooc.zork.item.*;
import io.muic.ooc.zork.map.GameMap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player {
    private int hp = 70;
    private String name = "";
    private Set<WeaponItem> weapons = new HashSet<>();
    private Set<UseableItem> potions = new HashSet<>();
    private Set<QuestItem> questItems = new HashSet<>();
    private Room currentRoom;
    private GameMap map;

    //Constructor
    public Player(String name,Room currentRoom) {
        this.name = name;
        this.currentRoom = currentRoom;
    }

    public Set<UseableItem> getPotions() {
        return potions;
    }

    public Set<WeaponItem> getWeapons() {
        return weapons;
    }

    public void read(){
        currentRoom.getNote();
    }

    public void setMap(GameMap map) {
        this.map = map;
        System.out.println(this.map.getDescription());
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int HP) {
        this.hp = HP;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String direction) {
        int roomLoc = -2;
        if (direction.toLowerCase().equals("north")){
            roomLoc = currentRoom.north;
        }else if (direction.toLowerCase().equals("south")){
            roomLoc = currentRoom.south;
        }else if (direction.toLowerCase().equals("east")){
            roomLoc = currentRoom.east;
        }else if (direction.toLowerCase().equals("west")){
            roomLoc = currentRoom.west;
        }if (roomLoc == -1){
            System.out.println("Wall, no way in this direction.");
        }else{
            Room room = map.get(roomLoc);
            if (room.isLocked() && this.questItems.size()==room.getToUnlock()){
                System.out.println("Gathered enough keys to open the room.");
                room.setLocked(false);
                this.currentRoom = map.get(roomLoc);
                System.out.println("Entered " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
            }else if (room.isLocked()){
                System.out.println("Room locked, get enough keys to open it.");
            }else{
                this.currentRoom = room;
                System.out.println("Entered " + currentRoom.getName());
                System.out.println(currentRoom.getDescription());
            }
            if (this.currentRoom.isExitLevel()){
                this.setMap(map.getNextMap());
                this.currentRoom = map.get(0);
            }
        }
    }

    public void playerInfo(){
        System.out.println("INFO/STATS");
        System.out.println("HP "+ getHP());
        System.out.println("Weapons " + getItemNames(weapons));
        System.out.println("Potions " + getItemNames(potions));
        System.out.println("Quest Items " + getItemNames(questItems));
        System.out.println("Room : " + currentRoom.getName());
        System.out.println("------------");
    }

    public void takeItem(String item){
        Item itemLoc = currentRoom.getItem(item);
        if (itemLoc instanceof WeaponItem){
            if (weapons.size()==3){
                System.out.println("Inventory full, drop some items to make some space");
            }else if (containsItem(item,weapons)){
                System.out.println("Item already in Inventory");
            } else {
                System.out.println(String.format("Picked up %s",item));
                weapons.add((WeaponItem) itemLoc);
                currentRoom.removeItems(item);
            }
        }else if(itemLoc instanceof UseableItem) {
            if (potions.size() == 2) {
                System.out.println("Potion bag full, drop some items to make some space");
            } else if (containsItem(item,potions)) {
                System.out.println("Item already in Potion bag");
            } else {
                System.out.println(String.format("Picked up %s", item));
                potions.add((UseableItem) itemLoc);
                currentRoom.removeItems(item);
            }
        }else if (itemLoc instanceof ContainerItem){
            System.out.println("Can only take items from containers AND");
            System.out.println("Container must be open before taking items.");
        }
        else{
            System.out.println("No such item in the room");
        }

    }

    public void dropItem(String item){
        if (containsItem(item,weapons)){
            Item temp = removeItem(item,weapons);
            currentRoom.addItem(temp);
            System.out.println(String.format("Dropped %s",item));
        } else if(containsItem(item,potions)){
            Item temp = removeItem(item,potions);
            currentRoom.addItem(temp);
            System.out.println(String.format("Dropped %s",item));
        } else{
            System.out.println("Cannot drop something you don't have!");
        }
    }

    private String getItemNames(Set<? extends Item> set){
        ArrayList<String> temp = new ArrayList<>();
        for(Item i: set){
            temp.add(i.getName());
        }
        return temp.toString();
    }

    private boolean containsItem(String item,Set<? extends Item> set){
        for (Item i: set){
            if (i.getName()==item){
                return true;
            }
        }return false;
    }

    private Item removeItem(String item,Set<? extends Item> set){
        for (Item i: set){
            if (i.getName()==item){
                set.remove(i);
                return i;
            }
        }return null;
    }

    public void roomInfo(){
        currentRoom.getInfo();
    }



    public void takeItemContainer(String containerName,String item){
        ContainerItem temp = currentRoom.getContainerItem(containerName);
        if (temp == null) System.out.println("No such item in the room.");
        else if (!temp.isOpen){
            System.out.println("Must open " + containerName + " first!");
        }else{
            Item it = temp.getItem(item);
            if (it instanceof QuestItem){
                questItems.add((QuestItem) it);
                System.out.println("Quest item picked : " + item);
                temp.removeItems(item);
            }else {
                if (it instanceof WeaponItem){
                    if (weapons.size() == 3) {
                        System.out.println("Weapons bag full, drop some items to make some space");
                    }else{
                        weapons.add((WeaponItem) it);
                        temp.items.remove(it);
                    }
                }else if (it instanceof UseableItem){
                    if (potions.size() == 2) {
                        System.out.println("Potion bag full, drop some items to make some space");
                    }else{
                        potions.add((UseableItem) it);
                        temp.items.remove(it);
                    }
                }
            }
        }
    }

    public void use(String item){
        for(UseableItem i: potions){
            if (i.getName().equals(item)){
                boolean toUse = i.heal(this);
                if (toUse) potions.remove(i);
                return;
            }
        }System.out.println("The item specified does not exist in inventory!");
    }

    public void attack(String weapon){
        WeaponItem w = null;
        for (WeaponItem i: weapons){
            if (i.getName().equals(weapon)){
                w = i;
                break;
            }
        }
        if (weapon == null){
            System.out.println("You don't have this weapon.");
        }
        else if (!currentRoom.containMonster()){
            System.out.println("There is no monster in this room!");
        }else{
            if (currentRoom.getMonster().isAlive()){
                int curHP = currentRoom.getMonster().getHP();
                currentRoom.getMonster().setHP(curHP - w.getPower());
            }else{
                System.out.println("Monster is DEAD!");
            }

        }
    }
}
