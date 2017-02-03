package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class AttackCommand extends Command{
    public AttackCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        if (!args.hasNext()){
            System.out.println("To attack, monster must be in the room \n Use `attack {weapon}`");
            return;
        }
        String weapon = args.next();
        player.attack(weapon);
    }
}
