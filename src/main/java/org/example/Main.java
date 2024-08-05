package org.example;

import org.example.keyPress.KeyPress;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(KeyPress::new);
    }
}