package io.muic.ooc.zork.item;

public class WeaponItem extends Item{

    private int power;

    public WeaponItem(String name,String description, int power) {
        super(name,description);
        this.power = power;
    }

    public int getPower() {
        return power;
    }


}
