package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame {

    Splash(){
        JLabel text = new JLabel("Creativity is the electricity of life.");
        text.setBounds(126,8,280,30);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Cambria",Font.ITALIC,18));
        add(text);

        JLabel text1 = new JLabel("Electricity Billing System");
        text1.setBounds(135,425,280,30);
        text1.setForeground(Color.green);
        text1.setFont(new Font("Arial",Font.BOLD,18));
        add(text1);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/Splash.jpg"));
        Image imageOne = imageIcon.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(imageOne);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        setSize(500,500);
        setLocation(500,200);
        setVisible(true);

        try{
            Thread.sleep(5000);
            setVisible(false);

            new Login();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Splash();
    }
}
