package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener{
    JTextField userText, passwordText;
    Choice loginChoice;

    JButton loginButton, cancelButton, signupButton;

    Login(){
        //Username and user text field...
        super("Login Page");

        JLabel header = new JLabel("LOGIN");
        header.setBounds(280,9,150,32);
        header.setForeground(Color.WHITE);
        header.setFont(new Font("Cambria",Font.BOLD,26));
        add(header);

        JLabel username = new JLabel("UserName");
        username.setBounds(300,60,100,20);
        add(username);

        userText = new JTextField();
        userText.setBounds(400,60,150,20);
        add(userText);

        //Password and password text field...
        JLabel password = new JLabel("Password");
        password.setBounds(300,100,100,20);
        add(password);

        passwordText = new JTextField();
        passwordText.setBounds(400,100,150,20);
        add(passwordText);

        //Login options for admin and customer...
        JLabel loggin = new JLabel("Log In As");
        loggin.setBounds(300,140,100,20);
        add(loggin);

        loginChoice = new Choice();
        loginChoice.add("-Select");
        loginChoice.add("Admin");
        loginChoice.add("Customer");
        loginChoice.setBounds(400,140,150,20);
        add(loginChoice);

        //Login Button...
        loginButton = new JButton("LOGIN");
        loginButton.setBounds(320,180,100,20);
        loginButton.addActionListener(this);
        add(loginButton);

        //Cancel Button...
        cancelButton = new JButton("CANCEL");
        cancelButton.setBounds(450,180,100,20);
        cancelButton.addActionListener(this);
        add(cancelButton);

        //SignUp Button...
        signupButton = new JButton("SIGNUP");
        signupButton.setBounds(385,220,100,20);
        signupButton.addActionListener(this);
        add(signupButton);

        ImageIcon profile1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash/profile.gif"));
        Image profile2 = profile1.getImage().getScaledInstance(180,180,Image.SCALE_DEFAULT);
        ImageIcon fprofileOne = new ImageIcon(profile2);
        JLabel profileLabel = new JLabel(fprofileOne);
        profileLabel.setBounds(35,45,180,180);
        add(profileLabel);

        ImageIcon background1 = new ImageIcon(ClassLoader.getSystemResource("icon/splash/background.png"));
        Image background2 = background1.getImage().getScaledInstance(650, 300,Image.SCALE_DEFAULT);
        ImageIcon backGround = new ImageIcon(background2);
        JLabel backgroundLabel = new JLabel(backGround);
        backgroundLabel.setBounds(0,0,650,300);
        add(backgroundLabel);


        //Login Screen frame size...
        setSize(650, 300);
        setLocation(450,250);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton){
            String susername = userText.getText();
            String spassword = passwordText.getText();
            String suser = loginChoice.getSelectedItem();

            try{
                database c = new database();
                String query = "select * from Signup where username = '"+susername+"' and password = '"+spassword+"' and usertype = '"+suser+"'";
                ResultSet resultSet = c.statement.executeQuery(query);

                if(resultSet.next()){
                    String meter = resultSet.getString("meter_no");
                    setVisible(false);
                    new main_class(suser, meter);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == cancelButton) {
            setVisible(false);
        } else if (e.getSource() == signupButton) {
            setVisible(false);
            new Signup();
        }
    }

    public static void main(String[] args) {
        new Login();
    }
}
