package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;


public class customerDetails extends JFrame implements ActionListener {

    Choice searchMeterCho, searchNameCho;
    JTable table;
    JButton search, print, close;

    customerDetails(){
        super("Customer Details");
        getContentPane().setBackground(new Color(247,156,235));

        //Search by Meter Number...
        JLabel searchMeter = new JLabel("Search by Meter Number");
        searchMeter.setBounds(20,20,150,20);
        add(searchMeter);

        searchMeterCho = new Choice();
        searchMeterCho.setBounds(180,20,150,20);
        add(searchMeterCho);

        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer");
            while (resultSet.next()){
                searchMeterCho.add(resultSet.getString("meterno"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        //Search by Name
        JLabel searchName = new JLabel("Search by Name");
        searchName.setBounds(400,20,100,20);
        add(searchName);

        searchNameCho = new Choice();
        searchNameCho.setBounds(520,20,150,20);
        add(searchNameCho);

        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer");
            while (resultSet.next()){
                searchNameCho.add(resultSet.getString("name"));
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        table = new JTable();
        try {
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer");
            table.setModel(DbUtils.resultSetToTableModel(resultSet));
        }catch (Exception e){
            e.printStackTrace();
        }

        JScrollPane scrollpane = new JScrollPane(table);
        scrollpane.setBounds(0, 100, 700, 400);
        add(scrollpane);

        //Search Button...
        search = new JButton("Search");
        search.setBackground(Color.WHITE);
        search.setBounds(20,70,80,20);
        search.addActionListener(this);
        add(search);

        //Print Button...
        print = new JButton("Print");
        print.setBackground(Color.WHITE);
        print.setBounds(120,70,80,20);
        print.addActionListener(this);
        add(print);

        //Close Button...
        close = new JButton("Close");
        close.setBackground(Color.WHITE);
        close.setBounds(600,70,80,20);
        close.addActionListener(this);
        add(close);

        setSize(700, 500);
        setLocation(400, 200);
        setLayout(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == search){
            String query_search = "select * from New_Customer where meterno = '"+searchMeterCho.getSelectedItem()+"' and name = '"+searchNameCho.getSelectedItem()+"' ";
            try {
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_search);
                table.setModel(DbUtils.resultSetToTableModel(resultSet));
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == print){
            try {
                table.print();
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new customerDetails();
    }
}
