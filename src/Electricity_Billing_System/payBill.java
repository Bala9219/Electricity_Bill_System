package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.security.spec.ECField;
import java.sql.ResultSet;

public class payBill extends JFrame implements ActionListener {

    Choice searchMonthCho;
    JButton pay, back;
    String meter;

    payBill(String meter){
        this.meter = meter;

        //Heading...
        JLabel heading = new JLabel("PAY BILL");
        heading.setFont(new Font("Cambria", Font.BOLD,28));
        heading.setBounds(160,8,400,30);
        heading.setForeground(Color.WHITE);
        add(heading);

        // Meter Number...
        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(35,80,200,20);
        meterNumber.setForeground(Color.WHITE);
        add(meterNumber);

        JLabel meterNumberText = new JLabel("");
        meterNumberText.setBounds(300,80,200,20);
        add(meterNumberText);

        //Name..
        JLabel name = new JLabel("Name");
        name.setBounds(35,140,200,20);
        name.setForeground(Color.WHITE);
        add(name);

        JLabel nameText = new JLabel("");
        nameText.setBounds(300,140,200,20);
        add(nameText);

        //Month...
        JLabel month = new JLabel("Month");
        month.setBounds(35,200,200,20);
        month.setForeground(Color.WHITE);
        add(month);

        searchMonthCho = new Choice();
        searchMonthCho.add("-Select");
        searchMonthCho.add("January");
        searchMonthCho.add("February");
        searchMonthCho.add("March");
        searchMonthCho.add("April");
        searchMonthCho.add("May");
        searchMonthCho.add("June");
        searchMonthCho.add("July");
        searchMonthCho.add("August");
        searchMonthCho.add("September");
        searchMonthCho.add("October");
        searchMonthCho.add("November");
        searchMonthCho.add("December");
        searchMonthCho.setBounds(300,200,150,20);
        add(searchMonthCho);

        //Unit...
        JLabel unit = new JLabel("Unit");
        unit.setBounds(35,260,200,20);
        unit.setForeground(Color.WHITE);
        add(unit);

        JLabel unitText = new JLabel("");
        unitText.setBounds(300,260,200,20);
        add(unitText);

        //Total Bill...
        JLabel totalBill = new JLabel("Total Bill");
        totalBill.setBounds(35,320,200,20);
        totalBill.setForeground(Color.WHITE);
        add(totalBill);

        JLabel totalBillText = new JLabel("");
        totalBillText.setBounds(300,320,200,20);
        add(totalBillText);

        //Status...
        JLabel status = new JLabel("Status");
        status.setBounds(35,380,200,20);
        status.setForeground(Color.WHITE);
        add(status);

        JLabel statusText = new JLabel("");
        statusText.setBounds(300,380,200,20);
        add(statusText);

        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer where meterno = '"+meter+"'");
            while (resultSet.next()){
                meterNumberText.setText(meter);
                nameText.setText(resultSet.getString("name"));

            }
        }catch (Exception e){
            e.printStackTrace();
        }

        searchMonthCho.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                database c = new database();
                try {
                    ResultSet resultSet = c.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+searchMonthCho.getSelectedItem()+"' ");
                    while (resultSet.next()){
                        unitText.setText(resultSet.getString("Unit"));
                        totalBillText.setText(resultSet.getString("total_bill"));
                        statusText.setText(resultSet.getString("status"));
                    }
                }catch (Exception E){
                    E.printStackTrace();
                }
            }
        });

        pay = new JButton("Pay");
        pay.setBackground(Color.white);
        pay.setForeground(Color.black);
        pay.setBounds(100,460,100,25);
        pay.addActionListener(this);
        add(pay);

        back = new JButton("Back");
        back.setBackground(Color.white);
        back.setForeground(Color.black);
        back.setBounds(250,460,100,25);
        back.addActionListener(this);
        add(back);

        setSize(900,600);
        setLocation(300,150);
        setLayout(null);

        getContentPane().setBackground(new Color(242,70,182));

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == pay){
            try {
                database c = new database();
                c.statement.executeUpdate("update bill set status = 'Paid' where meter_no = '"+meter+"' and month = '"+searchMonthCho.getSelectedItem()+"' ");

            }catch (Exception E){
                E.printStackTrace();
            }
            setVisible(false);
            new paymentBill(meter);
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new payBill("");
    }
}
