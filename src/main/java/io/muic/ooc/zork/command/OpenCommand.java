package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;
import io.muic.ooc.zork.item.ContainerItem;

import java.util.Scanner;

public class OpenCommand extends Command{
    public OpenCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        if(!args.hasNext()){
            System.out.println("To open container use `open {container}`");
            return;
        }
        ContainerItem container =  player.getCurrentRoom().getContainerItem(args.next().toLowerCase());
        if (container != null){
            container.open();
        }
    }
}
