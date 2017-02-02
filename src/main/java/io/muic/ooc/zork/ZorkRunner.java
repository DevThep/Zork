package io.muic.ooc.zork;

import io.muic.ooc.zork.command.*;
import io.muic.ooc.zork.map.GameMap;
import io.muic.ooc.zork.map.GameMapGenerator;

import java.util.HashMap;
import java.util.Scanner;

/**
 * This is the main class.
 *
 * @author gigadot
 */
public class ZorkRunner {
    public static void main(String[] args) {
        GameMap map = new GameMapGenerator().createLvl1();
        Player p1 = new Player("Dev",map.get(0));
        p1.setMap(map);
        HashMap<String, Command> commands = new HashMap<String, Command>() {
            {
                // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
                put("go", new GoCommand(p1));
                put("take", new TakeCommand(p1));
                put("open", new OpenCommand(p1));
                put("info", new InfoCommand(p1));
                put("drop", new DropCommand(p1));
                put("quit", new QuitCommand(p1));
            }
        };
        boolean quit = false;
        Scanner in = new Scanner(System.in);
        System.out.print("> ");
        String line = in.nextLine();
        while (!quit){
            String cmd = line.trim().split(" ")[0].toLowerCase();
            try{
                commands.get(cmd).apply(new Scanner(line));
            }catch (NullPointerException e){
                System.out.println("Invalid input");
            }
            System.out.print("> ");
            line = in.nextLine();
        }
    }
}
