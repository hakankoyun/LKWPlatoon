package com.example.demo.Client;

import com.example.demo.Client.Socket.SocketClient;
import com.example.demo.Client.Socket.SocketServer;
import com.example.demo.Client.model.LKW;

public class Start {


    private static LKW LKW;
    private static SocketServer server;
    private static SocketServer firstConnectionServer;
    private static SocketClient front;
    private static SocketClient back;
    private static boolean frontExist;

    public static void main(String[] args) {


        try {
            LKW = HTTPConec.register(10);

            if (LKW.getVordereId() != 0)
            {
                front = new SocketClient(LKW.getVordereId(), 2);
                front.sendMessage("Ich habe mich hinten angeschlossen " + LKW.getId());
                front.closeConnection();
                frontExist = true;
            }
            if (LKW.getHintereId() != 0)
            {
                back = new SocketClient(LKW.getHintereId(), 1);
                back.listen();
                back.sendMessage("Ich habe mich vor dir angeschlossen " + LKW.getId());
            }
            server = new SocketServer(LKW.getId(), 1);
            firstConnectionServer = new SocketServer(LKW.getId(), 2);
            HTTPConec.connect(LKW.getId());
            System.out.println(LKW);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newGeschwindigkeit(int geschwindigkeit){

        LKW.setGeschwindigkeit(geschwindigkeit);
        if (back != null){
            back.sendMessage("Aktuelle Geschwindigkeit: "+ LKW.getGeschwindigkeit());
        }
    }

    public static void NeueVordereVerbindung(int id){
        frontExist = true;
        server.sendMessage("Aktuelle Geschwindigkeit: " + LKW.getGeschwindigkeit());
    }

    public static void NeueHintereVerbindung(int id){
        LKW.setHintereId(id);
        back = new SocketClient(LKW.getHintereId(), 1);
        back.listen();
        back.sendMessage("Aktuelle Geschwindigkeit: "+ LKW.getGeschwindigkeit());
    }

}
