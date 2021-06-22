package com.example.demo.Client.model;

import com.example.demo.Client.Socket.SocketClient;

public class LKW {

    int id;
    int fId;
    int bId;
    int spd;
    boolean leader;

    public LKW(int id, int frontId, int backId, int speed, boolean leader) {
        this.id = id;
        this.fId = frontId;
        this.bId = backId;
        this.spd = speed;
        this.leader = leader;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFrontId() {
        return fId;
    }

    public void setFrontId(int frontId) {
        this.fId = frontId;
    }

    public int getBackId() {
        return bId;
    }

    public void setBackId(int backId) {
        this.bId = backId;
    }

    public int getSpeed() {
        return spd;
    }

    public void setSpeed(int speed) {
        this.spd = speed;
    }

    public void setLeader(boolean leader) {
        this.leader = leader;
    }

    public Boolean getLeader(){return leader;}

    @Override
    public String toString()
    {
        return "id:" + id + ", front:" + fId + ", back:" + bId + ", speed:" + spd;
    }
}
