package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class InfoCommand extends Command{
    public InfoCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        args.next();
        if (!args.hasNext()){
            player.playerInfo();
            player.roomInfo();
        }else{
            String obj = args.next();
            if (obj.equals("room")){
                player.roomInfo();
            }else if (obj.equals("player")){
                player.playerInfo();
            }else {
                System.out.println("Cannot get information about the input.");
            }
        }
    }
}
