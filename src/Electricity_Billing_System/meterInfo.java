package Electricity_Billing_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class meterInfo extends JFrame implements ActionListener {

    Choice meterLocCho, meterTypeCho, phaseCodeCho, billtypCho;
    JButton submit;
    String meternumber;

    meterInfo(String meternumber){
        super("Meter Info");

        this.meternumber = meternumber;

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(74,141,247));
        add(panel);

        //Header...
        JLabel heading = new JLabel("Meter Information");
        heading.setBounds(150,10,240,20);
        heading.setFont(new Font("Cambria", Font.BOLD, 26));
        heading.setForeground(Color.WHITE);
        panel.add(heading);

        //Meter number...
        JLabel meterNumber = new JLabel("Meter Number");
        meterNumber.setBounds(50,80,100,20);
        panel.add(meterNumber);

        JLabel meterNumberText = new JLabel(meternumber);
        meterNumberText.setBounds(180,80,150,20);
        panel.add(meterNumberText);

        //Type of Meter number...
        JLabel meterLoc = new JLabel("Meter Number");
        meterLoc.setBounds(50,120,100,20);
        panel.add(meterLoc);

        meterLocCho = new Choice();
        meterLocCho.add("-Select");
        meterLocCho.add("Outside");
        meterLocCho.add("Inside");
        meterLocCho.setBounds(180,120,150,20);
        panel.add(meterLocCho);

        //Meter Type...
        JLabel meterTyp = new JLabel("Meter Type");
        meterTyp.setBounds(50,160,100,20);
        panel.add(meterTyp);

        meterTypeCho = new Choice();
        meterTypeCho.add("-Select");
        meterTypeCho.add("Electric Meter");
        meterTypeCho.add("Solar Meter");
        meterTypeCho.add("Smart Meter");
        meterTypeCho.setBounds(180,160,150,20);
        panel.add(meterTypeCho);

        //Phase Code...
        JLabel phaseCode = new JLabel("Phase Code");
        phaseCode.setBounds(50,200,100,20);
        panel.add(phaseCode);

        phaseCodeCho = new Choice();
        phaseCodeCho.add("-Select");
        phaseCodeCho.add("011");
        phaseCodeCho.add("022");
        phaseCodeCho.add("033");
        phaseCodeCho.add("044");
        phaseCodeCho.add("055");
        phaseCodeCho.add("066");
        phaseCodeCho.add("077");
        phaseCodeCho.add("088");
        phaseCodeCho.add("099");
        phaseCodeCho.setBounds(180,200,150,20);
        panel.add(phaseCodeCho);

        //Bill Type...
        JLabel billtyp = new JLabel("Bill Type");
        billtyp.setBounds(50,240,100,20);
        panel.add(billtyp);

        billtypCho = new Choice();
        billtypCho.add("-Select");
        billtypCho.add("Normal");
        billtypCho.add("Industrial");
        billtypCho.setBounds(180,240,150,20);
        panel.add(billtypCho);

        //Day...
        JLabel day = new JLabel("30 Days Billing Time...");
        day.setBounds(50,280,150,20);
        panel.add(day);

        //Note...
        JLabel note = new JLabel("Note:-");
        note.setBounds(50,320,100,20);
        panel.add(note);

        //Note...
        JLabel note1 = new JLabel("By default bill is calculated for 30 days only");
        note1.setBounds(50,340,300,20);
        panel.add(note1);

        //Submit Button...
        submit = new JButton("Submit");
        submit.setBounds(220,390,100, 25);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        panel.add(submit);

        setLayout(new BorderLayout());
        add(panel, "Center");

        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icon/splash/details.png"));
        Image i2 = i1.getImage().getScaledInstance(230,200,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel imgLabel = new JLabel(i3);
        add(imgLabel, "East");

        setSize(700,500);
        setLocation(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String smeterNum = meternumber;
            String smeterLoc = meterLocCho.getSelectedItem();
            String smeterTyp = meterTypeCho.getSelectedItem();
            String sphaseCode = phaseCodeCho.getSelectedItem();
            String sbillTyp = billtypCho.getSelectedItem();
            String sday = "30";

            String query_meterInfo = "insert into Meter_Info values('"+smeterNum+"', '"+smeterLoc+"', '"+smeterTyp+"', '"+sphaseCode+"', '"+sbillTyp+"', '"+sday+"')";
            try{
                database c = new database();
                c.statement.executeUpdate(query_meterInfo);

                JOptionPane.showMessageDialog(null, "Meter Information Submitted Successfully.");
                setVisible(false);
            }catch (Exception E){
                E.printStackTrace();
            }
        }else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new meterInfo("");
    }
}
