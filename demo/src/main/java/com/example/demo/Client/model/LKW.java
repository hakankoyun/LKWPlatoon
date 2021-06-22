package com.example.demo.Client.model;

import com.example.demo.Client.Socket.SocketClient;

public class LKW {

    int id;
    int vordereId;
    int hintereId;
    int geschwindigkeit;
    boolean führer;

    public LKW(int id, int vordereId, int hintereId, int geschwindigkeit, boolean führer) {
        this.id = id;
        this.vordereId = vordereId;
        this.hintereId = hintereId;
        this.geschwindigkeit = geschwindigkeit;
        this.führer = führer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVordereId() {
        return vordereId;
    }

    public void setVordereId(int vordereId) {
        this.vordereId = vordereId;
    }

    public int getHintereId() {
        return hintereId;
    }

    public void setHintereId(int hintereId) {
        this.hintereId = hintereId;
    }

    public int getGeschwindigkeit() {
        return geschwindigkeit;
    }

    public void setGeschwindigkeit(int geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void setFührer(boolean führer) { this.führer = führer; }

    public Boolean getFührer(){return führer();}

    @Override
    public String toString()
    {
        return "id:" + id + ", vorne:" + vordereId + ", hintere:" + hintereId + ", geschwindigkeit:" + geschwindigkeit;
    }
}
