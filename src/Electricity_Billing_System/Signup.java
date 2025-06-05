package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Signup extends JFrame implements ActionListener {

    Choice loginAsCho;
    TextField meterText, employerText, userNameText, nameText, passwordText;
    JButton create, back;

    Signup(){
        super("Signup Page");
        getContentPane().setBackground(new Color(224,103,103));

        //header of the screen...
        JLabel header1 = new JLabel("SIGNUP");
        header1.setBounds(250,9,150,32);
        header1.setForeground(Color.WHITE);
        header1.setFont(new Font("Cambria",Font.BOLD,26));
        add(header1);

        //Account selection...
        JLabel createAs = new JLabel("Create Account As");
        createAs.setBounds(30,70,130,20);
        add(createAs);

        loginAsCho = new Choice();
        loginAsCho.add("-Select");
        loginAsCho.add("Admin");
        loginAsCho.add("Customer");
        loginAsCho.setBounds(170,70,130,25);
        add(loginAsCho);

        //Meter Number text field...
        JLabel meterNo = new JLabel("Meter Number");
        meterNo.setBounds(30,110,130,20);
        meterNo.setVisible(false);
        add(meterNo);

        meterText = new TextField();
        meterText.setBounds(170,110,130,20);
        meterText.setVisible(false);
        add(meterText);

        //Eployer text field...
        JLabel employer = new JLabel("Employer Id");
        employer.setBounds(30,110,130,20);
        employer.setVisible(false);
        add(employer);

        employerText = new TextField();
        employerText.setBounds(170,110,130,20);
        employerText.setVisible(false);
        add(employerText);

        //Username text field...
        JLabel userName = new JLabel("UserName");
        userName.setBounds(30,150,130,20);
        add(userName);

        userNameText = new TextField();
        userNameText.setBounds(170,150,130,20);
        add(userNameText);

        //Name text field...
        JLabel name = new JLabel("Name");
        name.setBounds(30,190,130,20);
        add(name);

        nameText = new TextField("");
        nameText.setBounds(170,190,130,20);
        add(nameText);

        meterText.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {

            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    database c = new database();
                    ResultSet resultSet = c.statement.executeQuery("select * from Signup where meter_no = '"+meterText.getText()+"' ");
                    if (resultSet.next()){
                        nameText.setText(resultSet.getString("name"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        //Password text field...
        JLabel password = new JLabel("Password");
        password.setBounds(30,230,130,20);
        add(password);

        passwordText = new TextField();
        passwordText.setBounds(170,230,130,20);
        add(passwordText);

        //Admin and customer option selection...
        loginAsCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                String user = loginAsCho.getSelectedItem();
                if(user.equals("Customer")){
                    employer.setVisible(false);
                    nameText.setEditable(false);
                    employerText.setVisible(false);
                    meterNo.setVisible(true);
                    meterText.setVisible(true);
                }else if(user.equals("Admin")){
                    employer.setVisible(true);
                    employerText.setVisible(true);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }else{
                    employer.setVisible(false);
                    employerText.setVisible(false);
                    meterNo.setVisible(false);
                    meterText.setVisible(false);
                }
            }
        });

        //Buttons...
        create = new JButton("Create");
        create.setBackground(new Color(26,152,219)); //(For RGB COLOR)
        create.setForeground(Color.white); //(To change the color of the text)
        create.setBounds(50,285,100,25);
        create.addActionListener(this);
        add(create);

        back = new JButton("Back");
        back.setBackground(new Color(26,152,219));
        back.setForeground(Color.WHITE);
        back.setBounds(180,285,100,25);
        back.addActionListener(this);
        add(back);

        ImageIcon signupIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/signupIcon.png"));
        Image signupImage = signupIcon.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
        ImageIcon signupIcon2 = new ImageIcon(signupImage);
        JLabel signupLabel = new JLabel(signupIcon2);
        signupLabel.setBounds(340,70,200,200);
        add(signupLabel);

        //Frame setup and size...
        setSize(600,400);
        setLocation(480,220);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == create){
            String sloginAs = loginAsCho.getSelectedItem();
            String susername = userNameText.getText();
            String sname = nameText.getText();
            String spassword = passwordText.getText();
            String smeter = meterText.getText();
            try{
                database c = new database();
                String query = null;
                if (sloginAs.equals("Admin")){
                    query = "insert into Signup values('"+smeter+"', '"+susername+"', '"+sname+"', '"+spassword+"', '"+sloginAs+"')";
                }else {
                    query = "update Signup set username = '"+susername+"', password = '"+spassword+"', usertype = '"+sloginAs+"' where meter_no = '"+smeter+"' ";
                }

                c.statement.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Account Created");
                setVisible(false);
                new Login();

            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Signup();
    }
}
