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

            if (LKW.getFrontId() != 0)
            {
                front = new SocketClient(LKW.getFrontId(), 2);
                front.sendMessage("i bin hinter dir" + LKW.getId()); // "Aktuelle Geschwindigkeit: "); //+ truck.getSpeed());
                front.closeConnection();
                frontExist = true;
            }
            if (LKW.getBackId() != 0)
            {
                back = new SocketClient(LKW.getBackId(), 1);
                back.listen();
                back.sendMessage("i bin vor dir" + LKW.getId()); //"Aktuelle Geschwindigkeit: "); //+truck.getSpeed());
            }
            server = new SocketServer(LKW.getId(), 1);
            firstConnectionServer = new SocketServer(LKW.getId(), 2);
            HTTPConec.connect(LKW.getId());
            System.out.println(LKW);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void newSpeed(int speed){

        LKW.setSpeed(speed);
        if (back != null){
            back.sendMessage("Aktuelle Geschwindigkeit: "+ LKW.getSpeed());
        }
    }

    public static void nFC(int id){
        frontExist = true;
        server.sendMessage("Aktuelle Geschwindigkeit: " + LKW.getSpeed());
    }

    public static void nBC(int id){
        LKW.setBackId(id);
        back = new SocketClient(LKW.getBackId(), 1);
        back.listen();
        back.sendMessage("Aktuelle Geschwindigkeit: "+ LKW.getSpeed());
    }

}
