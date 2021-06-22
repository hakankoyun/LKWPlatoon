package com.example.demo.Client;

import java.util.List;

public class LKWService {

    LKWRepo lkwRepo = new LKWRepo();
    SocketClient führer;


    public LKW addLKW(int position) {
        LKW lkw = lkwRepo.addLKW(position);
        return lkw;
    }

    public List<LKW> getLKWList() {
        return lkwRepo.getLKWList();
    }

    // Beschleunigung
    public void accelerate(int speed) {

        int newGeschwindigkeit;
        int oldGeschwindigkeit = lkwRepo.detectGeschwindigkeit();
        if (oldGeschwindigkeit != -1) {
            if (oldGeschwindigkeit + geschwindigkeit >= 200) {
                newGeschwindigkeit = 200;
            } else {

                newGeschwindigkeit = oldGeschwindigkeit + geschwindigkeit;
            }
            LKWRepo.setSpeed(newGeschwindigkeit);
            führer.sendMessage("Dies ist die aktuelle Geschwindigkeit: " + newGeschwindigkeit);
        }

    }

    // Hier wird die Methode Bremsen ausgeführt für das Platoon system
    public void slowdown(int speed) {

        int newGeschwindigkeit;
        int oldGeschwindigkeit = lkwRepo.detectGeschwindigkeit();
        if (oldGeschwindigkeit != -1) {
            if (oldGeschwindigkeit - geschwindigkeit <= 0) {
                newGeschwindigkeit = 0;
            } else {
                newGeschwindigkeit = oldGeschwindigkeit - speed;
            }
            lkwRepo.setGeschwindigkeit(newGeschwindigkeit);
            führer.sendMessage("Dies ist die aktuelle Geschwindigkeit: " + newGeschwindigkeit);
        }

    }

    // In dieser Mehtoden kann man die Trucks stoppen
    public void stop() {

        lkwRepo.setGeschwindigkeit(0);
        if (führer != null) {
            führer.sendMessage("Dies ist die aktuelle Geschwindigkeit: " + 0);
        }

    }

    // Exit Platoon
    public void exitPlatoon(int id) {
        lkwRepo.exit(id);
    }

    // Auswahl aller Trucks über ID
    public LKW getLKWById(int id) {
        return lkwRepo.getLKWById(id);
    }

    // Auswahl von einem Truck über ID
    public LKW getOneLKWkById(int id) {
        return lkwRepo.getOneLKWById(id);
    }

    public void verbinden (int id) {
        if (id == lwkRepo.getLKWLeaderId()) {
            lkw = new SocketClient(lkwRepo.getLKWLeaderId(), 1);
        }
    }
}