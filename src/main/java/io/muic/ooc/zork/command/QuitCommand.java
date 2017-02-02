package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Player;

import java.util.Scanner;

/**
 * Created by DevSingh on 2/2/17.
 */
public class QuitCommand extends Command{
    public QuitCommand(Player player){
        super(player);
    }
    public void apply(Scanner args){
        System.exit(0);
    }
}
