package com.wangby.observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverMain {


}

class Child {
    boolean cry = false;
    List<Observer> list = new ArrayList<Observer>();
    {
        list.add(new Dad());
        list.add(new Mum());
        list.add(new Dog());
    }

    public boolean isCry() {
        return cry;
    }

    public void wakeUp() {
        cry = true;
        for (Observer o : list) {
            o.observerAction();
        }
    }

}

interface Observer {
    void observerAction();
}

class Dad implements Observer {

    public void dadAction() {
        System.out.println("dad feeding....");
    }

    @Override
    public void observerAction() {
        dadAction();
    }
}

class Mum implements Observer {

    public void mumAction() {
        System.out.println("mum hug.....");
    }

    @Override
    public void observerAction() {
        mumAction();
    }
}

class Dog implements Observer {

    public void DogAction() {
        System.out.println("Dog wang...");
    }

    @Override
    public void observerAction() {
        DogAction();
    }
}
