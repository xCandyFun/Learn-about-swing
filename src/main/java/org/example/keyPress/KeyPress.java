package org.example.keyPress;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyPress extends JFrame {

    private boolean isFullScreen = false;
    private Rectangle windowBounds;

    public KeyPress(){

        setTitle("Key press");

        setSize(300,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                //VK_W for example is button w on keyboard
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE){
                    System.exit(1);
                }
                if (e.getKeyCode() == KeyEvent.VK_W){
                    //Can have a method here
                    //Do action here
                    System.out.println("w is press");
                }
                if (e.getKeyCode() == KeyEvent.VK_S){
                    int sum = 2+5;
                    System.out.println(sum);
                }
                if (e.getKeyCode()== KeyEvent.VK_F1){
                    toggleFullscreen();
                }

            }
        });

        setVisible(true);
    }

    private void toggleFullscreen(){
        GraphicsDevice device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();

        if (isFullScreen){
            // Restore the window to its original size and position
            dispose();// Remove the window from the screen
            setUndecorated(false);// Restore window decorations
            setBounds(windowBounds);// Restore original bounds
            setVisible(true);// Make the window visible again
            device.setFullScreenWindow(null);// Exit fullscreen mode
        }else {
            // Save the current bounds of the window
            windowBounds = getBounds();
            dispose();// Remove the window from the screen
            setUndecorated(true);// Remove window decorations
            setVisible(true);// Make the window visible again
            device.setFullScreenWindow(this);// Enter fullscreen mode
        }

        isFullScreen = !isFullScreen;
    }


}
