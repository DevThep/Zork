package io.muic.ooc.zork.command;

import io.muic.ooc.zork.Player;

import java.util.Scanner;

public abstract class Command {
    Player player;
    public Command(Player player){
        this.player = player;
    }
    public abstract void apply(Scanner args);
}
