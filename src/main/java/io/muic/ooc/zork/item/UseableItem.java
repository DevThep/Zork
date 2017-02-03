package io.muic.ooc.zork.item;


import io.muic.ooc.zork.Player;

public class UseableItem extends Item {

    private int heal;

    public UseableItem(String name,String description, int heal) {
        super(name,description);
        this.heal = heal;
    }

    public boolean heal(Player player){
        int hp = player.getHP();
        System.out.println("HP " + hp);
        if (hp < 100){
            int newHP = hp + this.heal;
            if (newHP > 100){ newHP = 100; }
            player.setHP(newHP);
            System.out.println("Your health is now " + player.getHP());
            return true;
        }else{
            System.out.println("Full Health, cannot use item");
            return false;
        }
    }
}
