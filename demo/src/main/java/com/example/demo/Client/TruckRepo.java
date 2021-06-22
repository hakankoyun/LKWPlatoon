package com.example.demo.Client;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LKW {

    List<LKW> lkwList = new ArrayList<>();
    int id = 0;

    public LKW(int i, int i1, int i2, boolean b) {
    }


    // LKW adding
    public LKW addLKW(int position){
        id++;
        LKW lkw;

        if(position > lkwList.size()) {
            position = lkwList.size();
        }

        if (lkwList.isEmpty())
        {
            //Erster überhaupt im Platoon
            lkw = new LKW(0, 0, 80, true);
            lkwList.add(0, lkw);
        }
        else if(position == lkwList.size())
        {
            //Letzter im Platoon
            lkw = new LKW(lkwList.get(position - 1).getId(),0,80,false);
            lkwList.add(position, lkw);
            lkwList.get(position-1).setHintereIdById(id);
        }
        else if(position == 0)
        {
            // Einer Neuer will auf Leader
            lkw = new LKW(0,lkwList.get(position).getId(), 80, true);
            lkwList.add(0, lkw);
            lkwList.get(position +1).setVordereId(id);
            lkwList.get(position+1).setFührer(false);

        }
        else
        {
            // Neuer Truck wird hinzugefügt
            lkw = new LKW(lkwList.get(position-1).getId(),lkwList.get(position).getId(),80,false);
            lkwList.add(position, lkw);
            lkwList.get(position-1).setHintereIdById();
            lkwList.get(position+1).setVordereId();
        }
        return lkw;
    }

    public LKW getTruckById(int id){
        LKW l = null;
        for (int i=0; i < lkwList.size(); i++) {
            if(id == lkwList.get(i).getId()){
                l = lkwList.get(i);
                break;
            }
        }
        return l;
    }

    public int getLKWFührerId(){
        return lkwList.get(0).getLKWFührerId();
    }
    public int getOneLKWById() {
        LKW l = null;

        l = lkwList.get(id);
        return l;
    }

    public int detectGeschwindigkeit(){
        if(lkwList.isEmpty()){
            return -1;
        }else{
            return lkwList.get(0).getGeschwindigkeit();
        }
    }

    public void setGeschwindigkeit(int geschwindigkeit){
        for(int i = 0; i < lkwList.size(); i++)
        {
            lkwList.get(i).setGeschwindigkeit(geschwindigkeit);
        }
    }

    public void setVordereIdById(int id, int newVordereId)
    {
        for (int i=0; i < lkwList.size(); i++) {
            if(id == lkwList.get(i).getId()){
                lkwList.get(i).setVordereId(newVordereId);
            }
        }
    }

    public void setHintereIdById(int id)
    {
        for (int i=0; i < lkwList.size(); i++) {
            if(id == lkwList.get(i).getId()){
                lkwList.get(i).setHintereId(newHintereId);
            }
        }
    }

    public void exit(int id){
        LKW lkw = getLKWById(id);
        int vordereId = lkw.getVordereId();
        int hintereId = lkw.getHintereId();
        if(vordereId!=0){
            setHintereIdById(vordereId);
        }
        if (hintereId != 0)
        {
            setVordereIdById(hintereId, vordereId);
        }
        if (lkw.getFührer() && lkwList.size()>1)
        {
            lkwList.get(1).setFührer(true);
        }
        lkwList.remove(lkw);
    }

    public List<LKW> getLKWList() {
        return lkwList;
            }

    public void setLKWList(List<LKW> lkwList) { this.lkwList = lkwList;}


        }
