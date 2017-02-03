package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class UseCommand extends Command{
    public UseCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        if (!args.hasNext()){
            System.out.println("To use item `use {potion}`");
        }else{
            String item = args.next();
            player.use(item);
        }
    }
}
