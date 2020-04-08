package com.ig.javacourse.finalProject;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

//import com.sun.jdi.connect.spi.Connection;
public class Registration9 extends JFrame {
	/**
	*
	*/
// private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration9 frame = new Registration9();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		JTextPane textPane = new JTextPane();
		contentPane.add(textPane, BorderLayout.CENTER);
		JTextPane customer = new JTextPane();
		customer.setBounds(154, 64, 171, 23);
		contentPane.add(customer);
		JTextPane email = new JTextPane();
		email.setBounds(154, 114, 171, 23);
		contentPane.add(email);
		JTextPane phone = new JTextPane();
		phone.setBounds(154, 160, 171, 20);
		contentPane.add(phone);
		JLabel customer_name = new JLabel("Name");
		customer_name.setBounds(106, 64, 93, 23);
		contentPane.add(customer_name);
		JLabel customer_email = new JLabel("Email");
		customer_email.setBounds(106, 114, 93, 23);
		contentPane.add(customer_email);
		JLabel user_phone = new JLabel("Phone");
		user_phone.setBounds(106, 157, 93, 23);
		contentPane.add(user_phone);
		JTextPane adress = new JTextPane();
		adress.setBounds(154, 211, 171, 23);
		contentPane.add(adress);
		JLabel user_adress = new JLabel("Address");
		user_adress.setBounds(96, 211, 58, 23);
		contentPane.add(user_adress);
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(154, 124, 28, -46);
		contentPane.add(textPane_1);
		JLabel book = new JLabel("Registration");
		book.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		book.setBounds(178, 6, 224, 38);
		contentPane.add(book);
		JRadioButton visa = new JRadioButton("Visa");
		visa.setBounds(154, 258, 58, 23);
		contentPane.add(visa);
		JRadioButton mastercard = new JRadioButton("MasterCard");
		mastercard.setBounds(224, 258, 103, 23);
		contentPane.add(mastercard);
		JLabel type = new JLabel("Payment type");
		type.setBounds(65, 259, 93, 23);
		contentPane.add(type);
		JTextPane number = new JTextPane();
		number.setBounds(154, 293, 171, 23);
		contentPane.add(number);
		JLabel credit_number = new JLabel("Credit Card Number");
		credit_number.setBounds(18, 293, 152, 23);
		contentPane.add(credit_number);
		JLabel cvv_name = new JLabel("CVV");
		cvv_name.setBounds(341, 293, 37, 23);
		contentPane.add(cvv_name);
		JTextPane cvv = new JTextPane();
		cvv.setBounds(374, 293, 41, 23);
		contentPane.add(cvv);
		JLabel expiration = new JLabel("Expiration Date");
		expiration.setBounds(43, 338, 109, 23);
		contentPane.add(expiration);
		JTextPane exp1 = new JTextPane();
		exp1.setBounds(154, 338, 85, 23);
		contentPane.add(exp1);
		JLabel cvv_name_1 = new JLabel("/");
		cvv_name_1.setBounds(242, 338, 28, 23);
		contentPane.add(cvv_name_1);
		JTextPane exp2 = new JTextPane();
		exp2.setBounds(251, 338, 85, 23);
		contentPane.add(exp2);
		JButton registration = new JButton("Registration");
		registration.setBounds(187, 373, 117, 29);
		contentPane.add(registration);

		JLabel success = new JLabel("");
		success.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		success.setBounds(138, 414, 224, 38);
		contentPane.add(success);
		registration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:8889/Hotel",
							"ion_gutu", "HelloWorld1234");
					PreparedStatement ps = conn.prepareStatement(
							"insert into customers(customer_name, customer_email, customer_phone, customer_address, type, card_number, cvv_name, expiration ) values(?,?,?,?,?,?,?,?)");
					ps.setString(1, customer.getText());
					ps.setString(2, email.getText());
					ps.setString(3, phone.getText());
					ps.setString(4, adress.getText());
					if (visa.isSelected()) {
						ps.setString(5, "V");
					} else if (mastercard.isSelected()) {
						ps.setString(5, "M");
					} else {
						ps.setString(5, "");
					}
					ps.setString(6, number.getText());
					ps.setString(7, cvv.getText());
					ps.setString(8, exp1.getText() + "/" + exp2.getText());
					int x = ps.executeUpdate();
					if (x > 0) {
						System.out.println("Registration is done successfully.");
						success.setText("Booking successful");
					} else {
						System.out.println("Registration failed.");
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}
			}
		});
	}
}