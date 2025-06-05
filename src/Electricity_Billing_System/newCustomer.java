package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class newCustomer extends JFrame implements ActionListener {

    JLabel heading, customerName, meterNum,meternumText, address, city, state, email, phone;
    TextField nameText, addressText, cityText, stateText, emailText, phoneText;
    JButton next, cancel;

    newCustomer(){
        super("New Customer");

        //Background colour of the frame...
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(74,141,247));
        add(panel);

        //Heading of the frame...
        heading = new JLabel("New Customer");
        heading.setBounds(140,10,200,20);
        heading.setFont(new Font("Cambria", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        //New Customer TextField...
        customerName = new JLabel("New Customer");
        customerName.setBounds(50,80,100,20);
        panel.add(customerName);

        nameText = new TextField();
        nameText.setBounds(180,80,150,20);
        panel.add(nameText);

        //Meter number TextField...
        meterNum = new JLabel("Meter Number");
        meterNum.setBounds(50,120,100,20);
        panel.add(meterNum);

        meternumText = new JLabel("");
        meternumText.setBounds(180, 120,150,20);
        panel.add(meternumText);

        //Random Number Generator...
        Random ran = new Random();
        long number = ran.nextLong() %1000000;
        meternumText.setText(""+ Math.abs(number));

        //Address Text Field...
        address = new JLabel("Address");
        address.setBounds(50,160,100,20);
        panel.add(address);

        addressText = new TextField();
        addressText.setBounds(180, 160,150,20);
        panel.add(addressText);

        //City Text Field...
        city = new JLabel("City");
        city.setBounds(50,200,100,20);
        panel.add(city);

        cityText = new TextField();
        cityText.setBounds(180, 200,150,20);
        panel.add(cityText);

        //State Text Field...
        state = new JLabel("State");
        state.setBounds(50,240,100,20);
        panel.add(state);

        stateText = new TextField();
        stateText.setBounds(180, 240,150,20);
        panel.add(stateText);

        //Email Text Field...
        email = new JLabel("E-Mail");
        email.setBounds(50,280,100,20);
        panel.add(email);

        emailText = new TextField();
        emailText.setBounds(180, 280,150,20);
        panel.add(emailText);

        //Phone Text Field...
        phone = new JLabel("Phone");
        phone.setBounds(50,320,100,20);
        panel.add(phone);

        phoneText = new TextField();
        phoneText.setBounds(180, 320,150,20);
        panel.add(phoneText);

        //Next Button...
        next = new JButton("Next");
        next.setBounds(70, 385,100,25);
        next.setBackground(Color.WHITE);
        next.setForeground(Color.BLACK);
        next.addActionListener(this);
        panel.add(next);

        //Cancel button...
        cancel = new JButton("Cancel");
        cancel.setBounds(200, 385,100,25);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel, "Center");
        setSize(700,500);
        setLocation(400,200);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash/boy.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        add(imgLabel,"West");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == next){
            String sname = nameText.getText();
            String smeter = meternumText.getText();
            String saddress = addressText.getText();
            String scity = cityText.getText();
            String sstate = stateText.getText();
            String semail = emailText.getText();
            String sphone = phoneText.getText();

            String query_customer = "insert into New_Customer values('"+sname+"', '"+smeter+"', '"+saddress+"', '"+scity+"', '"+sstate+"', '"+semail+"', '"+sphone+"')";
            String query_signup = "insert into Signup values('"+smeter+"', '','"+sname+"', '', '')";

            try{
                database c = new database();
                c.statement.executeUpdate(query_customer);
                c.statement.executeUpdate(query_signup);

                JOptionPane.showMessageDialog(null, "Customer Details Added Successfully.");
                setVisible(false);
                new meterInfo(smeter);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new newCustomer();
    }
}
