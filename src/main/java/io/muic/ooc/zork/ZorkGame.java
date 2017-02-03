package io.muic.ooc.zork;

import io.muic.ooc.zork.command.*;
import io.muic.ooc.zork.map.GameMap;
import io.muic.ooc.zork.map.GameMapGenerator;

import java.util.HashMap;
import java.util.Scanner;

public class ZorkGame {
    public void start(){
        GameMapGenerator generator = new GameMapGenerator();
        GameMap map = generator.createLvl1();
        GameMap map2 = generator.createLvl2();
        Player p1 = new Player("Dev",map.get(1));
        p1.setMap(map);
        map.setNextMap(map2);
        HashMap<String, Command> commands = new HashMap<String, Command>() {
            {
                // commands are added here using lambdas. It is also possible to dynamically add commands without editing the code.
                put("go", new GoCommand(p1));
                put("take", new TakeCommand(p1));
                put("open", new OpenCommand(p1));
                put("info", new InfoCommand(p1));
                put("attack", new AttackCommand(p1));
                put("drop", new DropCommand(p1));
                put("use", new UseCommand(p1));
                put("read", new ReadCommand(p1));
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
            if (p1.getCurrentRoom().containMonster()){
                Monster m = p1.getCurrentRoom().getMonster();
                if (m.isAlive()){
                    m.attack(p1);
                    System.out.println(m.getName() + " attacked you. HP remaining : " + p1.getHP());
                }else{
                    System.out.println("Mors is DEAD");
                    break;
                }
            }if (p1.getHP() < 0){
                System.out.println("YOU LOST -> GAME OVER!!!");
                break;
            }
            System.out.print("> ");
            line = in.nextLine();
        }
        if (p1.getHP()>= 0){
            generator.createLvl3();
        }
    }
}
