package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Player;

import java.util.Scanner;

public class ReadCommand extends Command {
    public ReadCommand(Player player){
        super(player);
    }
    @Override
    public void apply(Scanner args){
        player.read();
    }
}
