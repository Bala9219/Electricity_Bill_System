package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;

public class paymentBill extends JFrame implements ActionListener {

    JButton back, payNow;
    String meter;

    paymentBill(String meter){
        this.meter = meter;

        // Heading
        JLabel heading = new JLabel("Online Bill Payment");
        heading.setFont(new Font("Cambria", Font.BOLD, 24));
        heading.setBounds(260, 20, 300, 30);
        add(heading);

        // Instruction
        JLabel instruction = new JLabel("Click 'Pay Now' to proceed to Paytm payment portal.");
        instruction.setFont(new Font("SansSerif", Font.PLAIN, 16));
        instruction.setBounds(200, 100, 400, 30);
        add(instruction);

        // Pay Now button
        payNow = new JButton("Pay Now");
        payNow.setBounds(300, 180, 120, 40);
        payNow.addActionListener(this);
        add(payNow);

        // Back button
        back = new JButton("Back");
        back.setBounds(300, 250, 120, 40);
        back.addActionListener(this);
        add(back);

        // Frame settings
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setSize(800, 400);
        setLocation(400, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            setVisible(false);
            new payBill(meter); // Assuming you have a payBill class
        } else if (e.getSource() == payNow) {
            try {
                Desktop.getDesktop().browse(new URI("https://paytm.com/online-payments"));
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(this, "Unable to open browser.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public static void main(String[] args) {
        new paymentBill(""); // Example meter number
    }
}
