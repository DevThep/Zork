package io.muic.ooc.zork.item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContainerItem extends Item {
    public Set<Item> items = new HashSet<>();
    public boolean isOpen = false;
    public ContainerItem(String name, String description){
        super(name,description);
    }

    public void open(){
        if (this.isOpen){
            System.out.println("Already opened");
        }else{
            System.out.println("Opened " +this.getName());
            this.isOpen = true;
        }
    }

    public boolean contains(String itemName){
        for (Item i : items){
            if (i.getName().equals(itemName)){
                return true;
            }
        }
        return false;
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
        if (!isOpen){
            System.out.println(this.getName() + "is closed. Open it!");
        }else{
            for(Item i : items){
                if (i.getName()==name) {
                    items.remove(i);
                    break;
                };
            }
        }
    }

    @Override
    public void getInfo() {
        System.out.println(this.getName() +" items : " + getItemNames(items));
    }

    public Item getItem(String itemName){
        for (Item i : items){
            if (i.getName().equals(itemName)){
                return i;
            }
        }
        return null;
    }

    private String getItemNames(Set<? extends Item> set){
        ArrayList<String> temp = new ArrayList<>();
        for(Item i: set){
            temp.add(i.getName());
        }
        return temp.toString();
    }
}
