package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class TakeCommand extends Command{
    public TakeCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        if (!args.hasNext()){
            System.out.println("Specify items in the room \n `info room` to see items in the current room.");
            return;
        }
        String item = args.next().toLowerCase();
        if (!args.hasNext()){
            player.takeItem(item);
            return;
        }
        String from = args.next().toLowerCase();
        if (from.equals("from")){
            if (!args.hasNext()){
                System.out.println("To take item in a container use `take {item} from {container}`");
            }else {
                String container = args.next().toLowerCase();
                player.takeItemContainer(container,item);
            }
        }else{
            System.out.println("To take item in a container use `take {item} from {container}`");
        }

    }
}
