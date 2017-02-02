package io.muic.ooc.zork.command;


import io.muic.ooc.zork.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class GoCommand extends Command{
    ArrayList<String> directions = new ArrayList<String>(){{
        add("north");
        add("south");
        add("east");
        add("west");
    }};
    public GoCommand(Player player){
        super(player);
    }
    public void apply(Scanner args){
        args.next();
        if (!args.hasNext()){
            System.out.println("Specify direction : north, south, east, west");
            return;
        }
        String direction = args.next();
        if (directions.contains(direction)){
            player.setCurrentRoom(direction);
        }else{
            System.out.println("Direction commands: north, south, east, west");
        }
    }
}
