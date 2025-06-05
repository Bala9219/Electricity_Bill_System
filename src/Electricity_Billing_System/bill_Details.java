package Electricity_Billing_System;

import net.proteanit.sql.DbUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class bill_Details extends JFrame {

    String meter;

    bill_Details(String meter){
        this.meter = meter;

        JLabel heading = new JLabel(" BILL DETAILS");
        heading.setBounds(270,4,200,30);
        heading.setFont(new Font("Cambria", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        add(heading);

        JTable table = new JTable();

        try {
            database c = new database();
            String query_bill = "select * from bill where meter_no = '"+meter+"'";
            ResultSet resultSet = c.statement.executeQuery(query_bill);
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(0,40,700,650);
        add(sp);

        setSize(700,650);
        setLocation(400,150);
        setLayout(null);
        getContentPane().setBackground(Color.PINK);

        setVisible(true);
    }
    public static void main(String[] args) {
        new bill_Details("");
    }

}
