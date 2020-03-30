package com.wangby.observer;

import java.util.ArrayList;
import java.util.List;

public class ButtonTest {

    public static void main(String[] args) {
        Button button = new Button();
        button.addListener(new MyActionLister());
        button.addListener(new MyActionLister2());
        button.buttonPress();
    }

}

class Button {
    List<ActionListener> list = new ArrayList<ActionListener>();

    public void addListener(ActionListener listener) {
        list.add(listener);
    }

    public void buttonPress() {
        ActionEvent e = new ActionEvent(System.currentTimeMillis(), this);
        for (ActionListener l : list) {
            l.actionPerformed(e);
        }
    }


}

interface ActionListener {
    void actionPerformed(ActionEvent e);
}

class MyActionLister implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("111");
    }
}

class MyActionLister2 implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("222");
    }
}


class ActionEvent {
    long when;
    Object source;

    public ActionEvent(long when, Object source) {
        this.when = when;
        this.source = source;
    }

    public long getWhen() {
        return when;
    }

    public Object getSource() {
        return source;
    }
}


