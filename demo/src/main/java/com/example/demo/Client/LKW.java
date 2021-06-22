package com.example.demo.Client;

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


    public LKW(int id) {
        this.id = id;
    }

    public LKW() {

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

    public void setGeschwindigkeit(int Geschwindigkeit) {
        this.geschwindigkeit = geschwindigkeit;
    }

    public void setFührer(boolean führer) {
        this.führer = führer;
    }
    public Boolean getFührer() { return führer;}

}
