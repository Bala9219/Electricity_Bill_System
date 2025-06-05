# Electricity_Bill_System

# Electricity_Billing_System
A desktop-based Electricity Billing System built with Java Swing, JDBC, and MySQL. This project provides a full-stack implementation for managing customer records, billing, payments, and meter data.

# Technologies Used
1.Java (Swing for GUI)
2.JDBC (Java Database Connectivity)
3.MySQL (Database)

# IDE: Eclipse / IntelliJ IDEA / NetBeans

# Project Structure
# Java Classes
# Class Name	Description
main_class.java	         Main entry point of the application
Splash.java	             Splash screen shown at startup
Login.java	             Login interface for users and admins
Signup.java	             New user registration screen
NewCustomer.java         Form to add new customer details
CustomerDetails.java     View list of all customers
View_Information.java	   View specific customer information
UpdateInformation.java	 Update existing customer data
MeterInfo.java	         Register and view meter information
DepositDetails.java	     Handle deposits from customers
Bill_Details.java	       View bill history
GenerateBill.java	       Create new bill based on meter readings
CalculateBill.java	     Perform bill calculations
PayBill.java	           Display unpaid bills and payment options
PaymentBill.java	       Finalize and record payments

# MySQL Database Schema
Database Name: electricity_billing 
# Table Name	Purpose
Login	             Stores user/admin credentials
Signup	           Stores registered user data
newCustomer	       Stores customer personal details
meterInfo	         Meter installation and details
depositDetails	   Track deposits made by customers
bill_Details	     Records of generated bills
payBill	           Unpaid bills information
paymentBill	       Completed payments
view_Information	 View-only info on customers
updateInformation	 Editable customer info

# Features
✅ Splash screen with loading animation
✅ User/Admin Login & Signup
✅ Add / View / Update Customer Details
✅ Add and manage Meter Info
✅ Generate monthly bills
✅ View bill and deposit history
✅ Make and track payments
✅ Calculate charges dynamically based on meter reading

# How to Setup
# 1. Install Requirements
Java JDK 8+
MySQL Server
JDBC MySQL Connector (add to your project's classpath)

# 2. MySQL Configuration
# 2.1 Create database:
sql CREATE DATABASE electricity_billing;

# 2.2 Use provided schema file (e.g., schema.sql) to set up tables:
mysql -u root -p electricity_billing < schema.sql

# 2.3 Update your JDBC connection in each class with database access (e.g., Login.java, DBConnection.java):
java
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/electricity_billing", "root", "your_password");

# How to Run
1. Clone or download the repository.
2. Open in your IDE and make sure all .java files are in the correct package/folder structure.
3. Add the MySQL JDBC Driver to your classpath.
4. Compile and run:
# javac *.java
# java main_class

# Sample Admin Login
Username: admin
Password: admin123

