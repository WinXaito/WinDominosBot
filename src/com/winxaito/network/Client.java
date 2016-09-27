package com.winxaito.network;

import com.neovisionaries.ws.client.*;
import com.winxaito.Main;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by: WinXaito (Kevin Vuilleumier)
 */
public class Client{
    private WebSocket webSocket;
    private ArrayList<CommandListener> listeners = new ArrayList<>();

    public Client() throws Exception{
        webSocket = connect();
    }

    public void stop(){
        webSocket.disconnect();
    }

    public void sendMessage(String message){
        webSocket.sendText(message);
    }

    public void addListener(CommandListener listener){
        listeners.add(listener);
    }

    public void removeListener(CommandListener listener){
        if(listeners.contains(listener))
            listeners.remove(listener);
    }

    public void receiveMessage(String command){
        for(CommandListener listener : listeners)
            listener.receiveCommand(command);
    }


    //---Private Method---//
    private WebSocket connect() throws IOException, WebSocketException
    {
        WebSocketFactory factory = new WebSocketFactory();
        factory.setConnectionTimeout(5000);
        WebSocket ws = factory.createSocket(Main.getServer() + ":" + Main.getPort());

        ws.addListener(new WebSocketAdapter() {
            public void onTextMessage(WebSocket websocket, String command) {
                receiveMessage(command);
            }
        });

        ws.addExtension(WebSocketExtension.PERMESSAGE_DEFLATE);
        ws.connect();

        return ws;
    }
}
