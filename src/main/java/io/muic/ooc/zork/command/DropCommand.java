package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class DropCommand extends Command {
    public DropCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        String item = args.next();
        player.dropItem(item);
    }
}
