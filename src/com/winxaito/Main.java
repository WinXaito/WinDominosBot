package com.winxaito;

/**
 * Created by: WinXaito (Kevin Vuilleumier)
 */
public class Main{
    private static String username = "WinXaito";
    private static String server = "ws://localhost";
    private static int port = 8888;

    public static void main(String[] args) throws Exception{
        if(args.length > 0){
            try{
                int tmpPort = Integer.parseInt(args[0]);
                if(tmpPort < 1 || tmpPort > 65536){
                    System.err.println("The port must be between 1 and 65536, the number gived is " + tmpPort + "\nPort used: " + port);
                }else{
                    port = tmpPort;
                }
            }catch(NumberFormatException e){
                System.err.println("Error, the port arg is not an integer");
            }
        }
        if(args.length == 2){
            server = args[1];
        }
    }

    public static String getUsername(){
        return username;
    }

    public static String getServer(){
        return server;
    }

    public static int getPort(){
        return port;
    }
}
