package cn.jc.java.corejava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class TimePrinter implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("At the tone, the time is " + Instant.ofEpochMilli(e.getWhen()));
        Toolkit.getDefaultToolkit().beep();
    }

    public static void main(String[] args) throws InterruptedException {
//        var listener = new TimePrinter();
//        Timer t = new Timer(1000, listener);
//        t.start();
        Timer t = new Timer(1000, event->System.out.println("1"));
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}
