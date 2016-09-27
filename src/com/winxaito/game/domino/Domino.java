package com.winxaito.game.domino;

import com.winxaito.Main;
import com.winxaito.game.Game;
import com.winxaito.network.Client;
import com.winxaito.network.CommandListener;

/**
 * Created by: WinXaito (Kevin Vuilleumier)
 */
public class Domino implements Game, CommandListener{
    private int round = 0;
    private Client client;

    public Domino(Client client){
        this.client = client;
    }

    @Override
    public void onStart(){
        client.sendMessage(Main.getUsername());
    }

    @Override
    public void onSkip(){
        client.sendMessage("skip");
    }

    @Override
    public void onPlay(){

    }

    @Override
    public void onEnd(){

    }

    @Override
    public void onGet(){
        client.sendMessage("get");
    }

    @Override
    public void onGetAll(){
        client.sendMessage("get-all");
    }

    @Override
    public void receiveCommand(String command){
        String[] commandSplitted = command.split(" ");

        if(commandSplitted.length == 1){
            switch(command){
                case "play":
                    onPlay();
                    break;
                case "end":
                    onEnd();
                    break;
            }
        }else if(commandSplitted.length > 1){
            switch(commandSplitted[0]){
                case "get":

                    break;
                case "get-all":

                    break;
                case "error":

                    break;
            }
        }
    }
}
