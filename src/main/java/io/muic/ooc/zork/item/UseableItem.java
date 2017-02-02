package io.muic.ooc.zork.item;


public class UseableItem extends Item {

    private int heal;

    public UseableItem(String name,String description, int heal) {
        super(name,description);
        this.heal = heal;
    }
}
