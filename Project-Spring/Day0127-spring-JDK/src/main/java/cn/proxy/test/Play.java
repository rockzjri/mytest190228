package cn.proxy.test;

import cn.proxy.impl.ActionActor;

public class Play {

    public static void main(String[] args) {

        ActionActor actor = new ActionActor();

        actor.basicAct(5000);

        actor.difficultyAct(10000);

    }
}
