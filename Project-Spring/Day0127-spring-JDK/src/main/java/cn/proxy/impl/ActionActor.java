package cn.proxy.impl;

import cn.proxy.actor.Actor;

public class ActionActor implements  Actor {



    public void basicAct(float money) {

        System.out.println("演员【"+getActname()+"】收钱【"+money+"】，做basicAct的演出");

    }


    public void difficultyAct(float money) {
        System.out.println("演员【"+getActname()+"】收钱【"+money+"】，做difficultyAct的演出");

    }


    public String getActname() {
        return "小明";
    }
}
