package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class generateBill extends JFrame implements ActionListener {

    String meter;
    Choice searchMonthCho;
    JTextArea area;
    JButton bill;

    generateBill(String meter){
        this.meter = meter;

        setSize(500,700);
        setLocation(500,30);
        setLayout(new BorderLayout());
        JPanel panel = new JPanel();

        JLabel heading = new JLabel("Generate Bill");

        JLabel meter_no = new JLabel(meter);

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

        area = new JTextArea(50,15);
        area.setText("\n \n \t ----------------- Click on the -------------------\n \t -------------------- generate Bill");
        area.setFont(new Font("Senserif", Font.ITALIC, 15));
        JScrollPane pane = new JScrollPane(area);

        bill = new JButton("Generate Bill");
        bill.addActionListener(this);

        add(pane);

        panel.add(heading);
        panel.add(meter_no);
        panel.add(searchMonthCho);
        add(panel, "North");
        add(bill, "South");

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            database c = new database();
            String smonth = searchMonthCho.getSelectedItem();
            area.setText("\n Power Limited \n Electricity Bill For Month of "+smonth+", 2025\n\n\n");
            ResultSet resultSet = c.statement.executeQuery(("select * from New_Customer where meterno ='"+meter+"' "));
            if (resultSet.next()){
                area.append("\n    Customer Name          : "+resultSet.getString("name"));
                area.append("\n    Customer Meter Number  : "+resultSet.getString("meterno"));
                area.append("\n    Customer Address       : "+resultSet.getString("address"));
                area.append("\n    Customer City          : "+resultSet.getString("city"));
                area.append("\n    Customer State         : "+resultSet.getString("state"));
                area.append("\n    Customer Email         : "+resultSet.getString("email"));
                area.append("\n    Customer Phone Number  : "+resultSet.getString("phone_no"));

            }

            resultSet = c.statement.executeQuery("select * from Meter_Info where meter_number ='"+meter+"'");
            if (resultSet.next()){
                area.append("\n    Customer Meter Location : "+resultSet.getString("meter_location"));
                area.append("\n    Customer Meter Type     : "+resultSet.getString("meter_type"));
                area.append("\n    Customer Phase Code     : "+resultSet.getString("phase_code"));
                area.append("\n    Customer Bill Type      : "+resultSet.getString("bill_type"));
                area.append("\n    Customer Days           : "+resultSet.getString("days"));


            }
            resultSet = c.statement.executeQuery("select * from tax");
            if (resultSet.next()){
                area.append("\n   Cost Per Unit            : "+resultSet.getString("cost_per_unit"));
                area.append("\n   Meter Rent               : "+resultSet.getString("meter_rent"));
                area.append("\n   Service Charge           : "+resultSet.getString("service_charge"));
                area.append("\n   Service Tax              : "+resultSet.getString("service_tax"));
                area.append("\n   Swacch Bharat            : "+resultSet.getString("swachh_bharat"));
                area.append("\n   Fixed Tax                : "+resultSet.getString("fixed_tax"));

            }
            resultSet = c.statement.executeQuery("select * from bill where meter_no = '"+meter+"' and month = '"+searchMonthCho.getSelectedItem()+"'");
            if (resultSet.next()) {
                area.append("\n   Current Month            : " + resultSet.getString("month"));
                area.append("\n   Units Consumed           : " + resultSet.getString("unit"));
                area.append("\n   Total Charges            : " + resultSet.getString("total_bill"));
                area.append("\n   Total Payable            : "+resultSet.getString("total_bill"));
            }

        }catch (Exception E){
            E.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new generateBill("");
    }
}
