package io.muic.ooc.zork.item;

public class Item {
    private String name = "";
    private String description = "";

    public Item(String name,String description){
        this.name = name;
        this.description = description;
    }
    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public void getInfo(){
        System.out.println("Not overrided!");
    };
}
