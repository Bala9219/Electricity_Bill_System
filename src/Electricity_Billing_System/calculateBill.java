package Electricity_Billing_System;

import com.mysql.cj.jdbc.result.ResultSetImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;

public class calculateBill extends JFrame implements ActionListener {

    JLabel nameText, addressText;
    TextField unitText;

    Choice meternumCho, monthCho;
    JButton submit, cancel;

    calculateBill (){
        super("Calculate Bill");

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(15,247,209));
        add(panel);

        //Heading...
        JLabel heading = new JLabel("Calculate Electricity Bill");
        heading.setBounds(90,15,350,30);
        heading.setFont(new Font("Cambria", Font.BOLD, 26));
        panel.add(heading);

        //Meter Number...
        JLabel meternum = new JLabel("Meter Number");
        meternum.setBounds(70, 90,100,20);
        panel.add(meternum);

        meternumCho = new Choice();
        meternumCho.add("-Select");
        try{
            database c = new database();
            ResultSet resultSet = c.statement.executeQuery("select * from New_Customer");
            while (resultSet.next()){
                meternumCho.add(resultSet.getString("meterno"));
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
        meternumCho.setBounds(200,90,100,20);
        panel.add(meternumCho);

        //Name...
        JLabel name = new JLabel("Name");
        name.setBounds(70,140,100,20);
        panel.add(name);

        nameText = new JLabel("");
        nameText.setBounds(200,140,100,20);
        panel.add(nameText);

        //Address...
        JLabel address = new JLabel("Address");
        address.setBounds(70,190,100,20);
        panel.add(address);

        addressText = new JLabel("");
        addressText.setBounds(200,190,100,20);
        panel.add(addressText);

        // Add item listener to update name and address when meter is selected
        meternumCho.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                String selectedMeter = meternumCho.getSelectedItem();
                if (!selectedMeter.equals("-Select")) {
                    try {
                        database c = new database();
                        ResultSet resultSet = c.statement.executeQuery("select * from New_Customer where meterno = '" + selectedMeter + "' ");
                        if (resultSet.next()) {
                            nameText.setText(resultSet.getString("name"));
                            addressText.setText(resultSet.getString("address"));
                        }
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } else {
                    nameText.setText("");
                    addressText.setText("");
                }
            }
        });

        //Unit Consumed...
        JLabel unitConsumed = new JLabel("Unit Consumed");
        unitConsumed.setBounds(70, 240, 100,20);
        panel.add(unitConsumed);

        unitText = new TextField();
        unitText.setBounds(200,240,150,20);
        panel.add(unitText);

        //Month...
        JLabel month = new JLabel("Month");
        month.setBounds(70, 290,100,20);
        panel.add(month);

        monthCho = new Choice();
        monthCho.add("-Select");
        monthCho.add("January");
        monthCho.add("February");
        monthCho.add("March");
        monthCho.add("April");
        monthCho.add("May");
        monthCho.add("June");
        monthCho.add("July");
        monthCho.add("August");
        monthCho.add("September");
        monthCho.add("October");
        monthCho.add("November");
        monthCho.add("December");
        monthCho.setBounds(200,290,150,20);
        panel.add(monthCho);

        submit = new JButton("Submit");
        submit.setBounds(90, 360,100,25);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(230, 360,100,25);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        panel.add(cancel);

        setLayout(new BorderLayout());
        add(panel,"Center");
        ImageIcon imageIcon = new ImageIcon(ClassLoader.getSystemResource("icon/splash/budget.png"));
        Image image = imageIcon.getImage().getScaledInstance(250,200,Image.SCALE_DEFAULT);
        ImageIcon imageIcon1 = new ImageIcon(image);
        JLabel imageLabel = new JLabel(imageIcon1);
        add(imageLabel,"East");


        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit){
            String smeterNo = meternumCho.getSelectedItem();
            String sunit = unitText.getText();
            String smonth = monthCho.getSelectedItem();

            int totalBill = 0;
            int units = Integer.parseInt(sunit);
            String query_tax = "select * from tax";
            try{
                database c = new database();
                ResultSet resultSet = c.statement.executeQuery(query_tax);
                while (resultSet.next()){
//                    totalBill += units * Integer.parseInt(resultSet.getString("cost_per_unit"));
//                    totalBill += Integer.parseInt(resultSet.getString("meter_rent"));
//                    totalBill += Integer.parseInt(resultSet.getString("service_charge"));
//                    totalBill += Integer.parseInt(resultSet.getString("swachh_bharat"));
//                    totalBill += Integer.parseInt(resultSet.getString("fixed_tax"));

                    int cost_per_unit = Integer.parseInt(resultSet.getString("cost_per_unit"));
                    int meter_rent = Integer.parseInt(resultSet.getString("meter_rent"));
                    int service_charge = Integer.parseInt(resultSet.getString("service_charge"));
                    int swachh_bharat = Integer.parseInt(resultSet.getString("swachh_bharat"));
                    int fixed_tax = Integer.parseInt(resultSet.getString("fixed_tax"));

                    totalBill = (units * cost_per_unit) + meter_rent + service_charge + swachh_bharat + fixed_tax;
                }
            }catch (Exception E){
                E.printStackTrace();
            }
            String query_total_bill = "insert into bill values('"+smeterNo+"', '"+smonth+"', '"+sunit+"', '"+totalBill+"', 'Not Paid')";
            try {
                database c = new database();
                c.statement.executeUpdate(query_total_bill);

                JOptionPane.showMessageDialog(null, "Customer Bill Updated Successfully.");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new calculateBill();
    }

}
