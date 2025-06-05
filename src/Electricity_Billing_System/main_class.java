package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class main_class extends JFrame implements ActionListener {

    String acctype;
    String meter_pass;

    main_class(String acctype, String meter_pass){
        this.acctype = acctype;
        this.meter_pass = meter_pass;
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/backgroundWeb.png"));
        Image image = imageIcon.getImage().getScaledInstance(1530,830,Image.SCALE_DEFAULT);
        ImageIcon imageIcon2 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon2);
        add(imageLabel);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.blue);
        setJMenuBar(menuBar);

        //Menubar items("Menu Option")...
        JMenu menu = new JMenu("Menu");
        menu.setFont(new Font("serif",Font.PLAIN,16));
        menu.setForeground(Color.white);

        //New Customer...
        JMenuItem newCustomer = new JMenuItem("New Customer");
        newCustomer.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/newcustomer.png"));
        Image customerImage = customerImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        newCustomer.setIcon(new ImageIcon(customerImage));
        newCustomer.addActionListener(this);
        menu.add(newCustomer);

        //Customer Details...
        JMenuItem customerdetails = new JMenuItem("Customer Details");
        customerdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon customerdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/customerDetails.png"));
        Image customerdetailsImage = customerdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        customerdetails.setIcon(new ImageIcon(customerdetailsImage));
        customerdetails.addActionListener(this);
        menu.add(customerdetails);

        //Deposit Details...
        JMenuItem depositdetails= new JMenuItem("Deposit Details");
        depositdetails.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon depositdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/depositdetails.png"));
        Image depositdetailsImage = depositdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        depositdetails.setIcon(new ImageIcon(depositdetailsImage));
        depositdetails.addActionListener(this);
        menu.add(depositdetails);

        //Calculate Bill...
        JMenuItem calculatebill= new JMenuItem("Calculate Bill");
        calculatebill.setFont(new Font("monospaced",Font.PLAIN,14));
        ImageIcon calculatebillImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculatorbills.png"));
        Image calculatebillImage = calculatebillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculatebill.setIcon(new ImageIcon(calculatebillImage));
        calculatebill.addActionListener(this);
        menu.add(calculatebill);

        //Menubar items("Info")...
        JMenu info = new JMenu("Information");
        info.setFont(new Font("serif",Font.PLAIN,16));
        info.setForeground(Color.white);

        //Information...
        JMenuItem updateinfo = new JMenuItem("Update Information");
        updateinfo.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon updateinfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/refresh.png"));
        Image updateinfoImage = updateinfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        updateinfo.setIcon(new ImageIcon(updateinfoImage));
        updateinfo.addActionListener(this);
        info.add(updateinfo);

        //View Information...
        JMenuItem viewInfo = new JMenuItem("View Information");
        viewInfo.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon viewInfoImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/information.png"));
        Image viewInfoImage = viewInfoImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        viewInfo.setIcon(new ImageIcon(viewInfoImage));
        viewInfo.addActionListener(this);
        info.add(viewInfo);

        //Menubar items("User")...
        JMenu user = new JMenu("User");
        user.setFont(new Font("serif",Font.PLAIN,16));
        user.setForeground(Color.white);

        //Pay Bill...
        JMenuItem paybill = new JMenuItem("Pay Bill");
        paybill.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon paybillImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/pay.png"));
        Image paybillImage = paybillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        paybill.setIcon(new ImageIcon(paybillImage));
        paybill.addActionListener(this);
        user.add(paybill);

        //Bill Details...
        JMenuItem billdetails = new JMenuItem("Bill Details");
        billdetails.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon billdetailsImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/detail.png"));
        Image billdetailsImage = billdetailsImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        billdetails.setIcon(new ImageIcon(billdetailsImage));
        billdetails.addActionListener(this);
        user.add(billdetails);

        //Menubar items("Bill")...
        JMenu bill = new JMenu("Bill");
        bill.setFont(new Font("serif",Font.PLAIN,16));
        bill.setForeground(Color.white);

        //Generate Bill...
        JMenuItem genBill = new JMenuItem("Generate Bill");
        genBill.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon genBillImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/bill.png"));
        Image genBillImage = genBillImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        genBill.setIcon(new ImageIcon(genBillImage));
        genBill.addActionListener(this);
        bill.add(genBill);

        //Menubar items("Utility")...
        JMenu utility = new JMenu("Utility");
        utility.setFont(new Font("serif",Font.PLAIN,16));
        utility.setForeground(Color.white);

        //Notepad...
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon notepadImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/notepad.png"));
        Image notepadImage = notepadImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        notepad.setIcon(new ImageIcon(notepadImage));
        notepad.addActionListener(this);
        utility.add(notepad);

        //Calculator...
        JMenuItem calculator = new JMenuItem("Calculator");
        calculator.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon calculatorImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/calculator.png"));
        Image calculatorImage = calculatorImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        calculator.setIcon(new ImageIcon(calculatorImage));
        calculator.addActionListener(this);
        utility.add(calculator);

        //Menubar items("Exit")...
        JMenu exit = new JMenu("Exit");
        exit.setFont(new Font("serif",Font.PLAIN,16));
        exit.setForeground(Color.white);

        //Exit...
        JMenuItem eexit = new JMenuItem("Exit");
        eexit.setFont(new Font("monospaced",Font.PLAIN,13));
        ImageIcon eexitImg = new ImageIcon(ClassLoader.getSystemResource("icon/splash/exit.png"));
        Image eexitImage = eexitImg.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
        eexit.setIcon(new ImageIcon(eexitImage));
        eexit.addActionListener(this);
        exit.add(eexit);

        if (acctype.equals("Admin")){
            menuBar.add(menu);
        }else {
            menuBar.add(bill);
            menuBar.add(user);
            menuBar.add(info);
        }
        menuBar.add(utility);
        menuBar.add(exit);

        setLayout(new FlowLayout());
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = e.getActionCommand();
        if (msg.equals("New Customer")){
            new newCustomer();
        } else if (msg.equals("Customer Details")) {
            new customerDetails();
        } else if (msg.equals("Deposit Details")) {
            new depositDetails();
        } else if (msg.equals("Calculate Bill")) {
            new calculateBill();
        } else if (msg.equals("View Information")) {
            new view_Information(meter_pass);
        } else if (msg.equals("Update Information")) {
            new updateInformation(meter_pass);
        } else if (msg.equals("Bill Details")) {
            new bill_Details(meter_pass);
        } else if (msg.equals("Calculator")) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Notepad")){
            try {
                Runtime.getRuntime().exec("notepad.exe");
            }catch (Exception E){
                E.printStackTrace();
            }
        } else if (msg.equals("Exit")){
            setVisible(false);
            new Login();
        } else if (msg.equals("Pay Bill")) {
            new payBill(meter_pass);
        } else if (msg.equals("Generate Bill")) {
            new generateBill(meter_pass);
        }
    }

    public static void main(String[] args) {
        new main_class("", "");
    }
}
