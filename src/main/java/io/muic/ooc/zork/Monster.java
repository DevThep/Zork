package io.muic.ooc.zork;


import java.util.Random;

public class Monster {
    private int hp = 210;
    private String name = "";
    Random random = new Random();

    public Monster(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return hp;
    }

    public void setHP(int HP) {
        this.hp = HP;
    }

    public void attack(Player player){
        int randNum = random.nextInt(18 - 10) + 10;
        int playerHP = player.getHP();
        playerHP -= randNum;
        player.setHP(playerHP);
    }

    public boolean isAlive(){
        if (hp > 0){
            return true;
        }else{
            return false;
        }
    }

}
