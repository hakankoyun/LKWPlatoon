package com.example.demo.Client;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    LKW lkw = new LKW(2,3,80,true);
    LKWService lkwService = new LKWService();

    @GetMapping(path="/addLKW/{position}")
    public @ResponseBody LKW addLKW(@PathVariable int position){

        return  lkwService.addLKW(position);
    }

    @RequestMapping(path="/getPlatoon")
    public List<LKW> getPlatoon(){
        return lkwService.getLKWList();
    }

    @RequestMapping(path ="/showLKWAgentById/{id}")
    public @ResponseBody LKW show(){
        return lkwService.getOneLKWkById(lkw.getOneLKWById());
    }

    @RequestMapping(path = "/stop")
    public @ResponseBody
    String stop(){
        lkwService.stop();
        return "gestoppt";
    }

    @RequestMapping(path ="/slowdown/{speed}" )
    public @ResponseBody
    String slowdown(@PathVariable int speed){
        lkwService.slowdown(speed);
        return "slowgedowned";
    }

    @RequestMapping(path = "/accelerate/{speed}")
    public String accelerate(@PathVariable int speed){
       lkwService.accelerate(speed);
       return "beschleunigt";
    }

    @RequestMapping(path = "/exit/{id}")
    public String exit(@PathVariable int id){
        lkwService.exitPlatoon(id);
        return "Erfolgreich gelöscht";
    }

    @GetMapping(path= "/SocketDa/{id}")
    public String socketDa(@PathVariable int id){
        lkwService.verbinden(id);
        return "verbunden";
    }
}
